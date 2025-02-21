package com.gfg.gfg160.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargest {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int el : arr) {
            maxHeap.offer(el);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}
