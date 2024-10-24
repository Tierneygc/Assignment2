import java.io.*;
import java.util.*;



public class Main {
    static class Job implements Comparable<Job> {
        int id;
        int processingTime;

        public Job(int id, int processingTime) {
            this.id = id;
            this.processingTime = processingTime;
        }

        // Sorting jobs by their processing time (min-heap priority)
        @Override
        public int compareTo(Job other) {
            return this.processingTime - other.processingTime;
        }
    }
    public static void main(String[] args) {
        In in = new In("task1-input.txt");

        MinPQ<Job> jobs = new MinPQ<Job>(101);

        while (in.hasNextLine())
        {
            String input = in.readLine();
            String[] tokens = input.split(" ");
            int jobId = Integer.parseInt(tokens[0]);
            int processingTime = Integer.parseInt(tokens[1]);

            Job job = new Job(jobId, processingTime);
            jobs.insert(job);
        }
    int sum = 0;
        int totalProcessing = 0;
        int average = 0;
        int size = jobs.size();
        System.out.print("Execution order: [");
        while (!jobs.isEmpty()) {

            Job nextJob = jobs.delMin();

            totalProcessing = totalProcessing + nextJob.processingTime;
            //System.out.println("proc" + totalProcessing);
            sum = sum + totalProcessing;
           // System.out.println("sum" + sum);// Retrieve and remove the job with the smallest processing time
            System.out.print(nextJob.id + ", ");
        }
        System.out.println("]");
        average = sum / size;
        System.out.println("Average completion time:" + average);
    }
}