package com.java1;

public class Onload extends Menu {
	public Onload() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public int id;
	void OnList()
	{
		System.out.println("���Ա�洢");
	}
	void OnStackAndQueue() {
		System.out.println("�ڽӱ�洢");
	}
	void OnString() {
		System.out.println("ʮ������洢");
	}
	void OnExit() {
	}
	
	public void Show(){
		System.out.println( "**************ͼ�Ĵ洢*******************\n");
		System.out.println("*\t1�����Ա�\n*\t2���ڽӱ�\n*\t3��ʮ������\n*0���˳�\n");
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
	System.out.println("����ѡ�����\n");

}
}
