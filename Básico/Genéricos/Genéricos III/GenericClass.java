public class GenericClass<F,S>
{
	private F first;
	private S second;
	
	public GenericClass( F first, S second )
	{
		this.first = first;
		this.second = second;
	}
	
	public void setFirst( F first )
	{
		this.first = first;
	}
	
	public void setSecond( S second )
	{
		this.second = second;
	}
	
	public F getFirst()
	{
		return this.first;
	}
	
	public S getSecond()
	{
		return this.second;
	}
	
	public static void main( String[] args )
	{
		GenericClass<String,Integer> classeGenerica1 = new GenericClass<String,Integer>( "Ana", 13 );
		
		System.out.println( classeGenerica1.getFirst() + "-" + classeGenerica1.getSecond() );
		classeGenerica1.setFirst( "Cláudia" );
		classeGenerica1.setSecond( 21 );
		System.out.println( classeGenerica1.getFirst() + "-" + classeGenerica1.getSecond() );
	
		GenericClass classeGenerica2 = new GenericClass( 33.3, 15);
		
		System.out.println( classeGenerica2.getFirst() + "-" + classeGenerica2.getSecond() );
		classeGenerica2.setFirst( 12.3);
		classeGenerica2.setSecond( 10 );
		System.out.println( classeGenerica2.getFirst() + "-" + classeGenerica2.getSecond() );
	}
}