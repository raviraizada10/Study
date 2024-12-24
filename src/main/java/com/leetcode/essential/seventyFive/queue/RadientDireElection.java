package com.leetcode.essential.seventyFive.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RadientDireElection {
    public String predictPartyVictory(String senate) {
        // Create two queues to keep track of the indices of the senators from Radiant and Dire parties.
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        // Get the length of the senate string (total number of senators)
        int n = senate.length();

        // Populate the queues with the indices of the senators belonging to each party
        for (int i = 0; i < n; i++) {
            // If the senator is from the Radiant party, add their index to the radiantQueue
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            }
            else { // If the senator is from the Dire party, add their index to the direQueue
                direQueue.offer(i);
            }
        }

        // Run the simulation where each senator will either ban another senator or declare victory
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            // Get the index of the next Radiant and Dire senator who will vote
            int radiantIndex = radiantQueue.poll();  // Remove the first Radiant senator
            int direIndex = direQueue.poll();  // Remove the first Dire senator

            // The senator with the smaller index gets to ban the other senator
            // The smaller index means the senator comes first in the queue and will vote first
            if (radiantIndex < direIndex) {
                // Radiant senator bans the Dire senator, and the Radiant senator will rejoin the queue with an updated index
                radiantQueue.offer(radiantIndex + n);  // The index is incremented by n to simulate the next round
            }
            else {
                // Dire senator bans the Radiant senator, and the Dire senator will rejoin the queue with an updated index
                direQueue.offer(direIndex + n);  // The index is incremented by n to simulate the next round
            }
        }

        // If the Radiant queue is empty, it means Dire won, otherwise Radiant wins
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
