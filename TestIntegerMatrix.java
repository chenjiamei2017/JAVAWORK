
public class TestIntegerMatrix {
	
	public static void main(String[] args)
	{
		System.out.println("����һΪ");

		Integer m1[][]={{1,2,3},{4,5,6},{1,1,1}};
				IntegerMatrix.printResult(m1);
				System.out.println("�����Ϊ");
		Integer[][] m2={{1,1,1},{2,2,2},{0,0,0}};
		IntegerMatrix.printResult(m2);
		IntegerMatrix integerMatrix=new IntegerMatrix();
		System.out.println("���������Ϊ");
		IntegerMatrix.printResult(integerMatrix.addMatrix(m1, m2));
		System.out.println("���������Ϊ");
		IntegerMatrix.printResult(integerMatrix.multiplyMatrix(m1, m2));
		
	
}}
