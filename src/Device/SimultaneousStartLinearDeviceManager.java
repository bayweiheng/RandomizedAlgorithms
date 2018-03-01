package Device;

import Backoff.LinearBackoff;

public class SimultaneousStartLinearDeviceManager extends DeviceManager {

     public SimultaneousStartLinearDeviceManager(int n, int c) {
        super();
        for (int i = 0; i < n; i++) {
            addDevice(new Device(0,new LinearBackoff(c)));
        }
     }

}
