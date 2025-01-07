package com.templates;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSGraph {
    public void breadthFirstSearch(Node startNode) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(startNode);
        Set<Node> visitedNodes = new HashSet<>();
        visitedNodes.add(startNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.pop();
            for (Node neighborNode : getNeighbors(currentNode)) {
                if (visitedNodes.contains(neighborNode)) {
                    continue;
                }
                queue.add(neighborNode);
                visitedNodes.add(neighborNode);
            }
        }
    }

    //Dummy Function
    private List<Node> getNeighbors(Node node) {
        return List.of(node);
    }

    public static class Node<T> {
        public T value; // Holds the value of the node.
        public Node<T> left; // Reference to the left child.
        public Node<T> right; // Reference to the right child.

        // Constructor to initialize a node with only a value.
        public Node(T value) {
            this(value, null, null); // Delegate to the main constructor with null children.
        }

        // Constructor to initialize a node with a value, left child, and right child.
        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}

