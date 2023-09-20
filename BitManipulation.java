import java.util.*;

public class BitManipulation{
    public static void main(String[] args){
        // getBit(1);
        // setBit(1);
        // clearBit(2);
        updateBit(2);
    }

    public static void getBit(int pos){
        // pos == index
        int n = 5; // n = 101
        int bitMask = 1<<pos;
        if((bitMask & n) == 0){
            System.out.println("bit was zero");
        } else {
            System.out.println("bit was one");
        }
    }

    public static void setBit(int pos){
        // bit at position `pos` ko 1 kr dega
        // pos == index
        int n = 5; // n = 101
        int bitMask = 1<<pos;

        int newNumber = bitMask | n;
        System.out.println(newNumber);
        
    }

    public static void clearBit(int pos){
        // bit at position `pos` ko 0 kr dega
        // pos == index
        int n = 5; // n = 101
        int bitMask = 1<<pos;

        int newNumber = n & (~bitMask);
        System.out.println(newNumber);
    }

    public static void updateBit(int pos){
        // oper=1 : set, oper=0 : clear
        System.out.print("Enter 1 to perform set , 0 for clear operation : ");
        int oper = sc.nextInt();
        if(oper==1){
            setBit(pos);
        } else {
            clearBit(pos);
        }
    }
}