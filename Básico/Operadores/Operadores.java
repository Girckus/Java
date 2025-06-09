public class Operadores {

	public static void main(String[] args) {
		
		//Java Unary Operator Example: ++ and --
		int x=10;  
		System.out.println(x++);//10 (11)  
		System.out.println(++x);//12  
		System.out.println(x--);//12 (11)  
		System.out.println(--x);//10  
		
		int a=10;  
		int b=10;  
		System.out.println(a++ + ++a);//10+12=22  
		System.out.println(b++ + b++);//10+11=21
		
		//Java Relational Operators 
		a=10;  
		b=9;  
		System.out.println(a == b); // false
		System.out.println(a != b); // true
		System.out.println(a > b); // true
		System.out.println(a < b); // false
		System.out.println(a >= b); // true
		System.out.println(a <= b); // false
		
		//Java Unary Operator Example: ~ and !
		boolean c=true;  
		boolean d=false; 
		a=10;  
		b=-10;  
		System.out.println(~a);//-11 (minus of total positive value which starts from 0)  
		System.out.println(~b);//9 (positive of total minus, positive starts from 0)  
		System.out.println(!c);//false (opposite of boolean value)  
		System.out.println(!d);//true  
		
		//Java Arithmetic Operator Example
		a=10;  
		b=5;  
		System.out.println(a+b);//15  
		System.out.println(a-b);//5  
		System.out.println(a*b);//50  
		System.out.println(a/b);//2  
		System.out.println(a%b);//0  
		
		//Java Arithmetic Operator Example: Expression
		System.out.println(10*10/5+3-1*4/2);
		
		//Java Left Shift Operator Example
		System.out.println(10<<2);//10*2^2=10*4=40  
		System.out.println(10<<3);//10*2^3=10*8=80  
		System.out.println(20<<2);//20*2^2=20*4=80  
		System.out.println(15<<4);//15*2^4=15*16=240 
		
		//Java Right Shift Operator Example
		System.out.println(10>>2);//10/2^2=10/4=2  
		System.out.println(20>>2);//20/2^2=20/4=5  
		System.out.println(20>>3);//20/2^3=20/8=2  
		
		//Java Shift Operator Example: >> vs >>>
		//For positive number, >> and >>> works same  
		System.out.println(20>>2);  
		System.out.println(20>>>2);  
		//For negative number, >>> changes parity bit (MSB) to 0  
		System.out.println(-20>>2);  
		System.out.println(-20>>>2);
		
		//Java AND Operator Example: Logical && and Bitwise &
		a=10;  
		b=5;  
		int e=20;  
		System.out.println(a<b&&a++<e);//false && true = false  
		System.out.println(a);//10 because second condition is not checked  
		System.out.println(a<b&a++<e);//false && true = false  
		System.out.println(a);//11 because second condition is checked 
		
		//Java OR Operator Example: Logical || and Bitwise |
		a=10;  
		b=5;  
		e=20;  
		System.out.println(a>b||a<e);//true || true = true  
		System.out.println(a>b|a<e);//true | true = true  
		//|| vs |  
		System.out.println(a>b||a++<e);//true || true = true  
		System.out.println(a);//10 because second condition is not checked  
		System.out.println(a>b|a++<e);//true | true = true  
		System.out.println(a);//11 because second condition is checked 
		
		//Java Ternary Operator Example
		a=2;  
		b=5;  
		int min=(a<b)?a:b;  
		System.out.println(min); 
		
		//Java Assignment Operator Example
		a=10;  
		b=20;  
		a+=4;//a=a+4 (a=10+4)  
		b-=4;//b=b-4 (b=20-4)  
		System.out.println(a); 
		System.out.println(b);
		
		// Java Bitwise Operators Example: & (AND), | (OR), ^ (XOR), ~ (NOT)
		a = 5; // 0101 in binary
		b = 3; // 0011 in binary
		
		System.out.println("a & b = " + (a & b)); // 0101 & 0011 = 0001 (1)
		System.out.println("a | b = " + (a | b)); // 0101 | 0011 = 0111 (7)
		System.out.println("a ^ b = " + (a ^ b)); // 0101 ^ 0011 = 0110 (6)
		System.out.println("~a = " + (~a)); // ~0101 = 1010 (in two's complement: -6
	}

}