package ref;

import java.util.ArrayList;
import java.util.List;

public class AnnotationTest {

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		String teste = "";
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		
		String myString = ( String) teste;
	}

	@Override
	public String toString() {
		return "Override" + super.toString();
	}
	
}