package com.leetcode.essential.oneFifty.hashmap;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.*;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY, HASH_TABLE, STRING, SORTING})
@ProblemInfo(problemLink = "https://leetcode.com/problems/group-anagrams/description/", problemNumber = "49", solutionLink = "https://algo.monster/liteproblems/49")
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String sortedKey = sortCharacters(str);
            groups
                    .computeIfAbsent(sortedKey, k -> new ArrayList<>())
                    .add(str);
        }
        return groups
                .values()
                .stream()
                .toList();
    }


    public static String sortCharacters(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}   