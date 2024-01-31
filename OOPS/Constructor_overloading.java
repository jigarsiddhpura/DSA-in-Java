import java.util.*;

public class Constructor_overloading {
    // Constructor Overloading is an example of polymorphism
    public static void main(String args[]) {
        Student s1 = new Student();
        
        // Student s2 = new Student("Jigar");
        // Student s3 = new Student(123);

        s1.marks[0] = 100;
        s1.marks[1] = 80;
        Student s4 = new Student(s1);
        // changing marks in s1
        s1.marks[1] = 60;
        // this will also be changed in s4 (if shallow copy constructor used) as for them,  arrays ka only REFRENCE  is copied , while (if deep copy constructor used), s4 will not change
        for(int i = 0; i < 2; i++) {
            System.out.println(s4.marks[i]);
        }        
    }
}

class Student{
    String  name = "Obito";
    int roll = 4;
    int marks[];
    
    // Type 1. non - parameterized constructor
    Student(){
        marks = new int[2];
        System.out.println("Non parameterized constructor called");
    }
    
    // Type 2. parameterized constructor
    Student(String name){
        marks = new int[2];
        this.name = name;
        System.out.println("Parameterized constructor with one argument called, name = "+this.name);
    }

    Student(int roll){
        marks = new int[2];
        this.roll = roll;
        System.out.println("Parameterized constructor with one argument called, roll = "+this.roll);
    }
    
    // Type 3. Copy constructor - copy the properties of a object1 into other object2
    
    // 3.1 shallow copy
    Student(Student s1){
        marks = new int[2];
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks;
    }
    // 3.2 deep copy
    Student(Student s1){
        marks = new int[2];
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i = 0; i < 2; i++) {
            this.marks[i] = s1.marks[i];
        } 
    }
}