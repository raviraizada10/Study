package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/clone-graph/description/", problemNumber = "133", solutionLink = "https://algo.monster/liteproblems/133")
public class CloneGraph {
    private Map<Node, Node> visited = new HashMap<>();

    /**
     * 📝 Clone Graph – DFS with HashMap
     * Use DFS to traverse the graph and a HashMap to store already cloned nodes.
     * When visiting a node, clone it and recursively clone its neighbors.
     * If a node is already in the map, return the cloned version to avoid cycles and duplicates.
     */
    public Node cloneGraph(Node node) {
        // If the node is null, return null (base case)
        if (node == null) return null;

        // If the node has already been visited (cloned), return the clone from the visited map
        if (visited.containsKey(node)) return visited.get(node);

        // Create a new node with the same value as the original node
        Node clone = new Node(node.val);

        // Store the clone in the visited map to avoid re-cloning
        visited.put(node, clone);

        // Recursively clone the neighbors of the current node
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));  // Add cloned neighbors to the clone
        }

        // Return the cloned node
        return clone;
    }

    /**
     * Definition for a Node in an undirected graph.
     * Each node contains an integer value and a list of its neighboring nodes.
     */
    class Node {
        // Unique integer identifier for this node
        public int val;

        // List of neighboring nodes connected to this node
        public List<Node> neighbors;

        /**
         * Default constructor: creates a node with value 0 and empty neighbor list.
         */
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        /**
         * Constructs a node with the given value and an empty neighbor list.
         *
         * @param _val the integer value of the node
         */
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        /**
         * Constructs a node with the given value and neighbor list.
         *
         * @param _val       the integer value of the node
         * @param _neighbors the list of neighboring nodes
         */
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}