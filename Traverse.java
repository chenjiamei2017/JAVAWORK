package com.java1;

public class Traverse extends Menu {

	public Traverse() {	// TODO �Զ����ɵĹ��캯�����}
		
	}
	void OnList() {
		System.out.println("��ȱ���");
	}
	void OnStackAndQueue() {
		System.out.println("��ȱ���");
	}
	void OnString() {}
	public void Show(){
		System.out.println( "**************ͼ�ı���*******************\n");
		System.out.println("*\t1����ȱ���\n*\t2����ȱ���\n*0���˳�\n");
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
		System.out.println("����ѡ�����\n");
	}
	
	
	
	
}
