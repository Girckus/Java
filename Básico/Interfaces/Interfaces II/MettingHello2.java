package java8;

public class MettingHello2 implements Helloable {

	@Override
	public void start() {
		System.out.println("Starting Meeting");
	}

	@Override
	public void message() {
		System.out.println("Special Message from MettingHello2");
	}

}