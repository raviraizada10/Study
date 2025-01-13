package com.leetcode.potd;

//https://leetcode.com/problems/construct-k-palindrome-strings/description/
//https://algo.monster/liteproblems/1400
public class ConstructKPalindromes {
    private static int MAX_CHARS = 26;

    public boolean canConstruct(String s, int k) {
        int[] freqArray = new int[MAX_CHARS];
        var oddCount = 0;
        if (s.length() < k) return false;

        for (char ch : s.toCharArray()) {
            freqArray[ch - 'a']++;
        }

        for (int frequency : freqArray) {
            if (frequency % 2 != 0) oddCount++;
        }
        return oddCount<=k;

    }
}
