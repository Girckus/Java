package validation.api.constraint;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Positive {

    String message() default "Valor deve ser positivo";

}