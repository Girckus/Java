public class XMasSong
{
	public static void main(String[] args)
	{
		System.out.println("The Twelve days of Christmas\n\n");
		
		String frase;
		
		for(int i = 1; i <= 12; i++)
		{
			frase = "On the ";
			
			switch( i )
			{
				case 1: frase += "first";
						break;
				case 2: frase += "second";
						break;
				case 3: frase += "third";
						break;
				case 4: frase += "fourth";
						break;
				case 5: frase += "fifth";
						break;
				case 6: frase += "sixth";
						break;
				case 7: frase += "seventh";
						break;
				case 8: frase += "eighth";
						break;
				case 9: frase += "nineth";
						break;
				case 10: frase += "tenth";
						break;
				case 11: frase += "eleventh";
						break;
				case 12: frase += "twelfth";
						break;
				default: System.out.println("Error");
			}
			
			frase += " day of Christmas";
			
			System.out.println(frase);
			System.out.println("my true love sent to me:");
			
			frase = "";
			
			switch( i )
			{
				case 12: frase += "12 Drummers Drumming\n";
				case 11: frase += "Eleven Pipers Piping\n";
				case 10: frase += "Ten Lords a Leaping\n";
				case 9: frase += "Nine Ladies Dancing\n";
				case 8: frase += "Eight Maids a Milking\n";
				case 7: frase += "Seven Swans a Swimming\n";
				case 6: frase += "Six Geese a Laying\n";
				case 5: frase += "Five Golden Rings\n";
				case 4: frase += "Four Calling Birds\n";
				case 3: frase += "Three French Hens\n";
				case 2: frase += "Two Turtle Doves\nand a Partridge in a Pear Tree\n";
						break;
				case 1: frase += "A Partridge in a Pear Tree\n";
			}
			
			System.out.println(frase);
		}
		
	}
}