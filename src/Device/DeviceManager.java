package Device;

import java.util.ArrayList;

public class DeviceManager {

    protected int timeStep = 0;
    int retries = 0;
    int totalDevices = 0;
    protected ArrayList<Device> devices = new ArrayList<>();

    public DeviceManager() {}

    protected void addNewDevices() {

    }

    protected void addDevice(Device d) {
        devices.add(d);
        totalDevices++;
    }

    private void pollAll() {
        int numClaiming = 0;
        Device claimingDevice = null;
        for (Device d: devices) {
            if (d.poll(timeStep)) {
                numClaiming++;
                claimingDevice = d;
            }
        }
        if (numClaiming == 1) devices.remove(claimingDevice);
        else retries += numClaiming;
    }

    void tick() {
        addNewDevices();
        pollAll();
        timeStep++;
    }

    public DeviceResult simulate() {
        while (!devices.isEmpty()) tick();
        return new DeviceResult(timeStep, (double) retries / totalDevices);
    }

}
