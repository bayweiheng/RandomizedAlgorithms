package Backoff;

public class BinaryExponentialBackoff extends Backoff {

    @Override
    public int getNextWindowSize(int currentWindowSize) {
        return 2*currentWindowSize;
    }
}
