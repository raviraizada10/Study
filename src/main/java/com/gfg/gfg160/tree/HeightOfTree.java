package com.gfg.gfg160.tree;

public class HeightOfTree {
    /**
     * Computes the height of a binary tree.
     * The height is the number of edges in the longest path from root to a leaf.
     *
     * @param root The root node of the binary tree.
     * @return The height of the tree (number of edges in the longest path).
     *
     * Edge Cases:
     * - If the tree is empty (null root), height is -1.
     * - If the tree has only one node, height is 0.
     * - Works for balanced and skewed trees.
     */
    public static int findTreeHeight(Node root) {
        // Base Case: If the node is null, return -1 (height of an empty tree)
        if (root == null) {
            return -1;
        }

        // Recursively compute the height of the left and right subtrees
        int leftSubtreeHeight = findTreeHeight(root.left);
        int rightSubtreeHeight = findTreeHeight(root.right);

        // The height of the tree is the maximum height of its subtrees + 1
        return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1;
    }


}
