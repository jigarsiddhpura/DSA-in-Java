import java.util.*;

public class Abstraction {
    public static void main(String args[]) {
        Horse h = new Horse();
        h.makeSound();
        h.eat();
        System.out.println(h.color);
    }
}

abstract class Animal{
    String color;

    // constructor - called when obj of the child class is created
    // whenever creating an object, PARENT CONSTRUCTORS ARE CALLED IN HIERARCHY ⭐
    Animal() {
        color = "brown";
        System.out.println("Animal constructor called");
    }

    // non-abstract method
    void eat() {
        System.out.println("Animal eating");
    }

    // abstract method
    abstract void makeSound();
}

class Horse extends  Animal {
    Horse () {
        color = "brown";
        System.out.println("Horse constructor called");
    }
    void makeSound() {
        System.out.println("ho ho ho pushhh");
    }
}

class Cat extends  Animal {
    void makeSound() {
        System.out.println("mew meow");
    }
}