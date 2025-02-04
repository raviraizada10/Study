package com.leetcode.essential.seventyFive.list;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.LINKED_LIST;
import static com.customannotation.enums.ProblemTag.TWO_POINTERS;

@DifficultyLevel(MEDIUM)
@ProblemCategory({LINKED_LIST, TWO_POINTERS})
@ProblemInfo(problemLink = "//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/", problemNumber = "2095", solutionLink = "https://algo.monster/liteproblems/2095")
public class DeleteMiddleNode {
    /**
     * Deletes the middle node of a singly linked list.
     * If the list has an even number of nodes, the node closer to the start is deleted.
     *
     * @param head The head node of the linked list.
     * @return The head node of the linked list after removing the middle node.
     * <p>
     * Edge Cases:
     * - If the list is empty or has only one node, return null as there's no middle node to remove.
     * - Works for lists with odd or even number of nodes.
     */
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list has only one node or is empty, return null.
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;   // Slow pointer starts at the head of the list.
        ListNode fast = head;   // Fast pointer also starts at the head of the list.
        ListNode prev = null;   // Previous pointer to keep track of the node before the slow pointer.

        // Traverse the list with fast and slow pointers to find the middle node.
        // Fast pointer moves two steps at a time, while slow pointer moves one step at a time.
        // When fast reaches the end, slow will be at the middle node.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move fast two steps forward.
            prev = slow;            // Update prev to current slow.
            slow = slow.next;       // Move slow one step forward.
        }

        // Remove the middle node by adjusting the next pointer of the previous node.
        prev.next = slow.next;

        return head;  // Return the head of the modified linked list.
    }

}
