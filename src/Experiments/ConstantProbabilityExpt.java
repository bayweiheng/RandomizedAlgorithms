package Experiments;

import Device.ConstantProbabilityDeviceManager;
import Device.DeviceResult;

import java.util.ArrayList;

public class ConstantProbabilityExpt {
    public static void run() {
        for (int n = 1280; n <= 1280; n *= 2) {
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Double> b = new ArrayList<>();
            for(int c = 1; c <= 8; ++c) {
                ExptResult result = simulate(100, n, (double) 1/c);
                a.add((int) Math.round(result.timeTaken));
                b.add(result.avgRetries);
            }
            for(Integer i : a) System.out.printf("%d & ",i);
            System.out.println();
            for(Double d : b) System.out.printf("%.2f & ",d);
        }
    }

    public static ExptResult simulate(int numTrials, int n, double lambda) {
        double totalTime = 0, totalRetries = 0;
        for(int i = 0; i < numTrials; ++i) {
            ConstantProbabilityDeviceManager dm = new ConstantProbabilityDeviceManager(n, lambda);
            DeviceResult result = dm.simulate();
            totalTime += result.timeTaken;
            totalRetries += result.avgRetries;
        }
        return new ExptResult(totalTime / numTrials, totalRetries / numTrials);
    }
}
