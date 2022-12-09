package org.example.annotation;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface FruitProvider {
    public int id() default -1;
    public String name() default "";
    public String address() default "";

}
