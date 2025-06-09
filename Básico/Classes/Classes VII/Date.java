public class Date
{
	private String exit;

   // Date constructor with three integers
   public Date( int theMonth, int theDay, int theYear ) 
   { 
      if ( setDate( theMonth, theDay, theYear ) )
		exit = String.format("%2d/%2d/%4d", theDay, theMonth, theYear);
	  else
	    exit = String.format("ERRO");
   }  

   // Date constructor with two integers and a String
   public Date( String theMonth, int theDay, int theYear ) 
   { 
	  if ( !setDate( 1 , theDay, theYear ) )
		exit = String.format("ERRO");
	  
	  boolean validMonth = false;
	  
	  if( theMonth.equals("January") )
		validMonth = true;
	  if( theMonth.equals("February") )
		validMonth = true;
	  if( theMonth.equals("March") )
		validMonth = true;
	  if( theMonth.equals("April") )
	  	validMonth = true;
	  if( theMonth.equals("May") )
		validMonth = true;
	  if( theMonth.equals("June") )
		validMonth = true;
	  if( theMonth.equals("July") )
	 	validMonth = true;
	  if( theMonth.equals("August") )
	 	validMonth = true;
	  if( theMonth.equals("September") )
	 	validMonth = true;
	  if( theMonth.equals("Octuber") )
	  	validMonth = true;
	  if( theMonth.equals("November") )
	  	validMonth = true;
	  if( theMonth.equals("December") )
	  	validMonth = true;
		
	  if( !validMonth)
			exit = String.format("ERRO");
	  else
			exit = String.format("%s %2d, %4d", theMonth, theDay, theYear);
   }
 
   // Date constructor with two integers
   public Date( int theDays, int theYear ) 
   { 
      if( !setDate( 1, 1, theYear ) )
		exit = String.format("ERRO");
	  else
	  {
		if( (theDays < 0) || (theDays > 365) )
			exit = String.format("ERRO");
		else
			exit = String.format("%3d %4d", theDays, theYear);
	  }
   }

   // Set Methods
   // set a new time value using universal time; ensure that 
   // the data remains consistent by setting invalid values to zero
   public boolean setDate( int theMonth, int theDay, int theYear )
   {
	  if ( checkMonth( theMonth ) && checkYear( theYear ) && checkDay( theDay, theMonth, theYear ) )
		return true;
	  else
		return false;
   } // end method setTime

   // utility method to confirm proper month value
   private boolean checkMonth( int testMonth )
   {
      if ( testMonth > 0 && testMonth <= 12 ) // validate month
         return true;
      else // month is invalid 
      { 
         System.out.printf( 
            "Invalid month (%d).", testMonth );
         return false; // maintain object in consistent state
      } // end else
   } // end method checkMonth

   // utility method to confirm proper day value based on month and year
   private boolean checkDay( int testDay, int theMonth, int theYear )
   {
      int daysPerMonth[] = 
         { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
   
      // check if day in range for month
      if ( testDay > 0 && testDay <= daysPerMonth[ theMonth ] )
         return true;
   
      // check for leap year
      if ( theMonth == 2 && testDay == 29 && ( theYear % 400 == 0 || 
           ( theYear % 4 == 0 && theYear % 100 != 0 ) ) )
         return true;
   
      System.out.printf( "Invalid day (%d).", testDay );
      return false;  // maintain object in consistent state
   } // end method checkDay
   
   // utility method to confirm proper year value
   private boolean checkYear( int testYear )
   {
      if ( testYear > 0 && testYear <= 9999 ) // validate month
         return true;
      else // month is invalid 
      { 
         System.out.printf( 
            "Invalid year (%d).", testYear );
         return false; // maintain object in consistent state
      } // end else
   } // end method checkMonth
   

   // Get Methods
   // get month value
   public String getExit() 
   { 
      return exit; 
   } // end method getMonth
} // end class Time2