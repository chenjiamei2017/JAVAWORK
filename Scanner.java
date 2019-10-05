package com.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarFile;

public class Scanner {
	
	public static List<File> getClassFiles(String url)
	{
		//List<Class> clazzs = new ArrayList<Class>();

		try {
			File f = new File(url);
			if (f.isDirectory()) {
				File[] fList = f.listFiles();
				for (int j = 0; j < fList.length; j++) {
					if (fList[j].isDirectory()) {}
				}
				for (int j = 0; j < fList.length; j++) {
					if (fList[j].isFile()) {
						String name = fList[j].getPath().toString();
						System.out.println("Filename is: " + name);
						mfiles.add(fList[j].getPath());
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error£º " + e);

	}
	

}
