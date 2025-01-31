package com.gfg.gfg160.linkedlist;

public class ReverseKGroup {
    /**
     * Reverses the nodes of a linked list in groups of size k.
     *
     * <p>If the number of nodes is not a multiple of k, the remaining nodes
     * at the end of the list are not reversed. This method handles edge cases such as
     * null input or k being 0 or 1.</p>
     *
     * @param head the head of the linked list to reverse
     * @param k    the size of the groups to reverse
     * @return the head of the modified linked list
     */
    public static Node reverseKGroup(Node head, int k) {
        // Handle edge cases where no reversal is needed.
        if (head == null || k <= 1) {
            return head;
        }

        // Initialize variables to keep track of the current node, new head of the list,
        // and the tail of the previous reversed group.
        Node current = head;
        Node newHead = null; // Will store the new head of the reversed list.
        Node previousGroupTail = null; // Tracks the tail of the last reversed group.

        // Process the linked list in groups of size k.
        while (current != null) {
            Node groupHead = current; // Start of the current group.
            Node previous = null; // Will store the previous node during reversal.
            Node nextNode = null; // Temporarily stores the next node.
            int count = 0; // Counter to ensure we reverse exactly k nodes.

            // Reverse k nodes or until the end of the list.
            while (current != null && count < k) {
                nextNode = current.next; // Save the next node.
                current.next = previous; // Reverse the current node.
                previous = current; // Move the previous pointer forward.
                current = nextNode; // Move the current pointer forward.
                count++;
            }

            // Update the new head of the list if this is the first group.
            if (newHead == null) {
                newHead = previous; // The last node reversed in the first group becomes the new head.
            }

            // Connect the previous group's tail to the current group's head (after reversal).
            if (previousGroupTail != null) {
                previousGroupTail.next = previous;
            }

            // Update the tail of the current group (original head before reversal).
            previousGroupTail = groupHead;
        }

        return newHead;
    }

}
