public class Primitivos {

	public static final double CM_PER_INCH = 2.54;

	public static void main(String[] args) {
		
		byte a = -128;
		byte b = 127;
		 
		short c = -32768;
		short d = 3277;
		 
		int e = -2147483648;
		int f = 2147483647;
		 
		long g = -9223372036854775808L;
		long h = 9223372036854775807l;
		 
		float i = -100.4345F;
		float j = 123243.4345f;
		 
		double k = -3123.434354d;
		double l = 321321.3123435;
		double exponencial = 1.729E3;
		double exponencialHexa = 0x1.0p-3;
		 
		boolean m = false;
		boolean n = true;
		 
		char o = 'a';
		char p = '4';
		char q = '?';
		char r = '\u03C0';
		
		int octal = 0144;    // decimal 100 represented in octal base.
		int hex = 0x64;      // decimal 100 represented in hexadecimal base.
		int bin = 0b1100100; // decimal 100 represented in binary base
		
		long card = 1234_5678_9876_5432L;
		float amount = 5_000F;

		int commandInHex = 0xE_23D5_8C_7;
		int commandInBinary = 0b1110_0010001111010101_10001100_0111;
		
		var teste = "Teste";
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);
		System.out.println(n);
		System.out.println(o);
		System.out.println(p);
		System.out.println(q);
		System.out.println(r);
		System.out.println(exponencial);
		System.out.println(exponencialHexa);
		System.out.println(octal);
		System.out.println(hex);
		System.out.println(bin);
		System.out.println(card);
		System.out.println(amount);
		System.out.println(commandInHex);
		System.out.println(commandInBinary);
		System.out.println(Primitivos.CM_PER_INCH);
		System.out.println(teste);
		
		//Casting
		int myInt = 127;
		long myLong = myInt;
		System.out.println(myLong);
		
		float myFloat = myLong;
		double myDouble = myFloat;
		System.out.println(myDouble);
		
		myInt = (int) myDouble;
		byte myByte = (byte) myInt;
		System.out.println(myByte);
		
		byte myLargeValueByte = (byte) 130;
		System.out.println(myLargeValueByte);
		
		char myLargeValueChar = (char) myLargeValueByte;
		int myLargeValueInt = myLargeValueChar;
		System.out.println(myLargeValueChar);
		System.out.println(myLargeValueInt);
		
		byte op1 = 4;
		byte op2 = 5;
		byte myResultingByte = (byte) (op1 + op2);
		System.out.println(myResultingByte);
	}

}