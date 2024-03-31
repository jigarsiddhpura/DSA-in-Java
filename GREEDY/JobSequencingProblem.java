import java.util.*;

public class JobSequencingProblem {
    static class Jobs {
        int id, deadline, profit;

        public Jobs (int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String args[]) {
        int[][] jobsInfo = {{4,20}, {1,10}, {1,40}, {1,30}};

        List<Jobs> jobs = new ArrayList<>();
        for(int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Jobs(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // sort based on profit in desc order
        Collections.sort(jobs, (a,b) -> b.profit - a.profit);
        List<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int i = 0; i < jobs.size(); i++) {
            Jobs currJob = jobs.get(i);
            if (currJob.deadline > time) {
                time++; // bcz time to complete each JOB is 1 unit
                seq.add(currJob.id);
            }
        }

        System.out.println("Sequence of Jobs (index): " + seq);

    }
}