//Capítulo 10 Exercício 10.11: Classe PieceWorker que extende Employee

public class PieceWorker extends Employee 
{
   private double wage; // wage per hour
   private double pieces; // hours worked for week

   // five-argument constructor
   public PieceWorker( String first, String last, String ssn, 
      double hourlyWage, double piecesMade )
   {
      super( first, last, ssn );
      setWage( hourlyWage ); // validate and store hourly wage
      setPieces( piecesMade ); // validate and store hours worked
   } // end five-argument HourlyEmployee constructor

   // set wage
   public void setWage( double hourlyWage )
   {
      wage = ( hourlyWage < 0.0 ) ? 0.0 : hourlyWage;
   } // end method setWage

   // return wage
   public double getWage()
   {
      return wage;
   } // end method getWage

   // set pieces made
   public void setPieces( double peicesMade )
   {
      pieces = ( peicesMade >= 0.0 ) ? peicesMade : 0.0;
   } // end method setHours

   // return peices made
   public double getPieces()
   {
      return pieces;
   } // end method getHours

   // calculate earnings; override abstract method earnings in Employee
   public double earnings()
   {
      return getPieces()*getWage();
   } // end method earnings

   // return String representation of HourlyEmployee object
   public String toString()
   {
      return String.format( "Piecer Worker employee: %s\n%s: $%,.2f; %s: %,.2f", 
         super.toString(), "piece wage", getWage(), 
         "pieces made", getPieces() );
   } // end method toString
} // end class HourlyEmployee
