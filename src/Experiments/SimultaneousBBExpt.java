package Experiments;

import Device.DeviceResult;
import Device.SimultaneousStartBBDeviceManager;

public class SimultaneousBBExpt {

    public static void run() {
        System.out.println("Running simultaneous backoff backon experiment...");
        for (int n = 10; n <= 1280; n *= 2) {
            ExptResult result = simulate(100, n);
            System.out.printf("n:%d tt:%.2f retry:%.2f%n", n, result.timeTaken, result.avgRetries);
        }
    }

    public static ExptResult simulate(int numTrials, int n) {
        double totalTime = 0, totalRetries = 0;
        for(int i = 0; i < numTrials; ++i) {
            SimultaneousStartBBDeviceManager dm = new SimultaneousStartBBDeviceManager(n);
            DeviceResult result = dm.simulate();
            totalTime += result.timeTaken;
            totalRetries += result.avgRetries;
        }
        return new ExptResult(totalTime / numTrials, totalRetries / numTrials);
    }
}
