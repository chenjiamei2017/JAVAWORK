package differenceStr;

public class StrTest {
	public static void main(String[] args)
	{
	testString();
	testStringBuilder();
	testString1();
	testString2();
		
		
	}
	/*
	 * String�ǲ��ɱ䳤�ȵ��ַ������ͣ������������ַ�ʱ��ÿ����һ�ζ�Ҫ�¿���һ�δ洢�ռ�
	 * StringBuilder�ǿɱ䳤�ȵ��ַ������ͣ����������ַ�ʱ��ֱ����ĩβ�ӣ�����Ҫ�����µĴ洢�ռ�
	 * �����ڼ򵥵��ַ������ӣ�StringBuilder��һ����������String����Ϊ���󴴽����۴�
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	public static void testString()
	{	
		String s="";

		long begin=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
		{
			s+="java";
		}
		long over=System.currentTimeMillis();
		System.out.println("����"+s.getClass().getName()+"����ʹ��ʱ��"+(over-begin)+"����");
	}
	public static void testStringBuilder()
	{
		StringBuilder str=new StringBuilder();
		long begin=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
			str.append("java");
		long over=System.currentTimeMillis();
		System.out.println("����"+str.getClass().getName()+"����ʹ��ʱ��"+(over-begin)+"����");
	}
	public static void testString1()
	{	
		String s="";

		long begin=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
		{
			s="I"+"LOVE"+"YOU";
		}
		long over=System.currentTimeMillis();
		System.out.println("�ַ���ֱ�����ʱ��"+s.getClass().getName()+"����ʹ��ʱ��"+(over-begin)+"����");
	}
	public static void testString2()
	{	
		String s1="I";
		String s2="LOVE";
		String s3="YOU";
		String s="";
		long begin=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
		{
			s=s1+s2+s3;
		}
		long over=System.currentTimeMillis();
		System.out.println("�ַ���������ʱ��"+s.getClass().getName()+"����ʹ��ʱ��"+(over-begin)+"����");
	}
}

