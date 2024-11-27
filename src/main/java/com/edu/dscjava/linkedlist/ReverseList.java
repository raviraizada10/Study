package com.edu.dscjava.linkedlist;

public class ReverseList {
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> nextNode = null;
        LinkedListNode<Integer> prevNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        head = prevNode;
        return head;
    }
}
