package Device;

import Backoff.BackoffBackon;
import Backoff.BinaryExponentialBackoff;
import Backoff.GeneralExponentialBackoff;
import Backoff.LinearBackoff;

import java.util.Random;

public class BurstDeviceManager extends DeviceManager {

    int n, k;
    Random random = new Random();
    private final double p = 0.02795084971;
    private final double mu = 35.77708764;

    public BurstDeviceManager(int n, double mean) {
        super();
        this.n = n;
        k = (int) Math.round(mean * mu);
    }

    // change type of devices here for different protocols
    protected void addNewDevices() {
        if (n > 0) {
            double d = random.nextDouble();
            int toAdd = Math.min(k, n);
            if(d < p) {
                for(int i = 0; i < toAdd; ++i) {
                    addDevice(new Device(timeStep, new GeneralExponentialBackoff(1.2)));
                    --n;
                }
            }
        }
    }

    @Override
    public DeviceResult simulate() {
        while (!(devices.isEmpty() && n==0)) tick();
        return new DeviceResult(timeStep, (double) retries / totalDevices);
    }
}
