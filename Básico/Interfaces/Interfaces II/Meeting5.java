package java8;

public class Meeting5 implements Helloable, Byeable {

	public static void main(String[] args) {
		Meeting5 met = new Meeting5();
		met.start();
		met.message();
		met.hello();
		met.messageBye();
		met.bye();
	}

	@Override
	public void start() {
		System.out.println("Starting Meeting");
	}
	
	public void message() {
		Helloable.super.message();
	}
	
	public void messageBye() {
		Byeable.super.message();
	}
}