package com.gfg.gfg160.tree;

public class MirrorOfTree {
    void mirror(Node node) {
        if (node == null) return;
        mirror(node.left);
        mirror(node.right);
        swap(node);
    }

    public static void swap(Node root) {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
