package com.java1;
import java.util.*;
import com.java1.*;
public class Test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������	
	
		Menu test1=new Menu();
		test1.Show();
		int id=1;
		while(id!=0) {
			Scanner reader=new Scanner(System.in);
			id=reader.nextInt();
			test1.DoEvent(id);
		}
	}
}
