import java.util.Scanner;

public class Interest
{
	public static void main(String args[])
	{
		double amount;
		double principal = 1000.0;
		double rate;
		
		for( int i = 5; i <= 10; i++ )
		{
			System.out.printf("------- Taxa %d %c --------\n", i, '%');
			rate = (double) i / 100.0;
			
			System.out.printf( "%s%20s \n", "Ano", "Valor em Deposito" );
			for( int year = 1; year <= 10; year++)
			{
				amount = principal * Math.pow(1.0 + rate, year);
				System.out.printf("%4d%,20.2f\n", year, amount);
			}
			System.out.println();
		}
	}
}