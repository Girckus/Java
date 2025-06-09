package java7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatch {

	public static void main(String[] args) {
		try {
			
			Scanner input = new Scanner(System.in);
			System.out.print("Primeiro n�mero:");
			int a = input.nextInt();
			System.out.print("\nSegundo n�mero:");
			int b = input.nextInt();
			
			System.out.println(a/b);
			
	    } catch (ArithmeticException | InputMismatchException e) {
	    	System.out.println("Erro na conta");
			e.printStackTrace();
		} 
	}

}