// ✨ MORGAN STANLEY, FLIPKART ✨

// DISJOINT SET, MAXIMUM MEETINGS IN A ROOM - these r based on activity selection

// GIVEN : ARR is sorted based on end time - bcz humey zyada se zyada task krna hai - to jo jaldi khtm ho rha usko pehle lenge (given that it is not OVERLAPPING)
import java.util.*;

public class ActivitySelection {
    public static void main(String args[]) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        // if the END arr is not SORTED in prior, we sort using a 2D matrix
        int[][] activities = new int[start.length][3];
        
        for(int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // sort based on end time using LAMBDA FUNCTION (2 ways)

        // Arrays.sort(activities, (a, b) -> a[2] - b[2]); // ✅
        Arrays.sort(activities, Comparator.comparingDouble(a -> a[2]));

        int maxAct = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        // pehla task to krna hi hai
        ans.add(activities[0][0]);
        maxAct++;
        int endTime = activities[0][2];

        for(int i = 1; i < end.length; i++) {
            if (activities[i][1] >= endTime) {
                ans.add(activities[i][0]);
                maxAct++;
                endTime = activities[i][2];
            }
        }

        System.out.println("Max Activities = " + maxAct);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println("Activity = " + ans.get(i));
        }
    }
}