package com.leetcode.essential.seventyFive.trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
//872
//https://algo.monster/liteproblems/872
public class LeafSimilar {

    /**
     * Determines if two binary trees are leaf-similar.
     * Two trees are leaf-similar if their leaf nodes form the same sequence.
     *
     * @param root1 The root of the first binary tree.
     * @param root2 The root of the second binary tree.
     * @return True if the trees are leaf-similar, false otherwise.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // Traverse both trees to collect the leaf node values
        List<Integer> root1Leaves = traverseAndCollectLeaves(root1);
        List<Integer> root2Leaves = traverseAndCollectLeaves(root2);

        // Compare the collected leaf node values of both trees
        return root1Leaves.equals(root2Leaves);
    }

    /**
     * Helper method to perform DFS and collect leaf nodes' values from a tree.
     *
     * @param node The current node being processed.
     * @return A list of integers representing the leaf node values.
     */
    private List<Integer> traverseAndCollectLeaves(TreeNode node) {
        // Base case: if the node is null, return an empty list
        if (node == null) {
            return new ArrayList<>();
        }

        // Initialize a list to store leaf node values
        List<Integer> leaves = new ArrayList<>();

        // Recursively collect leaves from the left subtree
        leaves.addAll(traverseAndCollectLeaves(node.left));

        // Recursively collect leaves from the right subtree
        leaves.addAll(traverseAndCollectLeaves(node.right));

        // If the current node is a leaf (no children), add its value to the list
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }

        // Return the list of collected leaf values
        return leaves;
    }
}
