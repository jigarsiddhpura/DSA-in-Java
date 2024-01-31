import java.util.*;

public class check_anagram {
    public static boolean isAnagram (String str1, String str2){
        if(str1.length() != str2.length()) return false;
        char[] ca1 = str1.toCharArray();
        char[] ca2 = str2.toCharArray();
        Arrays.sort(ca1);
        Arrays.sort(ca2);
        return Arrays.equals(ca1,ca2);

    }
    public static void main(String args[]) {
        String str1 = "heart", str2 = "earth";
        boolean ans = isAnagram(str1,str2);
        System.out.println(ans);
    }
}