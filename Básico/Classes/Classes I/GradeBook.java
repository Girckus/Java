public class GradeBook {
	
	private String courseName;
	private String instructorName;

	public GradeBook( String course, String instructor) {
		courseName = course;
		instructorName = instructor;
	}

	public void setCourseName( String course ) {
		courseName = course;
	}
   
	public void setInstructorName( String instructor) {
		instructorName = instructor;
	}

	public String getCourseName() {
		return courseName;
	}
   
	public String getInstructorName() {
		return instructorName;
	}

	public void displayMessage() {
		System.out.printf( "Welcome to the grade book for\n%s!\n", getCourseName() );
		System.out.printf( "This course is presented by: %s\n", getInstructorName() );
	}

}
