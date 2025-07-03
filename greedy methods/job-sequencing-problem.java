 import java.util.*;
 class Job {
    String id;
    int deadline, profit;
    Job(String i, int d, int p) {
        id = i;
        deadline = d;
        profit = p;
    }
 }
 public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job("a", 4, 20),
            new Job("b", 1, 10),
            new Job("c", 1, 40),
            new Job("d", 1, 30)
        };
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = Arrays.stream(jobs).mapToInt(j -> j.deadline).max().getAsInt();
        boolean[] slots = new boolean[maxDeadline + 1];
        int totalProfit = 0;
        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    totalProfit += job.profit;
                    break;
