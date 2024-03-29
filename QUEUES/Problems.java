import java.util.*;

public class Problems {
    public static void print_first_non_repeating (String str){
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];

        for(char ch : str.toCharArray()) {
            q.add(ch);
            freq[ch-'a']++;

            char non_rep = '@';
            while(!q.isEmpty()) {
                char front = q.peek();
                if (freq[front-'a'] > 1) {
                    q.remove();
                } else {
                    non_rep = front;
                    break;
                }
            }
            
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(non_rep+" ");
            }
        }
    }
    public static void main(String args[]) {
        String str = "aabccxb";
        print_first_non_repeating(str);
    }
}