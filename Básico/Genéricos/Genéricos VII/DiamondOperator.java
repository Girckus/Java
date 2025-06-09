package java7;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperator {

	public static void main(String[] args) {
		useRawType();
		useExplicitType();
		useImplicitType();
		useImplicitType2();
	}
	
	private static void useRawType() {
		List<String> arrayList = new ArrayList();
		arrayList.add("First");
		arrayList.add("Second");
		System.out.println(arrayList);
	}
	
	private static void useExplicitType() {
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("First");
		arrayList.add("Second");
		System.out.println(arrayList);
	}
	
	private static void useImplicitType() {
		List<String> arrayList = new ArrayList<>();
		arrayList.add("First");
		arrayList.add("Second");
		System.out.println(arrayList);
	}
	
	private static void useImplicitType2() {
		List arrayList = new ArrayList<>();
		arrayList.add("First");
		arrayList.add("Second");
		System.out.println(arrayList);
	}

}