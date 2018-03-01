package Device;

import java.util.Random;
import Backoff.Backoff;

public class Device {

    private final int enterTime;
    private final Backoff backoff;
    private final Random random = new Random();

    protected int windowSize = 1;
    private int nextWindowStart;
    private int claimTime;

    Device(int enterTime, Backoff backoff) {
        this.enterTime = enterTime;
        this.nextWindowStart = enterTime;
        this.backoff = backoff;
    }

    public boolean poll(int currentTime) {
        if (currentTime == nextWindowStart) {
            claimTime = random.nextInt(windowSize) + nextWindowStart;
            nextWindowStart += windowSize;
            windowSize = backoff.getNextWindowSize(windowSize);
        }
        if (currentTime == claimTime) return true;
        else return false;
    }
}
