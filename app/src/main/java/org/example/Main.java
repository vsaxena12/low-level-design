package org.example;

class Dog {
    private final String name;

//    public Dog() {
//
//    }

    public Dog(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

//    void setName(String name) {
//        this.name = name;
//    }

    void run() {
        System.out.println("Barks");
    }
}
public class Main {
    public static void main(String[] args) {
//        Dog dog = new Dog();
//        dog.setName("Tommy");
//        System.out.println("My Dog Name: "+dog.getName());
//        dog.run();

        Dog dogUsingConstructor = new Dog("Tom");
        System.out.println("My Dog Name: "+dogUsingConstructor.getName());
        dogUsingConstructor.run();
    }
}
