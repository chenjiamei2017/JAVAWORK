package com.demo;
import java.io.File;
import java.util.List;

public class TablaProcessor implements IProcessor{
	@Override
	public String Process(String url) throws Exception {
		List<File> classFiles=Scanner.getClassFiles(url);
		StringBuilder sql=new StringBuilder();
		for(File file:classFiles)
		{
			Class<?>clazz=ClassFileLoader.loadClass(file);
			TableInfo table=table.parse(clazz);
			if(table!=null)
				sql.append(table.toString());
			
		}
		
		
		
		
		
		// TODO 自动生成的方法存根  
		return sql.toString();
	}

}
