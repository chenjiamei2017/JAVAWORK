package com.demo;

public class AnnotationTest {

	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		
		TablaProcessor processor=new TablaProcessor();
		String sql=processor.Process(System.getProperty("user.dir"));
		
		System.out.println(sql);
	}

}
