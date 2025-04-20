package com.interviewPrep.walmart;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(
        problemLink = "https://leetcode.com/problems/group-anagrams/description/",
        problemNumber = "49",
        solutionLink = "https://algo.monster/liteproblems/49"
)
public class GroupAnagrams {

    /**
     * 📝 Group Anagrams – HashMap + Sorted Key
     * Convert each word to a character array, sort it, and use the sorted string as a canonical key in a HashMap.
     * Anagrams will share the same sorted form, so group words by this key.
     * Finally, return all grouped lists from the map.
     *
     * @param inputWords an array of lowercase strings
     * @return a list of lists, where each sublist contains strings that are anagrams
     * Edge Cases:
     * - If the input array is empty, returns an empty list.
     * - If input has only one string, returns a list with a single sublist.
     */
    public List<List<String>> groupAnagrams(String[] inputWords) {
        // Map from sorted character string (canonical form) to list of original strings
        HashMap<String, List<String>> anagramGroups = new HashMap<>();

        for (String originalWord : inputWords) {
            // Convert word to a char array and sort it to form the key
            char[] charArray = originalWord.toCharArray();
            Arrays.sort(charArray);
            String canonicalKey = new String(charArray); // This key is identical for all anagrams

            // Group anagrams using the canonical key
            anagramGroups
                    .computeIfAbsent(canonicalKey, k -> new ArrayList<>())
                    .add(originalWord);
        }

        // Return grouped anagrams as a list of lists
        return new ArrayList<>(anagramGroups.values());
    }
}