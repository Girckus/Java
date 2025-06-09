package ref;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE_PARAMETER, ElementType.PACKAGE, ElementType.LOCAL_VARIABLE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.MODULE})
@interface MyAnnotation {
	
}

@MyAnnotation
public abstract class AnnotationTest<T> implements @MyAnnotation List<@MyAnnotation T>{

	@MyAnnotation
    public String teste = new @MyAnnotation String("Teste");
	
    public String myString = (@MyAnnotation String) teste;
    
    @MyAnnotation
    void monitorTemperature(@MyAnnotation int temperature) throws @MyAnnotation Exception {  
    	
    	@MyAnnotation
    	int t = temperature;
    	
    }
    
}