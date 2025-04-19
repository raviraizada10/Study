package com.leetcode.essential.seventyFive.graph.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutesSimulator {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };

        ReorderRoutesSimulator obj = new ReorderRoutesSimulator();
        int result = obj.minReorder(n, connections);
        System.out.println("✅ Total roads to reverse: " + result);
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Build graph with direction information
        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph
                    .computeIfAbsent(from, x -> new ArrayList<>())
                    .add(new int[]{to, 1});   // original direction
            graph
                    .computeIfAbsent(to, x -> new ArrayList<>())
                    .add(new int[]{from, 0});  // reverse direction
        }

        System.out.println("🔧 Graph:");
        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            System.out.print("City " + entry.getKey() + " -> ");
            for (int[] edge : entry.getValue()) {
                System.out.print("[" + edge[0] + ", needsChange=" + edge[1] + "] ");
            }
            System.out.println();
        }

        System.out.println("\n🚀 DFS Simulation:");
        return dfs(0, -1, graph);
    }

    private int dfs(int curr, int parent, Map<Integer, List<int[]>> graph) {
        int changes = 0;
        System.out.println("Visiting city " + curr + " (from parent " + parent + ")");

        for (int[] neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
            int node = neighbor[0];
            int needsChange = neighbor[1];

            if (node == parent) {
                System.out.println("↩️ Skipping parent city " + node);
                continue;
            }

            if (needsChange == 1) {
                System.out.println("🔁 Edge from " + curr + " to " + node + " needs reversing");
            } else {
                System.out.println("✅ Edge from " + node + " to " + curr + " is correct");
            }

            changes += needsChange + dfs(node, curr, graph);
        }

        return changes;
    }
}
// This code simulates the process of reordering routes in a directed graph.
