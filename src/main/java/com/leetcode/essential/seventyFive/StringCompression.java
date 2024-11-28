package com.leetcode.essential.seventyFive;

public class StringCompression {
    public int compress(char[] chars) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        if (chars.length == 1) {
            return 1;
        }
        for (int j = 0; j < chars.length; j++) {
            var c = chars[j];
            if (j + 1 < chars.length && c == chars[j + 1]) {
                count++;
            }
            else {
                result.append(c).append(count);
                count = 1;
            }
        }
    System.out.println(result.toString());
        chars = result.toString().toCharArray();
        return chars.length;
    }
}
