package com.java1;

public class Onload extends Menu {
	public Onload() {
		// TODO 自动生成的构造函数存根
	}
	public int id;
	void OnList()
	{
		System.out.println("线性表存储");
	}
	void OnStackAndQueue() {
		System.out.println("邻接表存储");
	}
	void OnString() {
		System.out.println("十字链表存储");
	}
	void OnExit() {
	}
	
	public void Show(){
		System.out.println( "**************图的存储*******************\n");
		System.out.println("*\t1、线性表\n*\t2、邻接表\n*\t3、十字链表\n*0、退出\n");
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
		case 3:
			OnString();
			break;
		case 0:
			OnExit();
			break;
		default:
			OnInvilidate();
			break;
		}
	}
	


void OnInvilidate() {
	System.out.println("命令选项错误\n");

}
}
