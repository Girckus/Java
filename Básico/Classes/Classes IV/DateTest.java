import java.util.Scanner;

public class DateTest
{   
	public static void main(String args[])
	{
		Scanner input = new Scanner (System.in);
		
		System.out.print("Dia:  ");
		int day = input.nextInt();
		
		System.out.print("Mes:  ");
		int month = input.nextInt();
		
		System.out.print("Ano:  ");
		int year = input.nextInt();
		
		Date data = new Date(day, month, year);
		
		data.displayData();
	}
}