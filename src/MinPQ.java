
public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n;

    public MinPQ(int capacity)
    { pq = (Key[]) new Comparable[capacity+1]; }
    public boolean isEmpty()
    { return n == 0; }
    public void insert(Key x) {
        pq[++n] = x;
        swim(n);
    }// see previous code
    public Key delMax(){

        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;
        return min;
    }// see previous code

    private void swim(int k){
        while (k > 1 && greater(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

}