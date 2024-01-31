import java.util.*;

public class StringsFun{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // stringFunc();
        stringBuilderFuncs();

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

    public static void stringBuilderFuncs(){
        StringBuilder sb = new StringBuilder("Tony");
        sb.setCharAt(0, 'P');
        sb.insert(4,'s');
        System.out.println(sb);
        sb.delete(3,4);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
    }
}