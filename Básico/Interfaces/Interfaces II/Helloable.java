package java8;

public interface Helloable {

	void start();
	
	default void message() {
		System.out.println("Message from Helloable");
	}
	
	default void hello() {
		System.out.println("Hello from Helloable");
	}
}