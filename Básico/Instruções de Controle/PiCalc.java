import java.util.Scanner;

public class PiCalc
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner( System.in );
		int i = input.nextInt();
		int k = 1;
		double den = 1.0;
		double pi = 0.0;
		
		do
		{
			pi += - ( (double) ( (4 / den) * Math.pow(-1, k) ) );
			System.out.printf("%6d --- %f\n", k , pi );		
			k++;
			den += 2.0;
			
		}while( k <= i );
	}
}