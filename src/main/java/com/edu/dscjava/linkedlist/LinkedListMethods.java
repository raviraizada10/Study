package com.edu.dscjava.linkedlist;

public class LinkedListMethods {
    public static LinkedListNode<Integer> insertAtTail(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> currNode = head;
        LinkedListNode<Integer> node = new LinkedListNode<>(value);
        if (currNode == null) {
            head = node;
            return head;
        }
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = node;
        node.next = null;
        return head;
    }

    public static boolean searchNode(LinkedListNode<Integer> head, int value) {
        LinkedListNode<Integer> currNode = head;
        if (head == null) {
            return false;
        }
        while (currNode != null) {
            if (currNode.data == value) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public static boolean searchNodeRecursive(LinkedListNode<Integer> head, int value) {
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            return true;
        }
        return searchNodeRecursive(head.next, value);
    }

    public boolean deleteByValue(LinkedListNode <Integer> head, int value) {

        // Replace this placeholder return statement with your code
        return false;
    }


    public static void main(String[] args) {
        Integer[][] inputs = {
                {10, 20, 30, 40, 50},
                {-1, -2, -3, -4, -5, -6},
                {3, 2, 1},
                {},
                {12}
        };
        int[] value = {50, -7, 3, 55, 12};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList<Integer> inputLinkedList = new LinkedList<>();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList<Integer> printLinkedList = new PrintList<>();
            printLinkedList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println("\n\tLength of linked list: " + searchNode(inputLinkedList.head, value[i]));
            System.out.println(new String(new char[75]).replace('\0', '-'));
        }
    }

}


