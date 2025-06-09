//Capítulo 10 Exercício 10.9: Classe PayrollSystemTest e uma classe que testa as classes da hierarquia Employee disponibilizando
//informacoes sobre a folha de pagamento de um determinado funcionario

public class PayrollSystemTest 
{
   public static void main( String args[] ) 
   {
      // create subclass objects
      SalariedEmployee employee1 = 
         new SalariedEmployee( "John", "Smith", "111-11-1111", 800.00, new Date(4, 2, 1976) );
      
	  HourlyEmployee employee2 = 
         new HourlyEmployee( "Karen", "Price", "222-22-2222", 16.75, 40, new Date(2, 10, 1972) );
      
	  CommissionEmployee employee3 = 
         new CommissionEmployee( 
         "Sue", "Jones", "333-33-3333", 10000, .06, new Date(2, 9, 1981) );
  
      BasePlusCommissionEmployee employee4 = 
         new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "444-44-4444", 5000, .04, 300, new Date(1, 1, 1957) );	
      
	  SalariedEmployee employee5 = 
         new SalariedEmployee( "Kiko", "Hor", "555-55-5555", 1000.00, new Date(9, 12, 1966) );
     
      HourlyEmployee employee6 = 
         new HourlyEmployee( "Seu", "Madruga", "666-66-6666", 20.18, 49, new Date(2, 4, 1973) );
      
	  CommissionEmployee employee7 = 
         new CommissionEmployee( 
         "Chaves", "Hor", "777-77-7777", 12345, .072, new Date(12, 12, 1983) );
      
	  BasePlusCommissionEmployee employee8 = 
         new BasePlusCommissionEmployee( 
         "Dona", "Florinda", "888-88-8888", 5500, .033, 500, new Date(2, 2, 1949) );		
      
	  Employee [] employees = new Employee[8];
	  employees[0] = employee1;
	  employees[1] = employee2;
	  employees[2] = employee3;
	  employees[3] = employee4;
	  employees[4] = employee5;
	  employees[5] = employee6;
	  employees[6] = employee7;
	  employees[7] = employee8;
	  
      // generically process each element in array employees
      for ( Employee currentEmployee : employees ) 
      {
         System.out.println( currentEmployee ); // invokes toString

         // determine whether the Month Birth of the currentEmployee is February
         if ( currentEmployee.getBirthDate().getMonth() == 2 ) 
         {
            System.out.printf( 
                "BIRTH MONTH: $100 bonus\n earned $%,.2f\n\n", currentEmployee.earnings() + 100 );
         } // end if
		 else
		 {
			System.out.printf( 
				"earned $%,.2f\n\n", currentEmployee.earnings() );
		 }
	  } // end for

      // get type name of each object in employees array
      for ( int j = 0; j < employees.length; j++ )
         System.out.printf( "Employee %d is a %s\n", j, 
            employees[ j ].getClass().getName() ); 
   } // end main
} // end class PayrollSystemTest