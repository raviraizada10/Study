package com.templates;

import com.utils.TreeNode;
import com.utils.TreePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class TreeTraversals {
    // 🔹 1️⃣ Inorder Traversal (Left → Root → Right)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    // 🔹 2️⃣ Preorder Traversal (Root → Left → Right)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    // 🔹 3️⃣ Postorder Traversal (Left → Right → Root)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }

    // 🔹 4️⃣ Level Order Traversal (BFS - Left to Right, Level by Level)
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderHelper(root, result, 0);
        return result;
    }

    private void levelOrderHelper(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() == level) result.add(new ArrayList<>());
        result
                .get(level)
                .add(node.val);
        levelOrderHelper(node.left, result, level + 1);
        levelOrderHelper(node.right, result, level + 1);
    }

    // 🔹 5️⃣ Zigzag Level Order Traversal (Alternating Left-to-Right & Right-to-Left)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagHelper(root, result, 0);
        return result;
    }

    private void zigzagHelper(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() == level) result.add(new LinkedList<>());

        if (level % 2 == 0) {
            result
                    .get(level)
                    .add(node.val);  // Left to Right
        }
        else {
            result
                    .get(level)
                    .add(0, node.val);  // Right to Left (Insert at front)
        }

        zigzagHelper(node.left, result, level + 1);
        zigzagHelper(node.right, result, level + 1);
    }

    // 🔹 Test Function
    public static void main(String[] args) {
        TreeTraversals tree = new TreeTraversals();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreePrinter.printTree(root);

        System.out.println("Inorder: " + tree.inorderTraversal(root));
        System.out.println("Preorder: " + tree.preorderTraversal(root));
        System.out.println("Postorder: " + tree.postorderTraversal(root));
        System.out.println("Level Order: " + tree.levelOrderTraversal(root));
        System.out.println("Zigzag Order: " + tree.zigzagLevelOrder(root));
    }


}
