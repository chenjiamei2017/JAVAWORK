package com.demo;

import java.lang.reflect.Field;
import java.text.Annotation;

//获取Field对象的名称，作为字段名称
//获取Fiele对象的类型，作为字段的类型
//获取该属性上声明的注解集合，并遍历这些注解，
//如果注解是@Column，则表明该属性应映射成数据库的字段
//如果注解是@ID,则表明该属性作为数据库表的主键
//判断该属性是否需要持久化，如需要返回解析后的字段信息对象
public class ColumnInfo {
	private String ColumnName;//字段名称
	private Class<?>type;		//字段类型
	private boolean isID=false;//是否为主键
	private boolean nullable=true;//是否可以为空
	private int length=32;			//字段长度
	private boolean needPersist=false;  //字段是否需要保存到数据中
	public ColumnInfo parse(Field field)
	{
		this.ColumnName=field.getName();
		this.type=field.getType();
		Annotation [] annotations=(Annotation[]) field.getAnnotations();
		for(Annotation annotation:annotations)
		{
			if(annotation.getClass().equals(Column.class))//如果注解是@Column
			{
			this.needPersist=true;
			Column column=(Column)annotation;
			if(!column.value().equals(""))//如果value不为空，则将字段名设置成注解value的参数值
				this.ColumnName=column.value();
			this.nullable=column.nullable();
			if(column.length()!=-1)//若length不为空，则设置字段的长度值
				this.length=column.length();
			}
			else if(annotation.getClass().equals(ID.class))//如果注解是@ID
			{
				this.needPersist=true;//保存到数据库中
			ID id=(ID)annotation;
			this.isID=true;//注释是主键
			if(!id.value().equals(""))//如果用户设置了value的值，则以value值作为字段名
				this.ColumnName=id.value();
			}
			
			}
		
		if(this.needPersist)
			return this;
		else
			return null;
	}
	@Override
	public String toString()
	{//将字段信息对象输出成SQL语句
		
		StringBuilder sql=new StringBuilder(ColumnName);
		if(this.type.equals(String.class))
			sql.append(Symbol.BLANK+"VARCHAR("+this.length+")");
		else if(this.type.equals(Integer.class))
			sql.append(Symbol.BLANK+"INT");
		if(!this.isID)
			sql.append(Symbol.BLANK+"PRIMARY");
		if(!this.nullable)
		sql.append(Symbol.BLANK+"NOT NULL");
		sql.append(";");
		return sql.toString();
	}
	
	
	
	
}
	
