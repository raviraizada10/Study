package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashSet;
import java.util.Set;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/", problemNumber = "1261", solutionLink = "https://algo.monster/liteproblems/1261")
public class FindElements {
    Set<Integer> recoveredeSet = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root == null) return;
        root.val = 0;
        recoverTree(root);
    }

    private void recoverTree(TreeNode root) {
        if (root == null) return;
        recoveredeSet.add(root.val);
        if (root.left != null) {
            root.left.val = 2 * root.val +1;
            recoverTree(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val +2;
            recoverTree(root.right);
        }
    }

    public boolean find(int target) {
        return recoveredeSet.contains(target);
    }


}

class TreeNode {
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
