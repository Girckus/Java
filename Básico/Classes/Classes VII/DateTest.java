public class DateTest
{
	public static void main( String args[] )
	{
		Date date1 = new Date(19, 24, 2000);
		Date date2 = new Date("Bloblah", 15, 2000);
		Date date3 = new Date(500, 2000);
		Date date4 = new Date(12, 24, 100000);
		Date date5 = new Date(12, 24, 2000);
		Date date6 = new Date("April", 24, 2000);
		Date date7 = new Date(14, 2000);
		
		System.out.printf("\nDate1: %s\n", date1.getExit() );
		System.out.printf("\nDate2: %s\n", date2.getExit() );
		System.out.printf("\nDate3: %s\n", date3.getExit() );
		System.out.printf("\nDate4: %s\n", date4.getExit() );
		System.out.printf("\nDate5: %s\n", date5.getExit() );
		System.out.printf("\nDate6: %s\n", date6.getExit() );
		System.out.printf("\nDate7: %s\n", date7.getExit() );
	}
}