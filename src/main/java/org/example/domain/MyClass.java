package org.example.domain;

public class MyClass implements MyInterface{
    private String name="Default";
    private String address;

    public String getName() {
        return name;
    }

    public MyClass() {
        System.out.println("Constructor Called");
    }

    public MyClass(String name, String address) {
        this.name = name;
        this.address = address;
        System.out.println("Constructor(name,address) Called!!");

    }
    public void setName(String name){
        this.name=name;
    }

}
