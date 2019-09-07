package com.java1;
import java.util.Scanner;

import com.java1.Onload;
import com.java1.Test;
import com.java1.Traverse;
public class Menu {

	void OnList() {
		Onload onLoad=new Onload();
		onLoad.Show();
		Scanner reader=new Scanner(System.in);
		int id=reader.nextInt();
		onLoad.DoEvent(id);  
		
	}
	void OnStackAndQueue() {
		Traverse travel=new Traverse();
		travel.Show();
		Scanner reader=new Scanner(System.in);
		int id=reader.nextInt();
		travel.DoEvent(id);
	}

	void OnInvilidate() {
		System.out.println("命令选项错误\n");
	}
	Menu() {}
	public void Show(){
		System.out.println( "**************数据结构*******************\n");
		System.out.println("*\t1、图的存储\n*\t2、图的遍历\n\t*0、退出\n");
		System.out.println("*****************************************\n");
	}
	public void DoEvent(int ID){
		switch (ID)
		{
		case 1:
			OnList();
			break;   
		case 2:
			OnStackAndQueue();
			break;

		case 0:
			break;
		default:
			OnInvilidate();
			break;
		}
	}
}

