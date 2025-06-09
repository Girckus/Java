package java8;

public interface Byeable {

	void start();
	
	default void message() {
		System.out.println("Message from Byeable");
	}
	
	default void bye() {
		System.out.println("Bye from Helloable");
	}
}