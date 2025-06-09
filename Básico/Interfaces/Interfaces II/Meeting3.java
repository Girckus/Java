package java8;

public class Meeting3 implements HelloableGourmet, Helloable {
	
	public static void main(String[] args) {
		Meeting3 met = new Meeting3();
		met.start();
		met.message();
		met.hello();
	}

	@Override
	public void start() {
		System.out.println("Starting Meeting");
	}
	
}