import java.util.Scanner;

public class StaticTest
{
	private static int numero;
	
	public static int inverter( int numeroVal )
	{
		int numeroTemp = numeroVal;
		String stringRes = "";
		int numeroRes = 0;
		int value = 0;
		
		while( (numeroTemp >= 10) )
		{
			value = numeroTemp % 10;
			numeroTemp = (int) Math.floor( numeroTemp / 10 );
			
			stringRes += value;	
		}
		stringRes += numeroTemp;
		
		numeroRes = Integer.parseInt( stringRes );
		return numeroRes;
	}
	
	public static void main( String args[] )
	{	
		Scanner input = new Scanner( System.in );
		
		StaticTest.numero = input.nextInt();
		
		System.out.println( StaticTest.numero );
		System.out.println( StaticTest.inverter( StaticTest.numero) );
	}
}