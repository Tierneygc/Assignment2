import java.io.*;
import java.util.*;



public class Main {
    static class Job implements Comparable<Job> {
        int id;
        int processingTime;
        int priorityLevel;

        public Job(int id, int processingTime) {
            this.id = id;
            this.processingTime = processingTime;
        }

        public Job(int id, int processingTime, int priorityLevel) {
            this.id = id;
            this.processingTime = processingTime;
            this.priorityLevel = priorityLevel;
        }

        public boolean hasPriority() {
            return this.priorityLevel > 0;
        }

        // Sorting jobs by their processing time (min-heap priority)
        @Override
        public int compareTo(Job other) {

            if (this.hasPriority()) {
                if (this.priorityLevel == other.priorityLevel) {

                    return this.processingTime - other.processingTime;
                } else {
                    return this.priorityLevel - other.priorityLevel;
                }
            } else {
                return this.processingTime - other.processingTime;
            }
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
        double average = 0;
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
        average =  Double.valueOf (sum) / size;
        System.out.println("Average completion time:" + average);

        in =  new In("task2-input.txt");

        while (in.hasNextLine())
        {
            String input = in.readLine();
            String[] tokens = input.split(" ");
            int jobId = Integer.parseInt(tokens[0]);
            int processingTime = Integer.parseInt(tokens[1]);
            int priorityLevel = Integer.parseInt(tokens[2]);

            Job job = new Job(jobId, processingTime, priorityLevel);
            jobs.insert(job);
        }
        sum = 0;
        totalProcessing = 0;
        average = 0;
        System.out.print("Execution order: [");
        while (!jobs.isEmpty()) {

            Job nextJob = jobs.delMin();

            totalProcessing = totalProcessing + nextJob.processingTime;
            //System.out.println("proc" + totalProcessing);
            sum = sum + totalProcessing;
            //System.out.println("sum" + sum);// Retrieve and remove the job with the smallest processing time
            System.out.print(nextJob.id + ", ");
        }
        System.out.println("]");
        average =  Double.valueOf (sum) / size;
        System.out.println("Average completion time:" + average);


    }

}