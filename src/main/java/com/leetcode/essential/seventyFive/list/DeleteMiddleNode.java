package com.leetcode.essential.seventyFive.list;

//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
//2095
public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list has only one node, return null as there's no middle node to remove.
        if (head == null || head.next == null) {
            return null;  // If there is only one node, we can't delete the middle node, so we return null.
        }

        // Initialize slow and fast pointers
        ListNode slow = head;  // Slow pointer starts at the head of the list.
        ListNode fast = head;  // Fast pointer also starts at the head of the list.
        ListNode prev = null;  // Previous pointer to keep track of the node before the slow pointer.

        // Traverse the list with fast and slow pointers
        // The fast pointer moves two steps at a time, and the slow pointer moves one step at a time.
        // The goal is to find the middle node where the slow pointer will be when the fast pointer reaches the end.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move the fast pointer two steps forward.
            prev = slow;            // Update the prev pointer to be the current slow pointer.
            slow = slow.next;       // Move the slow pointer one step forward.
        }

        // Now, slow is pointing to the middle node, and prev is pointing to the node just before slow.
        // To remove the middle node, we change the next pointer of the prev node to skip the slow node.
        prev.next = slow.next;  // Skip the middle node by linking the previous node to the node after slow.

        return head;  // Return the modified linked list, starting from the head.
    }
}
