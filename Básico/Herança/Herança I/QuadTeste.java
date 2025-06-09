//Capitulo 09 Exercicio 9.8: Testa a hierarquia do exercicio

public class QuadTeste 
{
   public static void main( String args[] )
   {
		Quadrilateral quadrilateral = new Quadrilateral(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1);
		Quadrilatero quadrilatero = new Quadrilatero(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1);
		Trapezio trapezio = new Trapezio(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1);
		Paralelogramo paralelogramo = new Paralelogramo(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1);
		Retangulo retangulo = new Retangulo(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1);
		Quadrado quadrado = new Quadrado(1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1);
   
		System.out.printf("%s\n", quadrilateral);
		System.out.println("---------------------------------");
		
		System.out.printf("%s\n", quadrilatero);
		System.out.println("---------------------------------");
		
		System.out.printf("%s\n", trapezio);
		System.out.printf("AREA: ");
		trapezio.area();
		System.out.println("---------------------------------");

		System.out.printf("%s\n", paralelogramo);
		System.out.print("AREA: "); 
		paralelogramo.area();
		System.out.println("---------------------------------");

		System.out.printf("%s\n", retangulo);
		System.out.print("AREA: ");
		retangulo.area();
		System.out.println("---------------------------------");

		System.out.printf("%s\n", quadrado);
		System.out.printf("AREA: ");
		quadrado.area();
		System.out.println("---------------------------------");
   }
} 