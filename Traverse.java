package com.java1;

public class Traverse extends Menu {

	public Traverse() {	// TODO 自动生成的构造函数存根}
		
	}
	void OnList() {
		System.out.println("深度遍历");
	}
	void OnStackAndQueue() {
		System.out.println("广度遍历");
	}
	void OnString() {}
	public void Show(){
		System.out.println( "**************图的遍历*******************\n");
		System.out.println("*\t1、深度遍历\n*\t2、广度遍历\n*0、退出\n");
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
			//OnExit();
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
