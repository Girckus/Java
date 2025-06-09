//Capitulo 09 Exercicio 9.8: Classe Quadrilatero que herda de Quadrilateral

public class Quadrilatero extends Quadrilateral
{ 
   public Quadrilatero(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
   {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
		
		System.out.println("Quadrilatero: Verificar se coordenadas sao diferentes\n");
   }
   
   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return (String.format( "Quadrilatero: (%.2f,%.2f) (%.2f,%.2f)(%.2f,%.2f) (%.2f,%.2f)\n", 
				getX1(), getY1(), getX2(), getY2(), getX3(), getY3(), getX4(), getY4()));
   }
}