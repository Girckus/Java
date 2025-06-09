class BadFoodException extends Exception{}

public class MyException
{
	String[] list_food = {"apple", "pineapple", "eggplant", "soybean", "peneaut", "squash", "strawberries", "watermaleon"};

    public boolean checkFood(String food) throws BadFoodException
	{
		boolean aceitavel = false;
		
		for(String f: list_food)
		{
			if( f.equals(food) )
				aceitavel = true;
		}
		
		if( !aceitavel )
			throw new BadFoodException();
		
		return aceitavel;
	}

	public static void main( String[] args)
	{
		try
		{
			if( new MyException().checkFood( args[0] ) )
				System.out.println("Good Food");
		}
		catch( BadFoodException e )
		{
			System.out.println("Bad Food");
		}
	}
}