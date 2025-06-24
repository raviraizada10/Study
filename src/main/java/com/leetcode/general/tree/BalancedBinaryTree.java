package com.leetcode.general.tree;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/balanced-binary-tree/", problemNumber = "110", solutionLink = "https://algo.monster/liteproblems/110")
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        // Helper function to check balance and return height
        return heightAndBalance(root) != -1;
    }

    private int heightAndBalance(TreeNode node) {
        if (node == null) {
            return 0; // Empty subtree has height 0
        }

        int leftHeight = heightAndBalance(node.left);
        if (leftHeight == -1) return -1; // Left subtree is unbalanced

        int rightHeight = heightAndBalance(node.right);
        if (rightHeight == -1) return -1; // Right subtree is unbalanced

        // If the height difference is greater than 1, the tree is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Return -1 to indicate unbalanced subtree
        }

        // Return height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}