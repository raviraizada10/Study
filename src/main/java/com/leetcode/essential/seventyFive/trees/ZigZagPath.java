package com.leetcode.essential.seventyFive.trees;

public class ZigZagPath {
    // This variable will store the maximum ZigZag length encountered during the DFS traversal
    private int maxZigZag = 0;

    // The main function that will be called to return the longest ZigZag path
    public int longestZigZag(TreeNode root) {
        // Start DFS from the root node, first moving left (isLeft = true) and then moving right (isLeft = false)
        dfs(root, 0, true);  // Start with moving left
        dfs(root, 0, false); // Start with moving right
        return maxZigZag;    // Return the maximum ZigZag length found
    }

    // Helper function that performs DFS traversal
    // 'node' is the current node we're processing
    // 'length' is the current length of the ZigZag path
    // 'isLeft' indicates whether the previous move was to the left or to the right
    private void dfs(TreeNode node, int length, boolean isLeft) {
        // Base case: if the node is null, return
        if (node == null) {
            return;
        }

        // Update the maximum ZigZag length found so far
        maxZigZag = Math.max(maxZigZag, length);

        // If we were moving to the left previously (isLeft == true), now we must move to the right
        if (isLeft) {
            // Move left and change direction to right for the next step
            dfs(node.left, length + 1, false); // Continue ZigZag path by going left
            // Move right and change direction to left for the next step
            dfs(node.right, 1, true); // Start a new ZigZag path by going right
        }
        else {
            // If we were moving to the right previously (isLeft == false), now we must move to the left
            // Move right and change direction to left for the next step
            dfs(node.right, length + 1, true); // Continue ZigZag path by going right
            // Move left and change direction to right for the next step
            dfs(node.left, 1, false); // Start a new ZigZag path by going left
        }
    }
}
