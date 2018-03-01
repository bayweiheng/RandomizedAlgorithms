package Device;

import Backoff.BackoffBackon;
import Backoff.BinaryExponentialBackoff;
import Backoff.GeneralExponentialBackoff;
import Backoff.LinearBackoff;

import java.util.Random;

public class ConstantProbabilityDeviceManager extends DeviceManager {

    int n;
    Random random = new Random();
    double lambda;

    public ConstantProbabilityDeviceManager(int n, double lambda) {
        super();
        this.n = n;
        this.lambda = lambda;
    }

    // change type of devices here for different protocols
    protected void addNewDevices() {
        if (n > 0) {
            double d = random.nextDouble();
            if(d < lambda) {
                for(int i = 0; i < 2; ++i) {
                    addDevice(new Device(timeStep, new LinearBackoff(10)));
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
