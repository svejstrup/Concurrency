/**
 * Created by Madss on 05-11-2015.
 */
public class Test {
    public static long startTime;

    public static void main(String[] args) {
        int numberOfThreads = 4;
        Buffer buffer = new Buffer();
        Counter counter = new Counter();
        startTime = System.nanoTime();

        for(int i = 0; i < numberOfThreads; i++) {
            CountPrimes temp = new CountPrimes(buffer, counter);
            Thread thread = new Thread(temp);
            thread.start();
        }
    }
}
