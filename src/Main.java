import java.io.*;
import java.util.*;



public class Main{
    public static class Job implements Comparable<Job> {
        int id;
        public int processingTime;
        public int priorityLevel;
        public double arrivalTime;




        public Job(int id, int processingTime) {
            this.id = id;
            this.processingTime = processingTime;
        }

        public Job(int id, int processingTime, int priorityLevel) {
            this.id = id;
            this.processingTime = processingTime;
            this.priorityLevel = priorityLevel;
        }

        public Job(int id, int processingTime, double arrivalTime) {
            this.id = id;
            this.processingTime = processingTime;
            this.arrivalTime = arrivalTime;
        }

        public int getProcessingTime()
        {
            return this.processingTime;
        }

        public double getArrivalTimeTime()
        {
            return this.arrivalTime;
        }



        public boolean hasPriority() {
            return this.priorityLevel > 0;
        }

        public boolean hasArrivalTime() {
            return this.arrivalTime >= 0;
        }
        // Sorting jobs by their processing time (min-heap priority)
        @Override
        public int compareTo(Job other) {

            if (this.hasArrivalTime()){
                return (int) (this.arrivalTime - other.arrivalTime);
            } else if (this.hasPriority()) {
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


        in =  new In("task3-input.txt");
        while (in.hasNextLine())
        {
            String input = in.readLine();
            String[] tokens = input.split(" ");
            int jobId = Integer.parseInt(tokens[0]);
            int processingTime = Integer.parseInt(tokens[1]);
            double arrivalTime = Double.parseDouble(tokens[2]);

            Job job = new Job(jobId, processingTime, arrivalTime);
            jobs.insert(job);
        }
//        while (!jobs.isEmpty()) {
//
//            Job nextJob = jobs.delMin();
//
//            totalProcessing = totalProcessing + nextJob.processingTime;
//            //System.out.println("proc" + totalProcessing);
//            sum = sum + totalProcessing;
//            //System.out.println("sum" + sum);// Retrieve and remove the job with the smallest processing time
//            System.out.print(nextJob.id + ", ");
//        }

        Job[] pq = new Job[jobs.size()];
        int index = 0;

        while (!jobs.isEmpty()){
            Job job = jobs.delMin();
            System.out.println(job.id);
            pq[index] = job;
            index++;
        }
        int currentTime = pq[0].processingTime;
        System.out.print("Execution Order: [" + pq[0].id);

        int n = 1;
        while (n < pq.length){

            int currentMin = n;
            for (int i = n; pq[i].arrivalTime <= currentTime && i < pq.length - 1; i++){
//                System.out.println("length" + pq.length);
                if (pq[i].processingTime < pq[currentMin].processingTime) {
                    currentMin = i;
                }

            }
            if (currentMin != n){
                    Job temp = pq[currentMin];
                    for ()
                    pq[n] = pq[currentMin];
                    pq[currentMin] = temp;

            }
            System.out.print(", " + pq[n].id);
            currentTime += pq[n].processingTime;

            n++;

        }






    }

}