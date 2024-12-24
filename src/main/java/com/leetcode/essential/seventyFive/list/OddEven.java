package com.leetcode.essential.seventyFive.list;

//https://leetcode.com/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
//328
public class OddEven {
    public ListNode oddEvenList(ListNode head) {
        // Edge case: If the list is empty or has only one node, no reordering is needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for odd and even indexed nodes.
        ListNode odd = head;               // Odd-indexed nodes start from the head.
        ListNode even = head.next;          // Even-indexed nodes start from the second node.
        ListNode evenHead = even;           // Keep the reference to the head of the even list.

        // Traverse the list, adjusting the odd and even pointers.
        while (even != null && even.next != null) {
            odd.next = odd.next.next;       // Link odd node to the next odd node.
            even.next = even.next.next;     // Link even node to the next even node.

            odd = odd.next;                 // Move the odd pointer to the next odd node.
            even = even.next;               // Move the even pointer to the next even node.
        }

        // After the loop, connect the end of the odd list to the head of the even list.
        odd.next = evenHead;

        // Return the modified list.
        return head;
    }
}
