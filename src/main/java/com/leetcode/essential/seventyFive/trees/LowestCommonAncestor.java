package com.leetcode.essential.seventyFive.trees;

public class LowestCommonAncestor {
    // Function to find the Lowest Common Ancestor (LCA) of two nodes in the binary tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Base case: if root is null or root is one of the nodes p or q, return root
        // This means that we either reached the end of the tree (null) or found one of the nodes.
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search for LCA in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Recursively search for LCA in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right subtrees returned non-null values,
        // it means p and q are in different subtrees of the current node.
        // Hence, the current node (root) is their LCA.
        if (left != null && right != null) {
            return root;  // Current node is the LCA
        }

        // If only one of the left or right is non-null, it means both p and q are in the same subtree.
        // Return the non-null value (either left or right).
        // If both left and right are null, we will return null (the base case).
        return left != null ? left : right;
    }
}
