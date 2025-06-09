public class ComandLine
{
	public static void main(String[] args)
	{
		int length = 10;
		int [] vector;
		
		if( args.length == 1 )
			length = Integer.parseInt( args[0] );
		
		vector = new int[length];
		
		for( int i = 0; i < vector.length; i++ )
			vector[i] = ( ( (i + 7) * 3 ) / 5 ) - 1;
		
		for( int i: vector )
			System.out.println(i);
	}
}