package com.leetcode.essential.seventyFive.trees;

import java.util.ArrayDeque;
import java.util.Deque;


//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
//https://algo.monster/liteproblems/1161
public class MaxLevelSum {
    /**
     * Finds the level with the maximum sum of node values in a binary tree.
     * <p>
     * This method performs a level-order traversal of the binary tree, calculating the sum
     * of node values at each level. It then returns the level with the maximum sum.
     *
     * @param root The root of the binary tree.
     * @return The level with the maximum sum of node values.
     */
    public int maxLevelSum(TreeNode root) {
        // Initialize the deque for level-order traversal.
        Deque<TreeNode> executionQueue = new ArrayDeque<>();
        executionQueue.offer(root);  // Start with the root node.

        // Variables to keep track of the maximum sum and corresponding level.
        var maxSum = Integer.MIN_VALUE;  // Initialize max sum to the smallest possible value.
        var level = 0;                   // Counter for the current level.
        var maxLevel = 0;                // Store the level with the maximum sum.

        // Continue traversal as long as there are nodes in the queue.
        while (!executionQueue.isEmpty()) {
            var levelSum = 0;  // Variable to track the sum of node values at the current level.
            level++;           // Increment the level counter.

            // Process all nodes at the current level.
            for (int count = executionQueue.size(); count > 0; --count) {
                // Remove the front node from the queue and process it.
                TreeNode node = executionQueue.pollFirst();

                // Add the value of the current node to the level sum.
                levelSum += node.val;

                // If the current node has a left child, add it to the queue.
                if (node.left != null) {
                    executionQueue.offer(node.left);
                }
                // If the current node has a right child, add it to the queue.
                if (node.right != null) {
                    executionQueue.offer(node.right);
                }
            }

            // If the sum of the current level is greater than the max sum found so far,
            // update maxSum and the corresponding level.
            if (maxSum < levelSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
        }

        // Return the level with the maximum sum.
        return maxLevel;
    }
}
