package com.leetcode.potd;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/take-gifts-from-the-richest-pile/
//2558
public class PickGifts {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> sortedGifts = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            sortedGifts.add(gift);
        }
        for (int i = 0; i < k; i++) {
            if(sortedGifts.isEmpty()) break;
            int maxGifts = sortedGifts.poll();
            int remaining = (int) Math.floor(Math.sqrt(maxGifts));
            sortedGifts.offer(remaining);
        }

        long totalRemaining = 0;
        while (!sortedGifts.isEmpty()) {
            totalRemaining += sortedGifts.poll();
        }

        return totalRemaining;

    }
}
