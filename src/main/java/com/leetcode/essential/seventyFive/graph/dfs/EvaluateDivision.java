package com.leetcode.essential.seventyFive.graph.dfs;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.*;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/evaluate-division/description/", problemNumber = "399", solutionLink = "https://algo.monster/liteproblems/399")
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(a, key -> new HashMap<>()).put(b, val);
            graph.computeIfAbsent(b, key -> new HashMap<>()).put(a, 1/val);
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, start, end, 1.0, visited);
        }
        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double accProduct, Set<String> visited) {
        if (!graph.containsKey(curr)) return -1.0;
        if (curr.equals(target)) return accProduct;

        visited.add(curr);
        for (Map.Entry<String, Double> neighbor : graph.get(curr).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, accProduct * neighbor.getValue(), visited);
                if (result != -1.0) return result;
            }
        }
        return -1.0;
    }
}   