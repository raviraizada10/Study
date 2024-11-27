package com.edu.dscjava.linkedlist;

// Template for the linked list

// Template for the linked list
class LinkedList<T> {
    public LinkedListNode<T> head;

    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }

    // The insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode<T> node) {
        if (this.head == null) {
            this.head = node;
        }
        else {
            node.next = this.head;
            this.head = node;
        }
    }

    // The createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(T[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode<T> newNode = new LinkedListNode<T>(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

    // Method to get the length of the linked list
    public int getLength(LinkedListNode<T> head) {
        int length = 0;
        LinkedListNode<T> temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Method to get the node at the specified position(index) of the linked list
    public LinkedListNode<T> getNode(LinkedListNode<T> head, int pos) {
        if (pos != -1) {
            int p = 0;
            LinkedListNode<T> ptr = head;
            while (p < pos) {
                ptr = ptr.next;
                p++;
            }
            return ptr;
        }
        return null;
    }

    // Method to display the elements of the linked list
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinkedListNode temp = this.head;
        while (temp != null) {
            result.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                result.append(", ");
            }
        }
        return result.toString();
    }

}
