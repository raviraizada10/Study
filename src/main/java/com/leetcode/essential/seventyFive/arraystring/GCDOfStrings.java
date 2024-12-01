package com.leetcode.essential.seventyFive.arraystring;

//https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
public class GCDOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals((str2 + str1)))
            return "";
        int length = gcd(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
