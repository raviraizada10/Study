package com.gfg.gfg160.linkedlist;

public class FirstNodeOfLoop {
    public static Node findFirstNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return new Node(-1);
    }
}
