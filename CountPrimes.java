public class CountPrimes implements Runnable {
    private Buffer buffer;
    private Counter counter;
    private int count = 0;

    private static boolean isPrime(int n) {
        int k = 2;
        while (k * k <= n && n % k != 0)
            k++;
        return n >= 2 && k * k > n;
    }

    public CountPrimes(Buffer aBuffer, Counter aCounter) {
        buffer = aBuffer;
        counter = aCounter;
    }

    @Override
    public void run() {
        while (buffer.getIsNotFinished()) {
            int testNumber = buffer.getCurrentNumber();
            for(int i = testNumber-99; i < testNumber+1; i++) {
                if(isPrime(i)) count++;
            }
        }
        counter.count(count);
        System.out.println("Number of primes: " + counter.getCount());
        System.out.println("It took " + (System.nanoTime() - Test.startTime)/1000000 + "ms");
    }
}
