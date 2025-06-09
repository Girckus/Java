package examples;

public class Outer {

	static Demo d = new Demo() {
		void show() {
			super.show();
			System.out.println("i am in Outer class");
		}
	};

	public static void main(String[] args) {
		Outer.Inner in = new Outer().new Inner();
		in.show();

		Outer out = new Outer();
		out.outerMethod();

		StaticInner.display();
		
		d.show();
		
		out.hello(new Hello() {
		        public void show() {
		            System.out.println("i am in anonymous class");
		        }
	    	}
	    );
	}

	private void hello(Hello h) {
		h.show();
	}

	private void outerMethod() {
		String str = "inside innerMethod";

		System.out.println("inside outerMethod");

		class InnerClassInMethod {
			void innerMethod() {
				System.out.println(str);
			}
		}

		InnerClassInMethod y = new InnerClassInMethod();
		y.innerMethod();

		Inner inner = new Inner();
		inner.show();
	}

	private static void outerSaticMethod() {
		System.out.println("inside satic outerMethod");
	}

	private void outerMethodFromInner() {
		System.out.println("inside outerMethod called from inner");
	}
	
	class Inner {
		
		static class InnerStaticInner {

			public static void display() {
				System.out.println("inside inner static inner class Method");
			}
		}
		
		public void show() {
			System.out.println("In a nested class method");
			Outer.this.outerMethodFromInner();
			InnerStaticInner.display();
		}
	}

	static class StaticInner {

		public static void display() {
			System.out.println("inside inner static class Method");
			outerSaticMethod();
		}
	}

}

class Demo {
	void show() {
		System.out.println("i am in show method of super class");
	}
}

interface Hello {
	void show();
}