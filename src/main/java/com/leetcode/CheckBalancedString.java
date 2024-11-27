package com.leetcode;

public class CheckBalancedString {
    public boolean isBalanced(String num) {
        char[] arr = num.toCharArray();
        int even = 0, odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                even += (arr[i] -48);
            }
            else {
                odd += (arr[i] -48);
            }
        }
        return even == odd;
    }

    public boolean isBalanced0(String num) {
        int even = 0, odd = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                even += (num.charAt(i) -'0');
            }
            else {
                odd += (num.charAt(i) -'0');
            }
        }
        return even == odd;
    }
}
