public class VarArgs
{
	public static void print(int max, Integer... x)
	{
		for( int i = 0; (i < max) && (i < x.length ); i++ )
			System.out.print(x[i] + " ");
	}
	
	public static void print(int max, Double... x)
	{
		for( int i = 0; (i < max) && (i < x.length ); i++ )
			System.out.print(x[i] + " ");
	}
	
	public static void print(int max, String... x)
	{
		for( int i = 0; (i < max) && (i < x.length ); i++ )
			System.out.print(x[i] + " ");
	}
	
	public static void main(String... args)
	{
		VarArgs.print(4, 1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println();
		VarArgs.print(4, 1.0, 2.0);
		System.out.println();
		VarArgs.print(6, "Atchim", "Sniff", "Snong");
	}
}