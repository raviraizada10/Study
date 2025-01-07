package com.leetcode.essential.seventyFive.trees;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
//https://algo.monster/liteproblems/700
public class SearchBST {
    /**
     * Searches for a node with a given value in a Binary Search Tree (BST).
     *
     * @param root The root node of the BST.
     * @param val  The value to search for.
     * @return The node containing the value, or null if not found.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: If the root is null, return null (node not found)
        // Or if the root's value matches the target value, return the current node
        if (root == null || root.val == val) {
            return root;
        }

        // If the target value is greater than the current node's value,
        // recursively search in the right subtree.
        // Otherwise, search in the left subtree.
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
