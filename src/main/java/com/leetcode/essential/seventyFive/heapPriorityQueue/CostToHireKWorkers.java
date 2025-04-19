package com.leetcode.essential.seventyFive.heapPriorityQueue;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.PriorityQueue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, TWO_POINTERS, HEAP, SORTING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/total-cost-to-hire-k-workers/description/", problemNumber = "2462", solutionLink = "https://algo.monster/liteproblems/2462")
public class CostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = 0;
        int right = n - 1;

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        long totalCost = 0;

        while (left <= right && leftHeap.size() < candidates) {
            leftHeap.offer(costs[left++]);
        }

        while (left <= right && rightHeap.size() < candidates) {
            rightHeap.offer(costs[right--]);
        }

        for (int i = 0; i < k; i++) {
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            }
            else {
                totalCost += rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return totalCost;
    }
}