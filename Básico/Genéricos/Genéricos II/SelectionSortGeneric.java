public class SelectionSortGeneric
{
	public <T extends Comparable<T> > void selectionSort( T[] element )
	{
		int smallest;
	
		for(int i = 0; i < element.length - 1; i++)
		{
			smallest = i;
			System.out.println(element[smallest]);
			for(int j = i+1 ; j <  element.length; j++)
			{
				if( element[j].compareTo(element[smallest]) < 0 )
					smallest = j;
					System.out.println("	" + element[i] + " " + element[smallest]);
			}

			swap( i, smallest, element );
			System.out.println(element[i] + " " + element[smallest]);
		}
	}
	
	public <T extends Comparable<T> > void swap( int first, int second, T[] element )
	{
		T temp = element[first];
		element[first] = element[second];
		element[second] = temp;
	}
	
	public <T extends Comparable<T> > void print( T[] element)
	{ 
		for(T data: element)
			System.out.print(data.toString() + " ");
	}
	
	public static void main( String[] args )
	{
		SelectionSortGeneric sort = new SelectionSortGeneric();
		Integer[] dataInt = new Integer[] { 4, 7, 1, 10, 5, 3, 2, 9, 6, 8 };
		Double[] dataDob = new Double[] { 4.1, 7.4, 2.1, 2.4, 2.3, 9.4, 8.6, 7.7 };
		
		sort.selectionSort( dataInt );
		sort.selectionSort( dataDob );
		sort.print( dataInt );
		System.out.println();
		sort.print( dataDob );
	}
}