import java.util.Scanner;

public class Criptography
{
	private int data;
	
	public Criptography ( int dataVal )
	{
		setData( dataVal );
	}
	
	public void setData( int dataVal )
	{
		if( (dataVal > 9999) || (dataVal < 1000) )
			data = 1000;
		else
			data = dataVal;
		
		criptographyData( data );
	}
	
	public int getData()
	{
		return data;
	}
	
	private void criptographyData( Integer dataVal )
	{
		String digitString = dataVal.toString();
		int digit1 = Integer.parseInt( digitString.substring(0, 1) );
		int digit2 = Integer.parseInt( digitString.substring(1, 2) );
		int digit3 = Integer.parseInt( digitString.substring(2, 3) );
		int digit4 = Integer.parseInt( digitString.substring(3, 4) );
		int digitTemp1;
		int digitTemp2; 
		
		digit1 = (digit1 + 7) % 10;
		digit2 = (digit2 + 7) % 10;
		digit3 = (digit3 + 7) % 10;
		digit4 = (digit4 + 7) % 10;
		
		digitTemp1 = digit1;
		digitTemp2 = digit2;
		
		digit1 = digit3;
		digit2 = digit4;
		digit3 = digitTemp1;
		digit4 = digitTemp2;
		
		data = (digit1 * 1000) + (digit2 * 100) + (digit3*10) + (digit4);
	}
	
	public int descriptography()
	{
		String digitString = String.valueOf( data );
		int digit1 = Integer.parseInt( digitString.substring(0, 1) );
		int digit2 = Integer.parseInt( digitString.substring(1, 2) );
		int digit3 = Integer.parseInt( digitString.substring(2, 3) );
		int digit4 = Integer.parseInt( digitString.substring(3, 4) );
		int digitTemp1;
		int digitTemp2;
		int digitRes;
		
		digitTemp1 = digit1;
		digitTemp2 = digit2;
		digit1 = digit3;
		digit2 = digit4;
		digit3 = digitTemp1;
		digit4 = digitTemp2;
		
		digit1 = digit1 - 7;
		digit2 = digit2 - 7;
		digit3 = digit3 - 7;
		digit4 = digit4 - 7;
		
		digit1 = (digit1 < 0) ? (10 + digit1) : digit1;
		digit2 = (digit2 < 0) ? (10 + digit2) : digit2;
		digit3 = (digit3 < 0) ? (10 + digit3) : digit3;
		digit4 = (digit4 < 0) ? (10 + digit4) : digit4;
		
		digitRes = (digit1 * 1000) + (digit2 * 100) + (digit3*10) + (digit4);
		
		return digitRes;
	}
	
	public static void main( String[] args)
	{
		Scanner input = new Scanner( System.in );
		int dataVal = input.nextInt();
		
		Criptography app = new Criptography( dataVal );
		System.out.println( app.getData() );
		System.out.println( app.descriptography() );
	}
}