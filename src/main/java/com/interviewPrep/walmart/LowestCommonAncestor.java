package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/", problemNumber = "235", solutionLink = "https://algo.monster/liteproblems/235")
public class LowestCommonAncestor {
    /**
     * Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).
     * Leverages the BST property: left < root < right.
     *
     * @param root  the root of the BST
     * @param node1 one of the target nodes
     * @param node2 the other target node
     * @return the lowest node in the tree that has both node1 and node2 as descendants
     *
     * Edge Cases:
     * - If either node is not in the tree, returns null.
     * - If one node is the ancestor of the other, returns the ancestor.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null; // Base case: if the current node is null, return null.

        // If both nodes are greater than root, the LCA must be in the right subtree
        if (node1.val > root.val && node2.val > root.val) {
            return lowestCommonAncestor(root.right, node1, node2);
        }
        // If both nodes are less than root, the LCA must be in the left subtree
        else if (node1.val < root.val && node2.val < root.val) {
            return lowestCommonAncestor(root.left, node1, node2);
        }
        // If nodes split across root, root is the LCA
        return root;
    }

    /**
     * Definition of a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left; // left child
        TreeNode right; // right child

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