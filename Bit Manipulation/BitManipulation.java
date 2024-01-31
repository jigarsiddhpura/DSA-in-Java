import java.util.*;

public class BitManipulation{
    public static void main(String[] args){
        // getBit(3);
        // setBit(1);
        // clearBit(2);
        // updateBit(2);

        // boolean isPowerOf2 = checkPowerOf2(8) ;
        // System.out.println("Is 8 power of 2 : "+ isPowerOf2 );

        // int x = addOne(4);
        // System.out.println("Add one to number 4: " +x);

        convertUpperCasetoLowerCase();

    }

    public static void getBit(int pos){
        // pos == index
        int n = 8; // n = 1000

        // left shift `1` by `pos` positions
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
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        if(oper==1){
            setBit(pos);
        } else {
            clearBit(pos);
        }
    }
    
    public static void clearLastIBits(int n,int i){
        // not of zero = 11111... (all one).. to LEFT SHIFT krenge (~0) ko `i` times to right me `i` zeros hongey
        int bitMask = (~0) << i;
        int newNumber = n & bitMask;

        System.out.println(newNumber);
    }
    
    public static void clearRangeOfBits(int n,int i,int j){
        int a = (~0) << (j+1);
        int b = (1 << i) - 1;

        int bitMask = a | b;
        int newNumber = n & bitMask;

        System.out.println(newNumber);
    }
    
    public static boolean checkPowerOf2(int n){
        // will give output 0 if n is power of 2 
        return (n & (n-1)) == 0;
    }

    public static int addOne (int n){
        return -~n;
    }

    public static void convertUpperCasetoLowerCase (){
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' '));
        }
    }
}