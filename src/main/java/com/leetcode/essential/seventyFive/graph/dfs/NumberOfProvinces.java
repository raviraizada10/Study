package com.leetcode.essential.seventyFive.graph.dfs;

//https://leetcode.com/problems/number-of-provinces/
//https://algo.monster/liteproblems/547
public class NumberOfProvinces {
    // Adjacency matrix representation of the graph
    private int[][] connectedGraph;
    // Array to track visited cities during DFS
    private boolean[] visited;

    /**
     * Finds the number of provinces in the given adjacency matrix.
     *
     * @param isConnected An n x n matrix where isConnected[i][j] = 1 indicates
     *                    a direct connection between cities i and j.
     * @return The total number of provinces (connected components) in the graph.
     */
    public int findCircleNum(int[][] isConnected) {
        this.connectedGraph = isConnected; // Store the input graph
        var numCities = connectedGraph.length; // Total number of cities
        visited = new boolean[numCities]; // Initialize the visited array
        var numOfProvinces = 0; // Initialize province count

        // Iterate over each city
        for (int i = 0; i < numCities; i++) {
            if (!visited[i]) { // If the city hasn't been visited
                dfs(i); // Explore all connected cities using DFS
                numOfProvinces++; // Increment province count
            }
        }
        return numOfProvinces; // Return the total number of provinces
    }

    /**
     * Depth First Search (DFS) to explore all cities connected to the given city.
     *
     * @param cityIndex The index of the city currently being explored.
     */
    private void dfs(int cityIndex) {
        visited[cityIndex] = true; // Mark the current city as visited

        // Iterate over all possible destination cities
        for (int destination = 0; destination < connectedGraph.length; destination++) {
            // If the destination city is connected and hasn't been visited
            if (!visited[destination] && connectedGraph[cityIndex][destination] == 1) {
                dfs(destination); // Recursively visit the connected city
            }
        }
    }
}
