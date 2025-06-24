package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.PriorityQueue;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/reorganize-string/description/", problemNumber = "767", solutionLink = "https://algo.monster/liteproblems/767")
public class ReorganiseString {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) maxHeap.offer(new int[]{i, freq[i]});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = {-1, 0};  // [charIndex, count]

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) (curr[0] + 'a'));
            curr[1]--;

            if (prev[1] > 0) maxHeap.offer(prev);  // reinsert previous if more left

            prev = curr;  // update prev
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}   