package com.edu.dscjava.linkedlist;

public class DeleteByValue {
    public boolean deleteByValue_R(LinkedListNode<Integer> head, int value) {
        var currNode = head;
        if (head == null) {
            return false;
        }
        while (currNode.next != null) {
            if (currNode.next.data == value) {
                currNode.next = currNode.next.next;
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public static boolean deleteByValue(LinkedListNode <Integer> head, int value) {
        boolean deleted = false;

        LinkedListNode <Integer> current = head;
        LinkedListNode <Integer> previous = null;
        // Check if the value to delete is in the head node
        if (current.data == value) {
            head = head.next;
            deleted = true;
            return deleted;
        }

        // Traverse the linked list to find the node with the given value
        while (current != null) {
            if (value == current.data) { // If the value is found
                previous.next = current.next;
                current.next = null;
                deleted = true;
                break;
            }
            previous = current;
            current = current.next;
        }
        return deleted;
    }

    public static void main(String[] args) {

        Integer[][] input = {
                {10, 20, 30, 40, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, 1},
                {12},
                {1, 2},
        };

        int[] values = {30, -8, 3, 12, 1};

        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<Integer>();
            inputLinkedList.createLinkedList(input[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<Integer>();
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("\n\tValue to be deleted: "+ values[i]);
            System.out.println("\n\tResult: "+ deleteByValue(inputLinkedList.head, values[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
