public class GenericMethodPrint
{
	public static <E> void print( E[] element )
	{
		for( E data: element )
			System.out.printf(" %s ", data);
		
		System.out.println();
	}
	
	public static void print( String[] element )
	{
		for( String data: element )
			System.out.printf(" %-10s ", data);
		
		System.out.println();
	}
	
	public static void main( String[] args )
	{
		Integer[] dataInt = new Integer[] { 1, 2, 3, 4, 5};
		Double[] dataDob = new Double[] { 1.0, 2.1, 3.2, 4.3, 5.4};
		String[] dataStr = new String[] { "Ana", "Cláudia", "Nasquewitz", "Machado" };
		
		print( dataInt );
		print( dataDob );
		print( dataStr );
	}
}