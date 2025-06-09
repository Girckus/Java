import java.io.*;

class ExceptionA extends Exception { }
class ExceptionB extends ExceptionA { }

public class C13ex18
{
	static String a;

	public static void main(String args[])
	{
		try
		{
			throw new ExceptionA();
		}
		catch(Exception e)
		{
			System.out.println("ExceptionA handled");
		}

		try
		{
			throw new ExceptionB();
		}
		catch(Exception e)
		{
			System.out.println("ExceptionB handled");
		}

		try
		{
			throw new IOException();
		}
		catch(Exception e)
		{
			System.out.println("IOException handled");
		}
		
		try
		{
			a.toUpperCase();
		}
		catch(Exception e)
		{
			System.out.println("NullPointerException handled");
		}
	}
}