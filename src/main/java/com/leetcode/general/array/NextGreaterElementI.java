package com.leetcode.general.array;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/next-greater-element-i/description/", problemNumber = "496", solutionLink = "https://algo.monster/liteproblems/496")
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> greater = new Stack<>();
        for (int num : nums2) {
            while (!greater.isEmpty() && greater.peek() < num) {
                map.put(greater.pop(), num);
            }
            greater.push(num);
        }
        int length = nums1.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}   