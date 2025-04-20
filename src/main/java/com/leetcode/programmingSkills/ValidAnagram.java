package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/valid-anagram/", problemNumber = "242", solutionLink = "https://algo.monster/liteproblems/242")
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] chars = new int[26];
        for (char ch : s.toCharArray()) {
            chars[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            chars[ch - 'a']--;
            if (chars[ch - 'a'] < 0) return false;
        }
        return true;
    }
}

