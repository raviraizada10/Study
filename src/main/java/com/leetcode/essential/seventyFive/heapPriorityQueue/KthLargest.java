package com.leetcode.essential.seventyFive.heapPriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75
//https://algo.monster/liteproblems/215
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> elementsQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            elementsQueue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            elementsQueue.poll();
        }
        return elementsQueue.poll();
    }
}
