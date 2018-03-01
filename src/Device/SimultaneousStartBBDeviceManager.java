package Device;

import Backoff.BackoffBackon;

public class SimultaneousStartBBDeviceManager extends DeviceManager {
    public SimultaneousStartBBDeviceManager(int n) {
        super();
        for (int i = 0; i < n; i++) {
            addDevice(new Device(0,new BackoffBackon()));
        }
    }
}
