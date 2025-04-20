package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;
import java.util.Map;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

/**
 * Implementation of an LRU (Least Recently Used) Cache using a combination of
 * HashMap for O(1) lookups and a Doubly Linked List for O(1) insertions/removals.
 * This structure allows us to efficiently track usage order and evict the least recently used item.
 * <p>
 * 📝 LRU Cache – HashMap + Doubly Linked List
 * Use a HashMap for O(1) access to cache entries, and a Doubly Linked List to track usage order.
 * Move accessed/updated nodes to the front (most recently used).
 * When capacity is exceeded, remove the node at the tail (least recently used).
 * Combines fast lookup with efficient insert/remove to maintain LRU behavior.
 */
@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/lru-cache/", problemNumber = "146", solutionLink = "https://algo.monster/liteproblems/146")
public class LRUCache {
    private int capacity;

    // Maps keys to nodes in the doubly linked list for O(1) access
    private Map<Integer, Node> cacheMap;

    // Dummy head and tail nodes to simplify add/remove operations
    private Node head, tail;

    /**
     * Constructs an LRUCache with the specified capacity.
     *
     * @param capacity the maximum number of items the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        this.head = new Node(-1, -1); // Dummy head
        this.tail = new Node(-1, -1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;
        Node node = cacheMap.get(key);
        remove(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) remove(cacheMap.get(key));
        Node node = new Node(key, value);
        insertAfterHead(node);
        cacheMap.put(key, node);
        // Handling of capacity eviction
        if (cacheMap.size() > capacity) {
            Node lru = tail.prev; // The least recently used node
            remove(lru);
            cacheMap.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAfterHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}