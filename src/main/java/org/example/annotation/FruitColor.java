package org.example.annotation;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {
    public enum Color{BLUE,RED,GREEN};
    Color fruitColor() default Color.GREEN;
}
