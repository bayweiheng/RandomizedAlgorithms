package Device;

import Backoff.BinaryExponentialBackoff;

public class SimultaneousStartBEBDeviceManager extends DeviceManager {
    public SimultaneousStartBEBDeviceManager(int n) {
        super();
        for (int i = 0; i < n; i++) {
            addDevice(new Device(0,new BinaryExponentialBackoff()));
        }
    }
}
