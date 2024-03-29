import java.util.*;

public class Solution {
    ArrayList<Integer> playOfGlasses(int c1,int w1,int c2,int w2,int c3,int w3)
    {
        ArrayList<Integer> volume = new ArrayList<>(Arrays.asList(w1,w2,w3));
        ArrayList<Integer> capacity = new ArrayList<>(Arrays.asList(c1,c2,c3));
        
        int loop = (int) Math.pow(10,5);
        int i = 0, j = 1;
        while(loop > 0) {
            if (volume.get(j) <= capacity.get(i) - volume.get(i)) {
                volume.set(i,volume.get(i)+volume.get(j));
                volume.set(j,0);
            } else {
                volume.set(i,capacity.get(i));
                int newVolume = volume.get(j) - (capacity.get(i) - volume.get(i));
                volume.set(j,newVolume);
            }
            i = (i+1)%2;
            j = (j+1)%2;
            System.out.println(volume);
            loop--;
        }
        
        return volume;
    }
    public static void main(String args[]) {
        
    }
}

