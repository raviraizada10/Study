package com.leetcode.essential.seventyFive.list;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({LINKED_LIST, TWO_POINTERS, STACK})
@ProblemInfo(problemLink = "https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/", problemNumber = "2130", solutionLink = "https://algo.monster/liteproblems/")
public class MaximumTwinSum {
    public int pairSum(ListNode head) {
        // Step 1: Find the middle of the linked list using slow and fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Slow pointer moves one step
            fast = fast.next.next; // Fast pointer moves two steps
        }
        // At this point, `slow` points to the middle of the list

        // Step 2: Reverse the second half of the list starting from `slow`
        ListNode prev = null, current = slow;
        while (current != null) {
            ListNode nextNode = current.next; // Temporarily store the next node
            current.next = prev;             // Reverse the current node's pointer
            prev = current;                  // Move `prev` one step forward
            current = nextNode;              // Move `current` one step forward
        }
        // `prev` now points to the head of the reversed second half of the list

        // Step 3: Calculate the maximum twin sum
        int maxTwinSum = 0;
        ListNode first = head; // Pointer for the first half of the list
        ListNode second = prev; // Pointer for the reversed second half
        while (second != null) {
            int twinSum = first.val + second.val; // Calculate the twin sum
            maxTwinSum = Math.max(maxTwinSum, twinSum); // Update the maximum twin sum
            first = first.next; // Move the first pointer to the next node
            second = second.next; // Move the second pointer to the next node
        }

        // Step 4: Return the maximum twin sum
        return maxTwinSum;
    }
}
