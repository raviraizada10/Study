package com.edu.dscjava.linkedlist;

public class LinkedListNode<T> {
    T data;
    com.edu.dscjava.linkedlist.LinkedListNode<T> next;

    LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}
