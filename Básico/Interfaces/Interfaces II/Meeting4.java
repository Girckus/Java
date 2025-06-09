package java8;

public class Meeting4 extends MettingHello2 implements HelloableGourmet, Helloable {
	
	public static void main(String[] args) {
		Meeting4 met = new Meeting4();
		met.start();
		met.message();
		met.hello();
	}

}