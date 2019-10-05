package com.demo;

import java.lang.reflect.Field;
import java.text.Annotation;

//��ȡField��������ƣ���Ϊ�ֶ�����
//��ȡFiele��������ͣ���Ϊ�ֶε�����
//��ȡ��������������ע�⼯�ϣ���������Щע�⣬
//���ע����@Column�������������Ӧӳ������ݿ���ֶ�
//���ע����@ID,�������������Ϊ���ݿ�������
//�жϸ������Ƿ���Ҫ�־û�������Ҫ���ؽ�������ֶ���Ϣ����
public class ColumnInfo {
	private String ColumnName;//�ֶ�����
	private Class<?>type;		//�ֶ�����
	private boolean isID=false;//�Ƿ�Ϊ����
	private boolean nullable=true;//�Ƿ����Ϊ��
	private int length=32;			//�ֶγ���
	private boolean needPersist=false;  //�ֶ��Ƿ���Ҫ���浽������
	public ColumnInfo parse(Field field)
	{
		this.ColumnName=field.getName();
		this.type=field.getType();
		Annotation [] annotations=(Annotation[]) field.getAnnotations();
		for(Annotation annotation:annotations)
		{
			if(annotation.getClass().equals(Column.class))//���ע����@Column
			{
			this.needPersist=true;
			Column column=(Column)annotation;
			if(!column.value().equals(""))//���value��Ϊ�գ����ֶ������ó�ע��value�Ĳ���ֵ
				this.ColumnName=column.value();
			this.nullable=column.nullable();
			if(column.length()!=-1)//��length��Ϊ�գ��������ֶεĳ���ֵ
				this.length=column.length();
			}
			else if(annotation.getClass().equals(ID.class))//���ע����@ID
			{
				this.needPersist=true;//���浽���ݿ���
			ID id=(ID)annotation;
			this.isID=true;//ע��������
			if(!id.value().equals(""))//����û�������value��ֵ������valueֵ��Ϊ�ֶ���
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
	{//���ֶ���Ϣ���������SQL���
		
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
	
