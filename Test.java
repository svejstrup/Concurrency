import java.util.ArrayList;

/**
 * Created by Madss on 05-11-2015.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> threadList = new ArrayList<>();
        int numberOfThreads = 4;
        Buffer buffer = new Buffer();
        Counter counter = new Counter();
        long startTime = System.nanoTime();

        for(int i = 0; i < numberOfThreads; i++) {
            CountPrimes temp = new CountPrimes(buffer, counter);
            Thread thread = new Thread(temp);
            threadList.add(thread);
            thread.start();
        }

        for (Thread t : threadList) {
            t.join();
        }

        System.out.println("Number of primes: " + counter.getCount());
        System.out.println("It took " + (System.nanoTime() - startTime)/1000000 + "ms");
    }
}
