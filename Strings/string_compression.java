import java.util.*;

public class string_compression {
    public static String stringCompression (String str){
        String s = "";
        for(int i = 0; i < str.length(); i++) {
            Integer count = 1; // since it has to be converted into string later, declaring as Object class Integer
            char ch = str.charAt(i);
            while(i<str.length()-1 && ch == str.charAt(i+1)) {
                count++;
                i++;
            }
            s += ch;
            if(count > 1){
                s += count.toString();
            }
            
        }
        return s;
    }
    public static void main(String args[]) {
        String str = "bbbccdeeeee";
        String ans = stringCompression(str);
        System.out.println(ans);
    }
}