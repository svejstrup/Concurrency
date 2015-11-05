/**
 * Created by Madss on 05-11-2015.
 */
public class Buffer {
    private volatile int currentNumber = 0;
    private volatile boolean isNotFinished = true;

    public synchronized int getCurrentNumber() {
        currentNumber++;
        if(currentNumber == 10000000) {
            isNotFinished = false;
        }
        notifyAll();
        return currentNumber;
    }

    public synchronized boolean getIsNotFinished() {
        notifyAll();
        return isNotFinished;
    }
}
