package com.leetcode.essential.seventyFive.trees;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
//104
//https://algo.monster/liteproblems/104
public class MaxDepth {
    /**
     * Calculates the maximum depth of a binary tree.
     * The depth of a binary tree is the number of nodes along the longest path
     * from the root node down to the farthest leaf node.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth of the tree.
     */
    public int maxDepth(TreeNode root) {
        // Base case: If the root is null, the tree is empty, and the depth is 0.
        if (root == null) {
            return 0;
        }

        // Recursively compute the depth of the left subtree.
        int leftDepth = maxDepth(root.left);

        // Recursively compute the depth of the right subtree.
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is the greater of its two children's depths plus one.
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
