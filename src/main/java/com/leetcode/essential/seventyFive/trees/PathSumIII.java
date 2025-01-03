package com.leetcode.essential.seventyFive.trees;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    // A map to store the cumulative sum up to all the ancestors of a node and their respective counts.
    private Map<Long, Integer> cumulativeSumCount = new HashMap<>();
    // The target sum to find in the path.
    private int targetSum;

    // Public function to call the private dfs function and initialize the cumulativeSumCount.
    public int pathSum(TreeNode root, int targetSum) {
        // Initialize the map with zero cumulative sum having a count of one.
        cumulativeSumCount.put(0L, 1);
        // Store the target sum in the global variable to use in the dfs function.
        this.targetSum = targetSum;
        // Start the DFS traversal.
        return dfs(root, 0);
    }

    // A private function to perform the DFS traversal and find paths with sums equal to targetSum.
    private int dfs(TreeNode node, long currentSum) {
        // Base case: If the current node is null, return 0 as there are no paths through this node.
        if (node == null) {
            return 0;
        }
        // Add the current node's value to the cumulative sum.
        currentSum += node.val;
        // Find the number of paths that end at this node with a sum equal to targetSum.
        int pathCount = cumulativeSumCount.getOrDefault(currentSum - targetSum, 0);
        // Update the map with the new cumulative sum, incrementing its count by 1.
        cumulativeSumCount.merge(currentSum, 1, Integer::sum);
        // Recursively call dfs for the left child.
        pathCount += dfs(node.left, currentSum);
        // Recursively call dfs for the right child.
        pathCount += dfs(node.right, currentSum);
        // After the children have been processed, decrement the count of the currentSum
        // path count because it should not be counted in other paths.
        cumulativeSumCount.merge(currentSum, -1, Integer::sum);
        // Return the total count of valid paths found from this node.
        return pathCount;
    }
}
