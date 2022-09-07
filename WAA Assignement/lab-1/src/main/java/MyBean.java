package lab1.main.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Annotation to be used over a class:
@Retention(RetentionPolicy.RUNTIME)
public @interface MyBean {
}
