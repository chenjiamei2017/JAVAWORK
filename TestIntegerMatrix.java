
public class TestIntegerMatrix {
	
	public static void main(String[] args)
	{
		System.out.println("数组一为");

		Integer m1[][]={{1,2,3},{4,5,6},{1,1,1}};
				IntegerMatrix.printResult(m1);
				System.out.println("数组二为");
		Integer[][] m2={{1,1,1},{2,2,2},{0,0,0}};
		IntegerMatrix.printResult(m2);
		IntegerMatrix integerMatrix=new IntegerMatrix();
		System.out.println("两数组相加为");
		IntegerMatrix.printResult(integerMatrix.addMatrix(m1, m2));
		System.out.println("两数组相乘为");
		IntegerMatrix.printResult(integerMatrix.multiplyMatrix(m1, m2));
		
	
}}
