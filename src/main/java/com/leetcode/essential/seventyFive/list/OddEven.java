package com.leetcode.essential.seventyFive.list;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.LINKED_LIST;

@DifficultyLevel(MEDIUM)
@ProblemCategory({LINKED_LIST})
@ProblemInfo(problemLink = "https://leetcode.com/problems/odd-even-linked-list/description/", problemNumber = "328", solutionLink = "https://algo.monster/liteproblems/328")
public class OddEven {
    /**
     * Rearranges a singly linked list so that all nodes with odd indices appear before nodes with even indices.
     *
     * @param head The head node of the linked list.
     * @return The head node of the modified linked list.
     * <p>
     * Edge Cases:
     * - If the list is empty or has only one node, no reordering is needed.
     */
    public ListNode oddEvenList(ListNode head) {
        // Edge case: If the list is empty or has only one node, no reordering is needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for odd and even indexed nodes.
        ListNode odd = head;               // Odd-indexed nodes start from the head.
        ListNode even = head.next;         // Even-indexed nodes start from the second node.
        ListNode evenHead = even;          // Keep the reference to the head of the even list.

        // Traverse the list, adjusting the odd and even pointers.
        while (even != null && even.next != null) {
            // Link odd node to the next odd node.
            odd.next = odd.next.next;
            // Link even node to the next even node.
            even.next = even.next.next;

            // Move the odd pointer to the next odd node.
            odd = odd.next;
            // Move the even pointer to the next even node.
            even = even.next;
        }

        // After the loop, connect the end of the odd list to the head of the even list.
        odd.next = evenHead;

        // Return the modified list.
        return head;
    }

}
