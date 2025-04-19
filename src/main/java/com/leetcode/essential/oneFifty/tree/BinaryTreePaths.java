package com.leetcode.essential.oneFifty.tree;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/binary-tree-paths/", problemNumber = "257", solutionLink = "https://algo.monster/liteproblems/257")
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, "");
        return result;
    }


    public void helper(TreeNode node, List<String> result, String pathString) {
        if (node == null) return;
        pathString += node.val;
        if (node.left == null && node.right == null) result.add(pathString);
        else {
            pathString += "->";
            helper(node.left, result, pathString);
            helper(node.right, result, pathString);
        }
    }


    // Definition for a binary tree node.
    public class TreeNode {
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