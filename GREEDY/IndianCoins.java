import java.util.*;

public class IndianCoins {
    public static void main(String args[]) {
        Integer coins[] = {1,2,5,10,20,50,100,500,1000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int amount = 590, countOfCoins = 0;
        ArrayList<Integer> ans= new ArrayList<>();

        for(int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount) {
                while(coins[i] <= amount) {
                    amount -= coins[i];
                    ans.add(coins[i]);
                    countOfCoins++;
                }
            }
        }
        System.out.println("No. of coins: " + countOfCoins);

        for(int i = 0; i < ans.size(); i++) {
            System.out.println("Coin:"+ ans.get(i));
        }
    }
}