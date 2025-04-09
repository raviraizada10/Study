package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/binary-tree-right-side-view/", problemNumber = "199", solutionLink = "https://algo.monster/liteproblems/199")
public class BinaryTreeRightSide {

    /**
     * Returns the list of node values visible from the right side of the binary tree.
     *
     * @param root the root of the binary tree
     * @return a list of integer values representing the rightmost node at each level
     *
     * Edge Cases:
     * - If the tree is empty (root is null), returns an empty list.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Edge case: if tree is empty
        if (root == null) return result;

        // Use BFS (level order traversal) to visit nodes level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If it's the last node of the current level, add it to result
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }

                // Add left and right children for next level traversal
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }

        return result;
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