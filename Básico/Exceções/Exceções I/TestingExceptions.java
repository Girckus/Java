public class TestingExceptions
{
	public static void catchHandler(Exception exception)
	{
		System.out.println( "\n===============================\n" );
		System.err.printf("%s\n\n", exception.getMessage() );
		exception.printStackTrace();
			
		StackTraceElement[] traceElements = exception.getStackTrace();
		
		System.out.println( "\nStack Trace" );
		System.out.println( "\nClasse\t\t\tArquivo\t\t\tLinha\tMetodo" );
		
		for( StackTraceElement element : traceElements )
		{
			System.out.printf( "%s\t", element.getClassName() );
			System.out.printf( "%s\t", element.getFileName() );
			System.out.printf( "%s\t", element.getLineNumber() );
			System.out.printf( "%s\n", element.getMethodName() );
		}
	}
	
	public static void main( String[] args)
	{
		try
		{
			method1();
		}
		catch(Exception exception)
		{
			catchHandler(exception);
			try
			{
				method2();
			}
			catch(Exception exception2)
			{
				catchHandler(exception2);
			}
			finally
			{
				System.out.println( "\nFinally Block" );
			}
		}
		finally
		{
			System.out.println( "\nFinally Block" );
		}
	}
	
	public static void method1() throws Exception
	{
		try
		{
			method4();
		}
		catch(Exception exception)
		{
			method2();
			catchHandler(exception);
			throw new Exception("Exception Method1");
		}
		finally
		{
			System.out.println( "\nFinally Block" );
		}
	}
	
	public static void method2() throws Exception
	{
		try
		{
			method5();
		}
		catch(Exception exception)
		{
			method3();
			catchHandler(exception);
			throw new Exception("Exception Method2");
		}
		finally
		{
			System.out.println( "\nFinally Block" );
		}
	}
	
	public static void method3() throws Exception
	{
		throw new Exception("Exception Method3");
	}

	public static void method4() throws Exception
	{
		try
		{
			method5();
		}
		catch(Exception exception)
		{
			catchHandler(exception);
			throw new Exception("Exception Method4");
		}
		finally
		{
			System.out.println( "\nFinally Block" );
		}
	}	
	
	public static void method5() throws Exception
	{
		throw new Exception("Exception Method5");
	}	
}