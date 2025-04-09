package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/diameter-of-binary-tree/", problemNumber = "543", solutionLink = "https://algo.monster/liteproblems/543")
public class DiameterOfTree {

    // Stores the maximum diameter found during DFS traversal
    private static int maxDiameter = Integer.MIN_VALUE;

    /**
     * Calculates the diameter (longest path between any two nodes) of a binary tree.
     * The diameter may or may not pass through the root.
     *
     * @param root the root node of the binary tree
     * @return the length of the longest path between any two nodes in the tree
     *
     * Edge Cases:
     * - If the tree is empty (root is null), returns 0.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        depth(root);
        return maxDiameter;
    }

    /**
     * Recursive helper method to compute the depth of each subtree.
     * While doing so, updates the maximum diameter found.
     *
     * @param node current node in the DFS traversal
     * @return the depth (height) of the subtree rooted at this node
     */
    private int depth(TreeNode node) {
        if (node == null) return 0;

        // Recursively get the depth of left and right subtrees
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        // Update the maximum diameter if the path through this node is longer
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return the height to the parent node
        return 1 + Math.max(leftDepth, rightDepth);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}