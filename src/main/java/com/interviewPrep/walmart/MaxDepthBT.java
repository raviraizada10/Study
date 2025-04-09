package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-depth-of-binary-tree/", problemNumber = "104", solutionLink = "https://algo.monster/liteproblems/104")
public class MaxDepthBT {

    /**
     * Computes the maximum depth (or height) of a binary tree.
     * Depth is defined as the number of nodes along the longest path from root to a leaf.
     *
     * @param root the root node of the binary tree
     * @return the maximum depth of the tree
     *
     * Edge Cases:
     * - If the tree is empty (root is null), returns 0.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // Base case: null node has depth 0

        // Recursively compute the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the greater of the two depths plus one for the current node
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        /** Default constructor */
        TreeNode() {
        }

        /**
         * Constructor initializing node with value.
         * @param val integer value of the node
         */
        TreeNode(int val) {
            this.val = val;
        }

        /**
         * Constructor initializing node with value and left/right children.
         * @param val value of the node
         * @param left left child
         * @param right right child
         */
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}