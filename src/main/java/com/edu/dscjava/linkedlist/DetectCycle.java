package com.edu.dscjava.linkedlist;

public class DetectCycle {
    public static <Integer> boolean detectCycle_R(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head;

        while (p1 != null && p2 != null && p2.next != null) {
            p1 = p1.next; //the p1 pointer will jump 1 step
            p2 = p2.next.next; //the p2 pointer will jump 2 steps
            // when the pointers become equal then there must be a loop
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Integer[][] input = {
                {2, 4, 6, 8, 10, 12},
                {1, 3, 5, 7, 9, 11},
                {0, 1, 2, 3, 4, 6},
                {3, 4, 7, 9, 11, 17},
                {5, 1, 4, 9, 2, 3},
        };

        int[] pos = {0, -1, 1, -1, 2};
        int j = 1;

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print(j + ".\tInput: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();

            if (pos[i] == -1) {
                printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            } else {
                printLinkedList.printListWithForwardArrowCycle(inputLinkedList.head);
            }
            System.out.println("\n\tPosition: " + pos[i]);
            if (pos[i] != -1) {
                int length = inputLinkedList.getLength(inputLinkedList.head);
                LinkedListNode<Integer> lastNode = inputLinkedList.getNode(inputLinkedList.head, length - 1);
                lastNode.next = inputLinkedList.getNode(inputLinkedList.head, pos[i]);
            }
            System.out.println("\n\tDetected cycle = " + detectCycle(inputLinkedList.head));
            j++;
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }
}
