package com.edu.dscjava.linkedlist;

public class FindLength {
    public static int length(LinkedListNode <Integer> head) {
        var length = 0;
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }
}
