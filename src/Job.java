public class Job implements Comparable<Job> {
    int id;
    public int processingTime;
    public int priorityLevel;
    public int arrivalTime;
    public boolean hasArrival;




    public Job(int id, int processingTime) {
        this.id = id;
        this.processingTime = processingTime;
    }

    public Job(int id, int processingTime, int priorityLevel) {
        this.id = id;
        this.processingTime = processingTime;
        this.priorityLevel = priorityLevel;
    }

    public Job(int id, int processingTime, int arrivalTime, boolean hasArrival) {
        this.id = id;
        this.processingTime = processingTime;
        this.arrivalTime = arrivalTime;
        this.hasArrival = hasArrival;
    }

    public int getProcessingTime()
    {
        return this.processingTime;
    }

    public int getArrivalTime()
    {
        return arrivalTime;
    }



    public boolean hasPriority() {
        return this.priorityLevel > 0;
    }

    public boolean hasArrivalTime() {
        return this.hasArrival;
    }

    public void setHasArrivalTime(boolean hasArrival) {
        this.hasArrival = hasArrival;
    }

    // Sorting jobs by their processing time (min-heap priority)
    @Override
    public int compareTo(Job other) {

        if (this.hasArrivalTime() == true){
           // System.out.println("a");
            return (int) (this.arrivalTime - other.arrivalTime);
        } else if (this.hasPriority()) {
            if (this.priorityLevel == other.priorityLevel) {

                return this.processingTime - other.processingTime;
            } else {
                return this.priorityLevel - other.priorityLevel;
            }
        } else {
            //System.out.println("b");
            return this.processingTime - other.processingTime;
        }
    }

}