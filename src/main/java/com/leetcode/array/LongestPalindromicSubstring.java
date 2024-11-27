//package com.leetcode.array;
//
//public class LongestPalindromicSubstring {
//    public String longestPalindrome(String s) {
//         if (s == null || s.length() <= 1) return s;
//
//        int start = 0, end = 0;
//        String maxStr = s.substring(0, 1);
//
//        for (int i = 0; i < s.length() - 1; i++) {
//            String evenStr = expandAroundCenter(s, i, i);
//            String oddStr = expandAroundCenter(s, i, i + 1);
//
//            if (evenStr.length() > maxStr.length()) {
//                maxStr = evenStr;
//                start = i - (maxStr.length() - 1) / 2;
//                end = i + maxStr.length() / 2;
//            }
//
//            if (oddStr.length() > maxStr.length()) {
//                maxStr = oddStr;
//                start = i - (maxStr.length() - 1) / 2;
//                end = i + maxStr.length() / 2;
//            }
//        }
//    }
//}
