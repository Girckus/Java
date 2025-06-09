import java.util.Scanner;

public class InvoiceTest
{   
	public static void main(String args[])
	{
		Scanner input = new Scanner (System.in);
		
		System.out.print("Numero: ");
		String num = input.nextLine();
		
		System.out.print("Descricao: ");
		String des = input.nextLine();
		
		System.out.print("Quantidade: ");
		int qtt = input.nextInt();
		
		System.out.print("Preco: ");
		double price = input.nextDouble();
		
		Invoice fatura = new Invoice(num, des, qtt, price);
		System.out.printf("Fatura de item %s - %s: %f", num, des, fatura.getInvoiceAmount());
	}
}