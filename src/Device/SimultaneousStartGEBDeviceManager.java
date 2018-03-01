package Device;

import Backoff.GeneralExponentialBackoff;

public class SimultaneousStartGEBDeviceManager extends DeviceManager {
    public SimultaneousStartGEBDeviceManager(int n, double c) {
        super();
        for (int i = 0; i < n; i++) {
            addDevice(new Device(0,new GeneralExponentialBackoff(c)));
        }
    }
}
