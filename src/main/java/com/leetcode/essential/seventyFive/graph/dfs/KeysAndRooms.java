package com.leetcode.essential.seventyFive.graph.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/keys-and-rooms/
//https://algo.monster/liteproblems/841
public class KeysAndRooms {
    // List of rooms, where each room contains a list of keys to other rooms
    private List<List<Integer>> rooms;

    // Set to track visited rooms
    private Set<Integer> visited;

    /**
     * Determines if all rooms can be visited starting from room 0.
     *
     * @param rooms A list of rooms where each room contains a list of keys to other rooms.
     * @return True if all rooms can be visited; otherwise, false.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms; // Assign the input list of rooms to the class variable
        visited = new HashSet<>(); // Initialize the visited set

        // Start DFS traversal from room 0
        dfs(0);

        // Check if the number of visited rooms equals the total number of rooms
        return visited.size() == rooms.size();
    }

    /**
     * Performs a depth-first search (DFS) to visit rooms.
     *
     * @param roomIndex The current room index being visited.
     */
    private void dfs(int roomIndex) {
        // If the room has already been visited, return early to avoid redundant processing
        if (visited.contains(roomIndex)) {
            return;
        }

        // Mark the current room as visited
        visited.add(roomIndex);

        // Iterate through all keys in the current room
        for (Integer roomKey : rooms.get(roomIndex)) {
            // Recursively visit the room corresponding to the key
            dfs(roomKey);
        }
    }
}

