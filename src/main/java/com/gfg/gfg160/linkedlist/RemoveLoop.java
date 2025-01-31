package com.gfg.gfg160.linkedlist;

public class RemoveLoop {
    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head.next;
        Node fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {

                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;
            }
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
