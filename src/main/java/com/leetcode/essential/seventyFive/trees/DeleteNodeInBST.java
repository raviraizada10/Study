package com.leetcode.essential.seventyFive.trees;

//https://leetcode.com/problems/delete-node-in-a-bst/
//https://algo.monster/liteproblems/450
public class DeleteNodeInBST {
    /**
     * Deletes a node with the specified key from the Binary Search Tree (BST).
     *
     * @param root The root of the BST.
     * @param key  The value of the node to be deleted.
     * @return The root of the BST after deletion.
     * <p>
     * The function follows these steps:
     * 1. Traverse the tree to locate the node with the specified key.
     * 2. Handle three cases:
     * a. Node has no children (leaf node): Simply remove it.
     * b. Node has one child: Replace the node with its child.
     * c. Node has two children: Replace the node with its inorder successor
     * (smallest node in the right subtree) and delete the successor.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: If the tree is empty or the key is not found, return null.
        if (root == null) {
            return null;
        }

        // If the key to be deleted is smaller than the current node's value,
        // it lies in the left subtree.
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // If the key to be deleted is greater than the current node's value,
        // it lies in the right subtree.
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If the key matches the current node's value, this is the node to delete.
        else {
            // Case 1: Node has no left child
            if (root.left == null) {
                return root.right; // Replace the node with its right child.
            }

            // Case 2: Node has no right child
            if (root.right == null) {
                return root.left; // Replace the node with its left child.
            }

            // Case 3: Node has two children
            // Find the inorder successor (smallest node in the right subtree).
            TreeNode successor = findMin(root.right);

            // Replace the current node's value with the successor's value.
            root.val = successor.val;

            // Delete the inorder successor from the right subtree.
            root.right = deleteNode(root.right, successor.val);
        }

        // Return the updated root.
        return root;
    }

    /**
     * Finds the smallest node (inorder successor) in a BST starting from the given node.
     *
     * @param node The root of the subtree where the search begins.
     * @return The node with the smallest value in the subtree.
     */
    private TreeNode findMin(TreeNode node) {
        // Traverse to the leftmost node in the subtree.
        while (node.left != null) {
            node = node.left;
        }
        return node; // Return the smallest node.
    }

}
