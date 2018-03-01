package Device;

import Backoff.BackoffBackon;
import Backoff.BinaryExponentialBackoff;
import Backoff.GeneralExponentialBackoff;
import Backoff.LinearBackoff;

import java.util.Random;

public class PoissonDeviceManager extends DeviceManager {
    int n;
    Random random = new Random();
    double lambda;

    public int getPoisson() {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;

        do {
            k++;
            p *= Math.random();
        } while (p > L);

        return k - 1;
    }

    public PoissonDeviceManager(int n, double lambda) {
        super();
        this.n = n;
        this.lambda = lambda;
    }

    // change type of devices here for different protocols
    protected void addNewDevices() {
        if (n > 0) {
            int numDevices = getPoisson();
            numDevices = Math.min(numDevices, n);
            for(int i = 0; i < numDevices; ++i) {
                addDevice(new Device(timeStep, new LinearBackoff(10)));
                --n;
            }
        }
    }

    @Override
    public DeviceResult simulate() {
        while (!(devices.isEmpty() && n==0)) tick();
        return new DeviceResult(timeStep, (double) retries / totalDevices);
    }
}
