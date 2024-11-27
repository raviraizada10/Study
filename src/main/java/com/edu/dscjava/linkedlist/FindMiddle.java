package com.edu.dscjava.linkedlist;

public class FindMiddle {
    public static LinkedListNode<Integer> findMiddle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
