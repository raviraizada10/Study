package com.leetcode;

//https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        StringBuilder result = new StringBuilder();
        int count =1;
        for (int i = 0; i < n -1; i++) {
            char [] ch = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {
                var c = ch[j];
                if (j + 1 < ch.length && c == ch[j + 1]) {
                    count++;
                }
                else {
                    result.append(count).append(c);
                    count = 1;
                }
            }
            str = result.toString();
            result.setLength(0);
        }
        return str;
    }
}
