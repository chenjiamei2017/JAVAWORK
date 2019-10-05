package com.demo;




import java.util.HashMap;
import java.util.Map;
import java.text.Annotation;
import java.lang.reflect.Field;
public class TableInfo {
	private String tableName;//�������
	private Class<?>clazz;				//�ñ��Ӧ��ʵ��������Ϣ��
	private boolean needPersist=false;  //�Ƿ���Ҫ�־û��洢
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
		
		if(this.needPersist)//�����Ҫ�־û��洢�����������ֶ���Ϣ
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


/*����������Ϣ����ȡʵ����ļ�������Ϊ����
 * ��ȡ�ڸ�����ʹ�õ�ע�⼯��
 * ������Щ����
 * ���������Щ���Ϻ���@Entityע�⣬�������ʵ����Ҫ�־û��洢��Ȼ���ȡ@Entityע��Ĳ���value
 * ���������Ϊ�գ��������Ϊ�˲���ֵ������ѭ��
 * ���û���ҵ���ע�⣬��˵����ʵ�岻��Ҫ�־û��洢������null
 * �����ʵ����Ҫ�־û��洢���������ʵ��������Ϣ�������������������б���������ת���ɱ���ֶ���Ϣ����
 * ��ӵ��ֶ�map��
 * ���ؽ����õı���Ϣʵ��
 */
