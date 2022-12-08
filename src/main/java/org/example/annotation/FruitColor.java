package org.example.annotation;

public @interface FruitColor {
    public enum Color{BLUE,RED,GREEN};
    Color fruitColor() default Color.GREEN;
}
