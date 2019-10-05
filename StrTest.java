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
	 * String是不可变长度的字符串类型，当给他增加字符时，每增加一次都要新开辟一次存储空间
	 * StringBuilder是可变长度的字符串类型，给他增加字符时，直接在末尾加，不需要开辟新的存储空间
	 * 但对于简单的字符串连接，StringBuilder不一定总是优于String，因为对象创建代价大
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
		System.out.println("操作"+s.getClass().getName()+"类型使用时间"+(over-begin)+"毫秒");
	}
	public static void testStringBuilder()
	{
		StringBuilder str=new StringBuilder();
		long begin=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
			str.append("java");
		long over=System.currentTimeMillis();
		System.out.println("操作"+str.getClass().getName()+"类型使用时间"+(over-begin)+"毫秒");
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
		System.out.println("字符串直接相加时间"+s.getClass().getName()+"类型使用时间"+(over-begin)+"毫秒");
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
		System.out.println("字符串间接相加时间"+s.getClass().getName()+"类型使用时间"+(over-begin)+"毫秒");
	}
}

