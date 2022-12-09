package org.example.util;

import org.example.annotation.FruitColor;
import org.example.annotation.FruitName;
import org.example.annotation.FruitProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        String strFruitName = " 과일 이름 :";
        String strFruitColor = " 과일 색 :";
        String strFruitProvider = "과일 파는 곳";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = " 과일 파는 곳의 ID: " + fruitProvider.id() + " 지점 이름 : " + fruitProvider.name() + " 지점 주소: " + fruitProvider.address();System.out.println(strFruitProvider);
            }
        }
    }
    public static void setFruitInfo(Class<?> clazz){

        try {
            Object o = clazz.getDeclaredConstructor().newInstance();
            Field appleName = clazz.getDeclaredField("appleName");
            FruitName fruitName = appleName.getAnnotation(FruitName.class);
            System.out.println("fruitName = " + fruitName);
            appleName.setAccessible(true);
            appleName.set(o,fruitName.value());
            Object o1 = appleName.get(o);
            System.out.println("o1 = " + o1);

            Method method = clazz.getDeclaredMethod("setAppleName",String.class);
            method.setAccessible(true);
            method.invoke(o,"banana");
            Object o2 = appleName.get(o);
            System.out.println("o2 = " + o2);


        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
