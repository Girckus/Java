package java8;

public class Meeting2 extends MettingHello implements HelloableGourmet, Helloable {
	
	public static void main(String[] args) {
		Meeting2 met = new Meeting2();
		met.start();
		met.message();
		met.hello();
	}

}