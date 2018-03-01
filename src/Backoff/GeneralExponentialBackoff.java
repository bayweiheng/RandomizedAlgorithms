package Backoff;

public class GeneralExponentialBackoff extends Backoff {
    double c;
    public GeneralExponentialBackoff(double c) {
        super();
        this.c = c;
    }
    public int getNextWindowSize(int currentWindowSize) {
        return (int) Math.ceil(c*currentWindowSize);
    }
}
