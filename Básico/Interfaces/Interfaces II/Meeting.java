package java8;

public class Meeting implements Helloable {

	public static void main(String[] args) {
		Meeting met = new Meeting();
		met.start();
		met.message();
		met.hello();
	}

	@Override
	public void start() {
		System.out.println("Starting Meeting");
	}
	
}