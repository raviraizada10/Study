package com.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreePrinter {
    public static void printTree(TreeNode root) {
        if (root == null) return;

        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1; // Total width for spacing
        List<List<String>> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new ArrayList<>(Collections.nCopies(width, " ")));
        }

        fillTree(lines, root, 0, 0, width - 1);

        for (List<String> line : lines) {
            System.out.println(String.join("", line));
        }
    }

    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static void fillTree(List<List<String>> lines, TreeNode node, int level, int left, int right) {
        if (node == null) return;

        int mid = (left + right) / 2; // Center position
        lines.get(level).set(mid, String.valueOf(node.val));

        fillTree(lines, node.left, level + 1, left, mid - 1);
        fillTree(lines, node.right, level + 1, mid + 1, right);
    }
}
