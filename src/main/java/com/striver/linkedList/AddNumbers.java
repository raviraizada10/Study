package com.striver.linkedList;

class LinkedListNode {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }
}


public class AddNumbers {

    static LinkedListNode addTwoNumbersStriver(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode t1 = head1;
        LinkedListNode t2 = head2;
        LinkedListNode dummyNode = new LinkedListNode(-1);
        LinkedListNode current = dummyNode;
        int carry = 0;
        while (t1 != null || t2 != null) {
            int sum = carry;
            if (t1 != null) {
                sum += t1.data;
            }
            if (t2 != null) {
                sum += t2.data;
            }
            LinkedListNode newNode = new LinkedListNode(sum % 10);
            carry = sum / 10;
            current.next = newNode;
            current = current.next;
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }

        if (carry != 0) {
            LinkedListNode newNode = new LinkedListNode(carry);
            current.next = newNode;
        }

        return dummyNode.next;

    }

    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode t1 = head1;
        LinkedListNode t2 = head2;
        LinkedListNode dummyNode = new LinkedListNode(-1);
        LinkedListNode current = dummyNode;
        int carry = 0;
        while (t1 != null || t2 != null || carry != 0) {
            int sum = carry + (t1 != null ? t1.data : 0) + (t2 != null ? t2.data : 0);
            carry = sum / 10;

            if (sum != 0 || current.next == null) {  // Create a new node only if sum is not 0 or there's no next node
                current.next = new LinkedListNode(sum % 10);
            }
            else {
                current.data = sum % 10;  // Reuse current node if sum is 0
            }

            current = current.next;
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }

        if (carry != 0) {
            LinkedListNode newNode = new LinkedListNode(carry);
            current.next = newNode;
        }

        return dummyNode.next;
    }
}
