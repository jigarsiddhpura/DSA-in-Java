import java.util.*;

public class Practice_questions {
    public static void main(String args[]) {
        Vehicle v = new Car();
        v.print1(); // gives error
    }
}

class Vehicle {
    void print() {
        System.out.println("Parent class called");
    }
}

class Car extends Vehicle {
    void print1() {
        System.out.println("Derived class called");
    }
}