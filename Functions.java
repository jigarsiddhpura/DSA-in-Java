import java.util.*;

public class Functions{
    public static void main(String args[]){
        // EXPONENT
        int x = 30, n = 12;
        // System.out.print(Math.pow(2,3));
        // System.out.println("");

    }

            // GCD
            public static void gcd(int x,int n){
                int min = (x<n) ? x : n;
                int max = (x>n) ? x : n;
                for(int i=min;i>=1;i--){
                    if(min%i==0 && max%i==0){
                        System.out.print(i);
                        break;
                    }
                }
                System.out.println("");
            }
    
            // FIBONACCI
            public static void fibonacci(){
                int k = 10,a = 0, b = 1;
                System.out.print("0 1 ");
                for(int i=1;i<=k-2;i++){
                    int sum = a+b;
                    System.out.print(sum+" ");
                    a = b;
                    b = sum;
                }
                System.out.println("");
            }

            
        // STRING FUNCTIONS
        public static void stringFunc(){
            String test = "Hello World";
            String test2 = "      Hello World      ";

            char ch = test.charAt(2);
            String substr = test.substring(2);
            String substr2 = test.substring(2,5);
            int i = test.indexOf("w");
            boolean isFound = test.contains("o");
            boolean start = test.startsWith("Hel");
            boolean end = test2.endsWith("ld");

            String up = test2.toUpperCase();
            String trimmed = test2.trim();

            String rep = test.replace("World","universe");
            String[] parts = test.split(", ");
            
            boolean isEqual = test.equals("hello world");
            boolean isEqualIgCase = test.equalsIgnoreCase("hello world");
            // System.out.print(isEqualIgCase);

            // ⭐⭐⭐

            // cases in compareTo func(return int)
            // == sometimes fails in the test cases -> so use this for comparison ✨
            //  1. s1 > s2 : +ve value
            //  2. s1 = s2 : 0
            //  3. s1 < s2 : -ve value
            String name1 = "hello";
            String name2 = "wello";
            int cmp = name1.compareTo(name2);
            System.out.println(cmp);

            // ⭐ Strings are immutable ⭐
        }
}