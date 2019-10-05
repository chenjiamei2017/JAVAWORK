package com.demo;




import java.util.HashMap;
import java.util.Map;
import java.text.Annotation;
import java.lang.reflect.Field;
public class TableInfo {
	private String tableName;//表的名称
	private Class<?>clazz;				//该表对应的实体类型信息类
	private boolean needPersist=false;  //是否需要持久化存储
	private Map<String,ColumnInfo>columns=new HashMap<String,ColumnInfo>();
	public TableInfo parse(Class<?>clazz)
	{
		this.clazz=clazz;
		this.tableName=clazz.getSimpleName();
		Annotation[] annotations=(Annotation[]) this.clazz.getAnnotations();
		for(Annotation annotation:annotations)
		{
			this.needPersist=true;
			Entity entity=(Entity)annotation;
			if(!entity.value().equals(""))
				this.tableName=entity.value();
			break;
			
		}
		
		if(this.needPersist)//如果需要持久化存储，遍历生成字段信息
		{
			Field[] fields=this.clazz.getDeclaredFields();
			for(Field field:fields)
			{
				ColumnInfo column=new ColumnInfo();
				column=column.parse(field);
				if(column!=null)
					this.columns.put(field.getName(), column);
			}
		}
	return this;
	}
	public String toString()
	{
		StringBuilder sql=new StringBuilder();
		sql.append(Symbol.LiNE);
		sql.append("CREATE TABLE");
		sql.append(this.tableName+Symbol.BLANK);
		sql.append(")");
		for(ColumnInfo column:this.columns.values())
		{
			sql.append(Symbol.LiNE);
			sql.append(Symbol.TAB);
			sql.append(column.toString());
			
			
		}
		sql.append(Symbol.LiNE);
		sql.append(")");
		return sql.toString();
	}
}


/*根据类型信息，获取实体类的简单名称作为表名
 * 获取在该类上使用的注解集合
 * 遍历这些集合
 * 如果发现这些集合含有@Entity注解，则表明该实体需要持久化存储，然后获取@Entity注解的参数value
 * 如果参数不为空，则表名设为此参数值，跳出循环
 * 如果没有找到该注解，则说明该实体不需要持久化存储，返回null
 * 如果该实体需要持久化存储，则遍历该实体类型信息的所有属性描述对象列表，并将它们转换成表的字段信息对象
 * 添加到字段map中
 * 返回解析好的表信息实体
 */
