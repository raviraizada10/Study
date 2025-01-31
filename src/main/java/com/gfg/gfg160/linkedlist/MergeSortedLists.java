package com.gfg.gfg160.linkedlist;

public class MergeSortedLists {
    Node sortedMerge(Node head1, Node head2) {
        Node dummyNode = new Node(-1);
        Node currentNode = dummyNode;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                currentNode.next = head1;
                head1 = head1.next;
            }
            else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;

            if (head1 != null) {
                currentNode.next = head1;
            }
            else {
                currentNode.next = head2;
            }
        }

        return dummyNode.next;
    }
}
