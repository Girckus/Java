package examples;

public class Student {

	private int rollno;
	private String name;
	public static String college;
	private static int studentCount = 0;

	static {
		System.out.println("static block is invoked");
		college = "ITS";
	}
	
	{
		System.out.println("inside initialization block");
		studentCount++;
	}
	
	public Student(int r, String n) {
		rollno = r;
		name = n;
	}

	public void display() {
		System.out.println(rollno + " " + name + " " + college + " " + studentCount);
	}
	
	public static void change(){  
	     college = "BBDIT";  
	}  

	public static void main(String args[]) {
		Student s1 = new Student(111, "Karan");
		Student s2 = new Student(222, "Aryan");
		s1.display();
		s2.display();
		Student.change();
		Student s3 = new Student(333,"Sonoo");  
		s1.display();
		s2.display();
		s3.display();
	}
}