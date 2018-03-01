package Experiments;

import Device.DeviceResult;
import Device.SimultaneousStartGEBDeviceManager;

public class SimultaneousGEBExpt {

    public static void run() {
        System.out.println("Running simultaneous binary exponential experiment...");
        double[] cs = {1.1, 1.2, 1.4, 1.7, 2.0, 2.5, 3.0, 4.0};
        for (int n = 10; n <= 1280; n *= 2) {
            for(int i = 0; i < 8; ++i) {
                ExptResult result = simulate(100, n, cs[i]);
                System.out.printf("n:%d c:%.1f tt:%.2f retry:%.2f%n", n, cs[i], result.timeTaken, result.avgRetries);
            }
        }
    }

    public static ExptResult simulate(int numTrials, int n, double c) {
        double totalTime = 0, totalRetries = 0;
        for(int i = 0; i < numTrials; ++i) {
            SimultaneousStartGEBDeviceManager dm = new SimultaneousStartGEBDeviceManager(n, c);
            DeviceResult result = dm.simulate();
            totalTime += result.timeTaken;
            totalRetries += result.avgRetries;
        }
        return new ExptResult(totalTime / numTrials, totalRetries / numTrials);
    }
}
