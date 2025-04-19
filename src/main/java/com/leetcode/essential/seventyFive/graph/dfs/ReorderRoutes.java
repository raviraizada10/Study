package com.leetcode.essential.seventyFive.graph.dfs;

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
@ProblemInfo(problemLink = "https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/", problemNumber = "1466", solutionLink = "https://algo.monster/liteproblems/1466")
public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new int[]{to, 1});   // original edge
            graph.computeIfAbsent(to, x -> new ArrayList<>()).add(new int[]{from, 0});  // reverse edge
        }

        return dfs(0, -1, graph);
    }

    private int dfs(int curr, int parent, Map<Integer, List<int[]>> graph) {
        int changes = 0;
        for (int[] neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
            int node = neighbor[0], needsChange = neighbor[1];
            if (node == parent) continue;
            changes += needsChange + dfs(node, curr, graph);
        }
        return changes;
    }
}   