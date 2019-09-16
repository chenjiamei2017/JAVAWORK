
public abstract class GenericMatrix <E extends Number> {
	protected abstract E add(E o1,E o2);
	protected abstract E multiply(E o1,E o2);
	protected abstract E zero();
	public E[][] addMatrix(E[][] matrix1,E[][] matrix2)
	{
		E[][] result =(E[][])new Number[matrix1.length][matrix1[0].length];
		if((matrix1.length!=matrix2.length)||matrix1[0].length!=matrix2[0].length)
		{
			throw new RuntimeException("The matrix do not have the same size");
		}
		for(int i=0;i<matrix1.length;i++)
		{
			for(int j=0;j<matrix1[i].length;j++)
				result[i][j]=add(matrix1[j][j],matrix2[i][j]);
		}
		return result;
	}
	
	public E[][]multiplyMatrix(E[][] matrix1,E[][]matrix2)
	{
		if(matrix1[0].length!=matrix2.length)
		{
			throw new RuntimeException("The matrices donot have compatible size");//行列不一致
			
		}
		E[][] result=(E[][])new Number[matrix1.length][matrix2[0].length];
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[0].length;j++)
			{
				result[i][j]=zero();
				for(int k=0;k<matrix1[i].length;k++)
					result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
			}
		}
		
		return result;
	}
	public static void printResult(Number[][] m1)
	{
		for(int i=0;i<m1.length;i++)
		{	for(int j=0;j<m1[0].length;j++)
				System.out.print( "\t"+m1[i][j]);
			System.out.println();
		
		
		}}}
