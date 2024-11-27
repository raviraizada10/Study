package com.edu.dscjava.linkedlist;

// Template for printing the linked list with forward arrows
class PrintList<T> {
    public void printListWithForwardArrow(LinkedListNode<T> head) {
        LinkedListNode<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }

    public void printListWithForwardArrowCycle(LinkedListNode<T> head) {
        LinkedListNode<T> slow = head;
        LinkedListNode<T> fast = head;

        // Check if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break; // Cycle detected
            }
        }

        // If no cycle
        if (fast == null || fast.next == null) {
            printListWithForwardArrow(head);
            return;
        }

        // Print cycle part
        LinkedListNode<T> cycleStart = head;
        while (cycleStart != slow) {
            cycleStart = cycleStart.next;
            slow = slow.next;
        }

        while (slow != null) {
            System.out.print(slow.data); // print node value
            slow = slow.next;
            if (slow != cycleStart) {
                System.out.print(" → ");
            } else {
                break; // Cycle completed
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → ... ");
    }
}
