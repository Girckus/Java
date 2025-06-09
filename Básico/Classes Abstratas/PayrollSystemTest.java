//Capítulo 10 Exercício 10.11: Classe PayrollSystemTest e uma classe que testa as classes da hierarquia Employee disponibilizando
//informacoes sobre a folha de pagamento de um determinado funcionario

public class PayrollSystemTest 
{
   public static void main( String args[] ) 
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00 );
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40 );
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee( 
         "Sue", "Jones", "333-33-3333", 10000, .06 );
      BasePlusCommissionEmployee basePlusCommissionEmployee = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
	   PieceWorker pieceWorker =
	     new PieceWorker("Seu", "Madruga", "555-55-5555", .01, 18231 );

      // create five-element Employee array
      Employee employees[] = new Employee[ 5 ]; 

      // initialize array with Employees
      employees[ 0 ] = salariedEmployee;
      employees[ 1 ] = hourlyEmployee;
      employees[ 2 ] = commissionEmployee; 
      employees[ 3 ] = basePlusCommissionEmployee;
	  employees[ 4 ] = pieceWorker;
	  
      // generically process each element in array employees
      for ( Employee currentEmployee : employees ) 
      {
         System.out.println( currentEmployee ); // invokes toString

         System.out.printf( 
            "earned $%,.2f\n\n", currentEmployee.earnings() );
      } // end for

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "Employee %d is a %s\n", j, 
            employees[ j ].getClass().getName() ); 
   } // end main
} // end class PayrollSystemTest
