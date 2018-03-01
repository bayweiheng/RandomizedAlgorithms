package Experiments;

import Device.DeviceResult;
import Device.SimultaneousStartLinearDeviceManager;

public class SimultaneousLinearExpt {

    public static void run() {
        System.out.println("Running simultaneous linear experiment...");
        for (int n = 10; n <= 1280; n *= 2) {
            for(int c = 10; c <= 10; c +=2) {
                ExptResult result = simulate(200, n, c);
                System.out.printf("n:%d c:%d tt:%.2f retry:%.2f%n", n, c, result.timeTaken, result.avgRetries);
            }
        }
    }

    public static ExptResult simulate(int numTrials, int n, int c) {
        double totalTime = 0, totalRetries = 0;
        for(int i = 0; i < numTrials; ++i) {
            SimultaneousStartLinearDeviceManager dm = new SimultaneousStartLinearDeviceManager(n, c);
            DeviceResult result = dm.simulate();
            totalTime += result.timeTaken;
            totalRetries += result.avgRetries;
        }
        return new ExptResult(totalTime / numTrials, totalRetries / numTrials);
    }
}
