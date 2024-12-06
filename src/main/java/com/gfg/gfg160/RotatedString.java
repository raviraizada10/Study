package com.gfg.gfg160;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/check-if-strings-are-rotations-of-each-other-or-not-1587115620
public class RotatedString {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false; // Length check
        String concat = s1 + s1; // Concatenate s1 with itself
        return kmpSearch(s2, concat); // Use KMP to check if s2 is a substring of concat
    }

    // KMP Search Function
    private static boolean kmpSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int[] lps = computeLPSArray(pat);
        int i = 0, j = 0; // i: index for txt, j: index for pat

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                return true; // Found match
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false; // No match found
    }

    // Compute LPS Array for KMP
    private static int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

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
