package com.leetcode.essential.seventyFive.list;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.LINKED_LIST;
import static com.customannotation.enums.ProblemTag.RECURSION;

@DifficultyLevel(EASY)
@ProblemCategory({LINKED_LIST, RECURSION})
@ProblemInfo(problemLink = "https://leetcode.com/problems/reverse-linked-list/description/", problemNumber = "206", solutionLink = "https://algo.monster/liteproblems/206")
public class ReverseList {
    /**
     * Reverses a singly linked list and returns the new head of the reversed list.
     *
     * @param head The head of the original linked list.
     * @return The head of the reversed linked list.
     * <p>
     * Edge Cases:
     * - If the list is empty (head is null), return null immediately.
     */
    public ListNode reverseList(ListNode head) {
        // Edge case: If the list is empty, return null immediately.
        if (head == null) {
            return null;
        }

        // Initialize a pointer to the previous node, starting with null.
        ListNode prevNode = null;

        // Initialize a pointer to the current node, starting with the head of the list.
        ListNode currentNode = head;

        // Traverse the linked list until the current node becomes null.
        while (currentNode != null) {
            // Step 1: Save the next node to maintain access to the rest of the list.
            ListNode nextNode = currentNode.next;

            // Step 2: Reverse the link by pointing the current node's 'next' to the previous node.
            currentNode.next = prevNode;

            // Step 3: Move the prevNode pointer to the current node.
            prevNode = currentNode;

            // Step 4: Move the currentNode pointer to the next node.
            currentNode = nextNode;
        }

        // At the end of the loop, prevNode will be pointing to the new head of the reversed list.
        return prevNode;
    }

}
