package com.leetcode.potd;

import java.util.HashMap;
import java.util.Map;

public class MinLengthStringPostOp {
    public int minimumLength(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        var removeChars = 0;
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : freqMap.entrySet()) {
            var freq = characterIntegerEntry.getValue();
            if (freq % 2 == 0) removeChars += freq - 2;
            else removeChars += freq - 1;
        }
        return s.length() - removeChars;
    }

}
