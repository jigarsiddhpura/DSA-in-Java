// ✨✨ FAANG ✨✨
// ⭕🔴 HARD LEVEL + IMP 🔴⭕

import java.util.*;

public class ChocolaProblem {
    public static void main(String args[]) {
        int n = 4, m = 6;
        Integer[] costHor = {4,1,2};
        Integer[] costVer = {2,1,3,1,4};

        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int cost=0;
        int h=0, v=0;
        int hp=1, vp=1;

        while(h<n-1 && v<m-1) {
            if (costHor[h] < costVer[v]) {
                cost += (costVer[v] * hp);
                v++;
                vp++;
            } else {
                cost += (costHor[h] * vp);
                h++;
                hp++;
            }
        }

        while(h<n-1) {
            cost += costHor[h] * vp;
            h++;
            hp++;
        }
        while(v<m-1) {
            cost += costVer[v] * hp;
            v++;
            vp++;
        }

        System.out.println("min cost of cuts = "+cost);

    }
}
