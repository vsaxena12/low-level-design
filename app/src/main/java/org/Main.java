package org;

class Dog {
    String name;
    void run() {
        System.out.println("Run");
    }
}
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.name = "Tom";
        System.out.println(dog.name);
        dog.run();
    }
}
