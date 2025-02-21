package com.gfg.gfg160.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>(Comparator.comparing(node -> node.data));
        for (Node node : arr) {
            while (node != null) {
                nodeQueue.offer(node);
                node = node.next;
            }
        }
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (!nodeQueue.isEmpty()) {
            tail.next = nodeQueue.poll();
            tail = tail.next;
        }

        tail.next = null;
        return dummy.next;
    }
}

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
