package Backoff;

public class BackoffBackon extends Backoff {

    int k = 1;
    @Override
    public int getNextWindowSize(int currentWindowSize) {
        if (currentWindowSize > 1) return currentWindowSize/2;
        return 1<<(k++);
    }
}
