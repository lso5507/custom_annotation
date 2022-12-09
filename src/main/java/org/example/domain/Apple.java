package org.example.domain;

import org.example.annotation.FruitColor;
import org.example.annotation.FruitName;
import org.example.annotation.FruitProvider;

public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1,name = "HomePlus",address = "Seoul")
    private String appleProvider;
    private void setAppleName(String item){
        this.appleName=item;
    }
    public Apple(){

    }
}
