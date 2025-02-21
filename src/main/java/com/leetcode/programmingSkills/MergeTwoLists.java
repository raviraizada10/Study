package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.LINKED_LIST;
import static com.customannotation.enums.ProblemTag.RECURSION;

@DifficultyLevel(EASY)
@ProblemCategory({LINKED_LIST, RECURSION})
@ProblemInfo(problemLink = "https://leetcode.com/problems/merge-two-sorted-lists/", problemNumber = "21", solutionLink = "https://algo.monster/liteproblems/21")
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 == null) current.next = list2;
        else current.next = list1;
        return dummyNode.next;
    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoListsRecursion(list1, list2.next);
            return list2;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
