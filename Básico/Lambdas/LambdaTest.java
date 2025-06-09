interface NumericTest {
	boolean computeTest(int n); 
}

interface MyGreeting {
	String processName(String str);
}

interface MyString {
	String myStringFunction(String str);
}

interface MyGeneric<T> {
	T compute(T t);
}

public class LambdaTest {

	public static void main(String args[]) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}
	
	public static String reverseStr(MyString reverse, String str){
		return reverse.myStringFunction(str);
	}
	
	public static void test1() {
		NumericTest isEven = (n) -> (n % 2) == 0;
		NumericTest isNegative = (n) -> (n < 0);

		// Output: false
		System.out.println(isEven.computeTest(5));

		// Output: true
		System.out.println(isNegative.computeTest(-5));
	}
	
	public static void test2() {
		MyGreeting morningGreeting = (str) -> "Good Morning " + str + "!";
		MyGreeting eveningGreeting = (str) -> "Good Evening " + str + "!";
	  
	  	// Output: Good Morning Luis! 
		System.out.println(morningGreeting.processName("Luis"));
		
		// Output: Good Evening Jessica!
		System.out.println(eveningGreeting.processName("Jessica"));	
	}
	
	public static void test3() {
		// Block lambda to reverse string
		MyString reverseStr = (str) -> {
			String result = "";
			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			
			return result;
		};

		// Output: omeD adbmaL
		System.out.println(reverseStr.myStringFunction("Lambda Demo")); 
	}
	
	public static void test4(){

		// String version of MyGenericInteface
		MyGeneric<String> reverse = (str) -> {
			String result = "";
			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			
			return result;
		};

		// Integer version of MyGeneric
		MyGeneric<Integer> factorial = (Integer n) -> {
			int result = 1;
			
			for(int i=1; i <= n; i++)
				result = i * result;
			
			return result;
		};

		// Output: omeD adbmaL
		System.out.println(reverse.compute("Lambda Demo")); 

		// Output: 120
		System.out.println(factorial.compute(5)); 
	}

	public static void test5() {
		// Block lambda to reverse string
		MyString reverse = (str) -> {
			String result = "";
			
			for(int i = str.length()-1; i >= 0; i--)
				result += str.charAt(i);
			
			return result;
		};

		// Output: omeD adbmaL
		System.out.println(reverseStr(reverse, "Lambda Demo")); 
	}
}