package com.leetcode.essential.oneFifty.hashmap;

import java.util.HashMap;

//https://leetcode.com/problems/ransom-note/?envType=study-plan-v2&envId=top-interview-150
//https://algo.monster/liteproblems/383
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            freqMap.merge(ch, -1, Integer::sum);
            if (freqMap.get(ch) < 0) return false;
        }
        return true;
    }
}
