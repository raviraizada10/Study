package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/lru-cache/", problemNumber = "146", solutionLink = "https://algo.monster/liteproblems/146")
public class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    /**
     * 📝 LRU Cache (LinkedHashMap) – Built-in Access Order
     * Extend LinkedHashMap with accessOrder = true to automatically reorder entries by recent access.
     * Override removeEldestEntry to remove the least recently used item when size exceeds capacity.
     * Use get() and put() directly — access triggers reordering, so the least used moves to the end.
     * This provides a clean O(1) solution using built-in Java data structures.
     */

    private int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}   