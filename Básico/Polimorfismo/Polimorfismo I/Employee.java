//Capítulo 10 Exercício 10.9: Classe Employee que contem informacoes de um funcionario em geral

public abstract class Employee 
{
   private String firstName;
   private String lastName;
   private String socialSecurityNumber;
   private Date birthDate;

   // three-argument constructor
   public Employee( String first, String last, String ssn, Date birth )
   {
      firstName = first;
      lastName = last;
      socialSecurityNumber = ssn;
	  birthDate = birth;
   } // end three-argument Employee constructor

   // set first name
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // return first name
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName

   // set last name
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // set birthDate
   public void setBirthDate(Date birth)
   {
	  birthDate = birth;
   }
   
   //return birthDate
   public Date getBirthDate()
   {
	  return birthDate;
   }
   
   // return last name
   public String getLastName()
   {
      return lastName;
   } // end method getLastName

   // set social security number
   public void setSocialSecurityNumber( String ssn )
   {
      socialSecurityNumber = ssn; // should validate
   } // end method setSocialSecurityNumber

   // return social security number
   public String getSocialSecurityNumber()
   {
      return socialSecurityNumber;
   } // end method getSocialSecurityNumber

   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%s %s\nsocial security number: %s \nbirth date: %s\n", 
         getFirstName(), getLastName(), getSocialSecurityNumber(), birthDate );
   } // end method toString

   // abstract method overridden by subclasses
   public abstract double earnings(); // no implementation here
} // end abstract class Employee