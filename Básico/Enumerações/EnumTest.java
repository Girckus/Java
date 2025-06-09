public class EnumTest {

enum Apple 
{
  A("A", 3), 
  B("B", 8), 
  C("C", 5), 
  D("D", 1), 
  E("E", 2)
  {
    public String toString()
    {
      return "SPECIAL E: " + getLetter() + " - " + getSize();
    }
  };
    
  private String letter;
  private int size;
    
  private Apple(String letter, int size)
  {
    this.letter = letter;
    this.size = size;
  }
  
  public void setLetter(String letter)
  {
    this.letter = letter;
  }
  
  public void setSize(int size)
  {
    this.size = size;
  }
  
  public String getLetter()
  {
    return this.letter;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public String toString()
  {
    return this.letter + " - " + this.size;
  }
} 
  
 /**
  * @param args
  */
 public static void main(String[] args) {
  Apple ap, ap1, ap2, ap3, ap4, ap5; 
     
     ap1 = Apple.A; 
     ap2 = Apple.B; 
     ap3 = Apple.C; 
     ap4 = Apple.D;
     ap5 = Apple.E;
       
     if(ap1.compareTo(ap2) < 0) 
       System.out.println(ap1 + " comes before " + ap2); 
  
     if(ap1.compareTo(ap2) > 0) 
       System.out.println(ap2 + " comes before " + ap1); 
  
     if(ap1.compareTo(ap3) == 0) 
       System.out.println(ap1 + " equals " + ap3); 
    
     System.out.println(); 
  
     if(ap1.equals(ap2)) 
       System.out.println("Error!"); 
  
     if(ap1.equals(ap3)) 
       System.out.println(ap1 + " equals " + ap3); 
  
     if(ap1 == ap3) 
       System.out.println(ap1 + " == " + ap3);    
     
     System.out.println("Here are all Apple constants"); 

     Apple allapples[] = Apple.values(); 
     for(Apple a : allapples) 
       System.out.println(a); 
  
     System.out.println(); 
     
     ap = Apple.valueOf("C"); 
     System.out.println("ap contains " + ap); 
     
     System.out.println(); 
     
     ap1.setSize(12);
     for(Apple app : Apple.values())
     {
       app.setLetter(app.getLetter().toLowerCase());
     }
         
     System.out.println("Here are all Apple constants"); 

     allapples = Apple.values(); 
     for(Apple a : allapples) 
       System.out.println(a);
 }

}
