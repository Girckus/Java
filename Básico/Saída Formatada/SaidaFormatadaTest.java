public class SaidaFormatadaTest
{
	public static void main(String[] args)
	{
		System.out.printf("%7d\n", 12345);
		System.out.printf("%010d\n", 12345);
		System.out.printf("%+6d\n", 12345);
		System.out.printf("% d\n", 12345);
		System.out.printf("%.4f\n", 1.2345);
		System.out.printf("%8.18f\n", 1.2345);
		System.out.printf("%13f\n", 1.2345);
		System.out.printf("%04.6f\n", 1.2345);
		System.out.printf("%.1g\n", 9876.12345);
		System.out.printf("%.2g\n", 9876.12345);
		System.out.printf("%(.3g\n", -9876.12345);
		System.out.printf("%(.4g\n", 9876.12345);
		System.out.printf("%.5g\n", 9876.12345);
		System.out.printf("%.6g\n", 9876.12345);
		System.out.printf("%.7g\n", 9876.12345);
		System.out.printf("%.8g\n", 9876.12345);
		System.out.printf("%.9g\n", 9876.12345);
		System.out.printf("%d\n ", 12345);
		System.out.printf("%+8d\n ", 12345);
		System.out.printf("% d\n ", 12345);
		System.out.printf("%07d\n ", 12345);
		System.out.printf("%f\n ", 100.453627);
		System.out.printf("%7.1f\n ", 100.453627);
		System.out.printf("%09.8f\n ", 100.453627);
		System.out.printf("%+.4f\n ", 100.453627);
		System.out.printf("% 7.0f\n ", 100.453627);
		System.out.printf("%o\n ", 100);
		System.out.printf("%x\n ", 100);
		System.out.printf("%X\n ", 100);
		System.out.printf("%e\n ", 100.453627);
		System.out.printf("%E\n ", 100.453627);
		System.out.printf("%a\n ", 100.453627);
		System.out.printf("%A\n ", 100.453627);
		System.out.printf("%b\n ", true);
		System.out.printf("%B\n ", false);
		System.out.printf("%h\n ", "Ana");
		System.out.printf("%H\n", "Cláudia");
		System.out.printf("%2$d %1$d\n", 1, 2);
	}
}