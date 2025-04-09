package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/top-k-frequent-elements/description/", problemNumber = "347", solutionLink = "https://algo.monster/liteproblems/347")
public class TopKFrequent {
    /**
     * Finds the k most frequent elements in an integer array.
     * Uses a frequency map and a min-heap to efficiently keep track of the top k frequent items.
     *
     * @param nums input array of integers
     * @param k the number of top frequent elements to return
     * @return an array of the k most frequent elements
     *
     * Edge Cases:
     * - If nums is empty, returns an empty array.
     * - If k >= nums.length, returns all unique elements.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Count the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        // Min-heap based on frequency — smallest frequency at the top
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(frequencyMap::get));
        for (int num : frequencyMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element to maintain heap size k
            }
        }

        // Extract elements from the heap into an array (reverse to maintain most-to-least frequency order)
        int[] topKElements = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topKElements[i] = minHeap.poll();
        }
        return topKElements;
    }
}