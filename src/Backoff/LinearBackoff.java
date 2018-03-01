package Backoff;

public class LinearBackoff extends Backoff {
    int c;
    public LinearBackoff(int c) {
        super();
        this.c = c;
    }
    public int getNextWindowSize(int currentWindowSize) {
        return currentWindowSize + c;
    }
}
