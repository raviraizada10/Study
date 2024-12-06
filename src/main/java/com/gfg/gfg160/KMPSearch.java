package com.gfg.gfg160;

import java.util.ArrayList;
import java.util.List;

public class KMPSearch {

    public static List<Integer> findPatternOccurrences(String pat, String txt) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        // Step 1: Precompute the LPS (Longest Prefix Suffix) array
        int[] lps = computeLPSArray(pat);

        // Step 2: Search the pattern in the text
        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found at index (i - j)
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    // Helper method to compute the LPS array
    private static int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS of the first character is always 0

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
