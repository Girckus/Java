public class Time2Test 
{
   public static void main( String args[] )
   {
      Time2 t1 = new Time2();             // 00:00:00
      Time2 t2 = new Time2( 2 );          // 02:00:00
      Time2 t3 = new Time2( 21, 34 );     // 21:34:00
     
      System.out.println( "Setting t1.hour to 24" );
	  if(!t1.setHour(24))
	      System.out.println("Error: Hour has to bet between 0 and 23. Setting to 0");
	  else
		  System.out.println("Setted");
		  
      System.out.println( "Setting t2.second to 3" );
	  if(!t2.setSecond(3))
	      System.out.println("Error: Second has to bet between 0 and 59. Setting to 0");
	  else
		  System.out.println("Setted");
	  
	  System.out.println( "Setting t3.minute to 100" );
	  if(!t3.setMinute(100))
	      System.out.println("Error: Minute has to bet between 0 and 59. Setting to 0");
	  else
          System.out.println("Setted");
   } // end main
} // end class Time2Test
