package com.gfg.gfg160.tree;

import java.util.ArrayList;

public class LevelOrderTraversal {
    /**
     * Performs a level-order traversal of a binary tree using recursion.
     * The result is a list of lists, where each inner list contains nodes at a specific level.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists containing node values level by level.
     * <p>
     * Edge Cases Considered:
     * - If the root is null, the method returns an empty list.
     * - Works with an imbalanced or skewed binary tree.
     * - Handles cases where nodes have missing children.
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> levelOrderResult = new ArrayList<>();

        // Start recursive traversal from the root at level 0
        traverseLevel(root, 0, levelOrderResult);

        return levelOrderResult;
    }

    /**
     * Recursively performs level-order traversal and populates the result list.
     *
     * @param currentNode      The current node being processed.
     * @param currentLevel     The level of the current node in the binary tree.
     * @param levelOrderResult The list storing nodes at each level.
     */
    private static void traverseLevel(Node currentNode, int currentLevel, ArrayList<ArrayList<Integer>> levelOrderResult) {
        // Base Case: If the node is null, return immediately (end of a branch)
        if (currentNode == null) {
            return;
        }

        // If this is the first time reaching this level, create a new list for it
        if (levelOrderResult.size() <= currentLevel) {
            levelOrderResult.add(new ArrayList<>());
        }

        // Add the current node's data to the corresponding level's list
        levelOrderResult
                .get(currentLevel)
                .add(currentNode.data);

        // Recursive Calls: Traverse left and right subtrees, increasing the level count
        traverseLevel(currentNode.left, currentLevel + 1, levelOrderResult);
        traverseLevel(currentNode.right, currentLevel + 1, levelOrderResult);
    }
}

