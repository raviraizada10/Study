package com.leetcode.essential.seventyFive.trees;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
//1448
//https://algo.monster/liteproblems/1448
public class GoodNodes {

    // Global variable to count the number of good nodes
    private int goodNodes = 0;

    /**
     * Main method to calculate the number of good nodes in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The total number of good nodes.
     */
    public int goodNodes(TreeNode root) {
        // Start DFS traversal with the root node and an initial max value of Integer.MIN_VALUE
        dfs(root, Integer.MIN_VALUE);
        return goodNodes; // Return the final count of good nodes
    }

    /**
     * Depth-First Search helper method to traverse the binary tree.
     *
     * @param node     The current node being processed.
     * @param maxSoFar The maximum value encountered along the path from the root to this node.
     */
    private void dfs(TreeNode node, int maxSoFar) {
        // Base case: If the current node is null, return (end recursion)
        if (node == null) {
            return;
        }

        // Check if the current node is a "good node"
        if (node.val >= maxSoFar) {
            // Update the max value on the path
            maxSoFar = node.val;
            // Increment the good nodes counter
            goodNodes++;
        }

        // Recursively traverse the left and right children
        dfs(node.left, maxSoFar);
        dfs(node.right, maxSoFar);
    }
}
