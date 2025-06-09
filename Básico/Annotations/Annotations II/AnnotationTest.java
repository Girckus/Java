package ref;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import ref.TesterInfo.Priority;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
	
	public boolean enabled() default true;
	
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TesterInfo {

	public enum Priority {
	   LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.MEDIUM;
	
	String[] tags() default "";
	
	String createdBy() default "Girckus";
	
	String lastModified() default "03/01/2014";

}

@TesterInfo(
	priority = Priority.HIGH, 
	createdBy = "girckus.com",  
	tags = {"sales","test" }
)
public class AnnotationTest {

	public static void main(String args[]) {
		System.out.println("Testing...");

		int passed = 0, failed = 0, count = 0, ignore = 0;

		Class<AnnotationTest> obj = AnnotationTest.class;

		// Process @TesterInfo
		if (obj.isAnnotationPresent(TesterInfo.class)) {

			Annotation annotation = obj.getAnnotation(TesterInfo.class);
			TesterInfo testerInfo = (TesterInfo) annotation;

			System.out.printf("%nPriority :%s", testerInfo.priority());
			System.out.printf("%nCreatedBy :%s", testerInfo.createdBy());
			System.out.printf("%nTags :");

			int tagLength = testerInfo.tags().length;
			for (String tag : testerInfo.tags()) {
				if (tagLength > 1) {
					System.out.print(tag + ", ");
				} else {
					System.out.print(tag);
				}
				tagLength--;
			}

			System.out.printf("%nLastModified :%s%n%n", testerInfo.lastModified());

		}

		// Process @Test
		for (Method method : obj.getDeclaredMethods()) {

			// if method is annotated with @Test
			if (method.isAnnotationPresent(Test.class)) {

				Annotation annotation = method.getAnnotation(Test.class);
				Test test = (Test) annotation;

				// if enabled = true (default)
				if (test.enabled()) {

				  try {
					method.invoke(obj.newInstance());
					System.out.printf("%s - Test '%s' - passed %n", ++count, method.getName());
					passed++;
				  } catch (Throwable ex) {
					System.out.printf("%s - Test '%s' - failed: %s %n", ++count, method.getName(), ex.getCause());
					failed++;
				  }

				} else {
					System.out.printf("%s - Test '%s' - ignored%n", ++count, method.getName());
					ignore++;
				}

			}

		}
		System.out.printf("%nResult : Total : %d, Passed: %d, Failed %d, Ignore %d%n", count, passed, failed, ignore);

	}
	
	@Test
	void testA() {
		if (true)
			throw new RuntimeException("This test always failed");
	}

	@Test(enabled = false)
	void testB() {
		if (false)
			throw new RuntimeException("This test always passed");
	}

	@Test(enabled = true)
	void testC() {
		if (10 > 1) {
		// do nothing, this test always passed.
		}
	}
}