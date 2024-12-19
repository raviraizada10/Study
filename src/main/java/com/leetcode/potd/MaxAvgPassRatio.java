package com.leetcode.potd;

import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-average-pass-ratio/description/
//1792
public class MaxAvgPassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        // Add all classes to the heap with their initial gain
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = getGain(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }

        // Assign extra students
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            double gain = top[0];
            int pass = (int) top[1], total = (int) top[2];

            // Add one student to the current class
            pass++;
            total++;
            extraStudents--;

            // Recalculate the gain and add back to the heap
            maxHeap.offer(new double[]{getGain(pass, total), pass, total});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1], total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;

    }


    // Helper method to calculate the gain in pass ratio for adding one student
    private double getGain(int pass, int total) {
        return (double) (pass + 1) / (total + 1) - (double) pass / total;
    }
}
