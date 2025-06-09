package java7;

public class TryWithResources {

	public static void main(String[] args) {
		try(MyAutoCloseable mac = new MyAutoCloseable(); MyAutoCloseableProblem macp = new MyAutoCloseableProblem()) {
			
			mac.doIt();
	        macp.doIt();
			
	    } catch (Exception e) {
			e.printStackTrace();
			for(Throwable throwable : e.getSuppressed())
				System.out.println(throwable);
		} 
	}

}