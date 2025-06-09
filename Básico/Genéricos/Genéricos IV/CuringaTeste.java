import java.util.List;
import java.util.ArrayList;

public class CuringaTeste
{
	private List<Integer> intList = new ArrayList<Integer>();
	private List<Double> doubleList = new ArrayList<Double>();
	private List<Long> longList = new ArrayList<Long>();
	private List<Number> numberList = new ArrayList<Number>();
	
	public CuringaTeste()
	{
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		doubleList.add(3.3);
		doubleList.add(4.4);
		doubleList.add(5.5);
		
		longList.add( 10L );
		longList.add( 11L );
		longList.add( 12L );
	}
	
	public void imprime( List<? extends Number> list )
	{
		System.out.println( list );
	}
	
	public void adiciona( List<? super Integer> list, Integer elemento)
	{
		list.add( elemento );
	}
	
	public void adiciona( List<? super Double> list, Double elemento )
	{
		list.add( elemento );
	}
	
	public void adiciona( List<? super Long> list, Long elemento )
	{
		list.add( elemento );
	}
	
	public List<Integer> getIntList( )
	{
		return intList;
	}
	
	public List<Double> getDoubleList( )
	{
		return doubleList;
	}
	
	public List<Long> getLongList( )
	{
		return longList;
	}
	
	public List<Number> getNumberList( )
	{
		return numberList;
	}
	
	public static void main( String[] args )
	{
		CuringaTeste app = new CuringaTeste();
		
		app.imprime( app.getIntList() );
		app.imprime( app.getDoubleList() );
		app.imprime( app.getLongList() );
		
		for( int i=0; i < app.getIntList().size(); i++ )
			app.adiciona( app.getNumberList(), app.getIntList().get(i) );
			
		for( int i=0; i < app.getDoubleList().size(); i++ )
			app.adiciona( app.getNumberList(), app.getDoubleList().get(i) );
			
		for( int i=0; i < app.getLongList().size(); i++ )
			app.adiciona( app.getNumberList(), app.getLongList().get(i) );
			
		app.imprime( app.getNumberList() );
	}
}
