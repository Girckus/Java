public class SobrecargaTest
{
	public static void go(int x) { System.out.println("int"); }
	public static void go(double x) { System.out.println("double"); }
	public static void go(long x) { System.out.println("long"); }
	
	public static void go2(Integer x) { System.out.println("Integer"); }
	public static void go2(long x) { System.out.println("long"); }
	
	public static void go3(int x, int y) { System.out.println("int int"); }
	public static void go3(int... x) { System.out.println("int..."); }
	
	public static void go4(long x, long y, long z) { System.out.println("long..."); }
	public static void go4(Integer... x) { System.out.println("Integer..."); }
	
	public static void main( String args[] )
	{
		SobrecargaTest.go(4);
		SobrecargaTest.go(4.5);
		SobrecargaTest.go(492837492);
		
		SobrecargaTest.go2(423873872);
		SobrecargaTest.go2(4);
		
		SobrecargaTest.go3(4, 6);
		
		SobrecargaTest.go4(4, 5, 6);
	}
}