/**
 * Created by Madss on 05-11-2015.
 */
public class Counter {
    private volatile int count = 0;

    public synchronized void count(int i) {
        count+= i;
        notifyAll();
    }

    public int getCount() {
        return count;
    }
}
