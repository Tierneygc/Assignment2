import java.io.*;
import java.util.*;



public class Main{


    public static void main(String[] args) {
        In in = new In("task1-input.txt");
        System.out.println();
        System.out.println("Task 1 Output:");

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
        System.out.println();
        System.out.println("Task 2 Output: ");

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
        System.out.println();
        System.out.println("Task 3 Output:");
        while (in.hasNextLine())
        {

            String input = in.readLine();
            String[] tokens = input.split(" ");
            int jobId = Integer.parseInt(tokens[0]);
            int processingTime = Integer.parseInt(tokens[1]);
            int arrivalTime = Integer.parseInt(tokens[2]);

            Job job = new Job(jobId, processingTime, arrivalTime, true);
            int currentTime = job.arrivalTime;

            jobs.insert(job);


        }
        MinPQ<Job> pq = new MinPQ<Job>(101);
         int index = 0;
         int currentTime = 0;
         int k =0;

        sum = 0;
         totalProcessing = 0;
         average = 0;

//        while (!jobs.isEmpty()) {
//
//            Job nextJob = jobs.delMin();
//
//            totalProcessing = totalProcessing + nextJob.processingTime;
//            //System.out.println("proc" + totalProcessing);
//            sum = sum + totalProcessing;
//            //System.out.println("sum" + sum);// Retrieve and remove the job with the smallest processing time
//            System.out.print(nextJob.arrivalTime + ", ");
//        }
        Job temp = jobs.delMin();
        int jobSize = jobs.size();
        System.out.print("[");
        while (index <= jobSize || !pq.isEmpty()) {
            //System.out.println("index" + index);
            while (temp.arrivalTime <= currentTime && index <= jobSize) {

                temp.setHasArrivalTime(false);
               // System.out.println("tmp" + temp.hasArrival);
                pq.insert(temp);
                //System.out.println("tmp" + temp.id);

               index++;
               if (!jobs.isEmpty()) {
                   temp = jobs.delMin();
                   temp.setHasArrivalTime(false);
               }

            }


                Job job = pq.delMin();

//            System.out.println("pq" + job.id);
            currentTime = currentTime + job.processingTime;
            sum += currentTime;

                //System.out.println("curr" + currentTime);
                System.out.print(job.id + ", ");





        }
        System.out.println("]");

        average = sum / jobSize;
        System.out.println("Average completion time: " + average);

//
//
//        Job[] pq = new Job[jobs.size()];
//        int index = 0;
//
//        while (!jobs.isEmpty()){
//            Job job = jobs.delMin();
//            System.out.println(job.id);
//            pq[index] = job;
//            index++;
//        }
//        int currentTime = pq[0].processingTime;
//        System.out.print("Execution Order: [" + pq[0].id);
//
//        int n = 1;
//        while (n < pq.length){
//
//            int currentMin = n;
//            int k=currentMin;
//            for (int i = n; (pq[i].arrivalTime <= currentTime) && (i < pq.length); i++){
////                System.out.println("length" + pq.length);
//                if (pq[i].processingTime < pq[currentMin].processingTime) {
//                    System.out.println("min" + pq[i].id);
//                    k = currentMin;
//                    currentMin = i;
//
//                }
//
//            }
//            if (currentMin != n){
//                    Job temp = pq[currentMin];
////                    for (int j = currentMin-1; j >= n; j--){
////                        pq[j+1] = pq[j];
////                    }
//                pq[currentMin] = pq[k];
//                    pq[k] = temp;
//
//
//            }
//            System.out.print(", " + pq[n].id);
//            currentTime += pq[n].processingTime;
//
//
//            n++;
//
//        }
//        System.out.print("[");
//        for(Job j : pq){
//            System.out.print(j.id + ", ");
//        }
//





    }

}