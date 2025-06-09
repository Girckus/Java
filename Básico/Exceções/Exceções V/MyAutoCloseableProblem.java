package java7;

public class MyAutoCloseableProblem implements AutoCloseable {
	public void doIt() throws Exception {
        System.out.println("Throwing Excpetion!");
        throw new Exception("MyAutoCloseableProblem.doIt()");
    }

    @Override
    public void close() throws Exception {
    	System.out.println("Throwing RuntimeExcpetion!");
        throw new RuntimeException("MyAutoCloseableProblem.close()");
    }
}