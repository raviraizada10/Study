package com.gfg.gfg160.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LongestBoundedDiffSubarray {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int l = 0, maxLen = 0, startIdx = 0;

        for (int r = 0; r < arr.length; r++) {
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[r]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(r);

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[r]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(r);

            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                l++;
                if (!minDeque.isEmpty() && minDeque.peekFirst() < l) {
                    minDeque.pollFirst();
                }
                if (!maxDeque.isEmpty() && maxDeque.peekFirst() < l) {
                    maxDeque.pollFirst();
                }
            }

            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                startIdx = l;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIdx; i < startIdx + maxLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
