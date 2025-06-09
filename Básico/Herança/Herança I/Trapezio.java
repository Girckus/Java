//Capitulo 09 Exercicio 9.8: Classe Trapezio que herda de Quadrilatero

public class Trapezio extends Quadrilatero
{ 
   public Trapezio(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)
   {
		super(x1, y1, x2, y2, x3, y3, x4, y4);
		
		System.out.println("Trapezio: Verificar se existe ao menos duas arestas paralelas\n");
   }
   
   public void area()
   {
		System.out.println("(BASE_MAIOR x BASE_MENOR x ALTURA) / 2");
   }
   
   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
		return (String.format( "Trapezio: (%.2f,%.2f) (%.2f,%.2f)(%.2f,%.2f) (%.2f,%.2f)\n", 
				getX1(), getY1(), getX2(), getY2(), getX3(), getY3(), getX4(), getY4()));
   }
}