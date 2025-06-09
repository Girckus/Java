package java8;

public interface HelloableGourmet extends Helloable {

	default void message() {
		System.out.println("Gurmet Message from Helloable");
	}
	
}