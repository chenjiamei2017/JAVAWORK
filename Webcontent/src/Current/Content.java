package Current;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.omg.CORBA.portable.InputStream;

public class Content {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		   System.out.println("hello world !!!");

	        try {
	            //����һ��URLʵ��
	            URL url = new URL("http://www.sina.com");

	            try {
	                //ͨ��URL��openStrean������ȡURL��������ʾ����Ը�ֽ�������
	                InputStream is = (InputStream) url.openStream();
	                InputStreamReader isr = new InputStreamReader(is,"utf-8");

	                //Ϊ�ַ���������ӻ���
	                BufferedReader br = new BufferedReader(isr);
	                String data = br.readLine();//��ȡ����

	                while (data!=null){//ѭ����ȡ����
	                    System.out.println(data);//�������
	                    data = br.readLine();
	                }
	                br.close();
	                isr.close();
	                is.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	    }
	}


