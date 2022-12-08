package org.example.annotation;

public @interface FruitProvider {
    public int id() default -1;
    public String name() default "";
    public String address() default "";

}
