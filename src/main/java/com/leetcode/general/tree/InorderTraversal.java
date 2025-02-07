package com.leetcode.general.tree;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(EASY)
@ProblemCategory({TREE, STACK, DEPTH_FIRST_SEARCH, BINARY_TREE})
@ProblemInfo(problemLink = "https://leetcode.com/problems/binary-tree-inorder-traversal/", problemNumber = "94", solutionLink = "https://algo.monster/liteproblems/94")
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            }
            else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                else {
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}

