import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pqMaxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double fraction = (double)arr[i] / arr[j];
                pqMaxHeap.add(new double[]{fraction, (double)arr[i], (double)arr[j]});
                if (pqMaxHeap.size() > k) {
                    pqMaxHeap.poll();
                }
            }
        }
        double[] pairAns = pqMaxHeap.poll();
        return new int[]{(int)pairAns[1], (int)pairAns[2]};
    }
}

