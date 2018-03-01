package Backoff;

public abstract class Backoff {
    public Backoff() {}
    public abstract int getNextWindowSize(int currentWindowSize);
}
