package com.leetcode.essential.seventyFive.arraystring;

//https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
public class ReverseVowelsOfString {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        var ch = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            var isFirstVowel = vowels.indexOf(ch[i]) != -1;
            var isLastVowel = vowels.indexOf(ch[j]) != -1;
            if (isFirstVowel && isLastVowel) {
                swap(ch, i, j);
                i++;
                j--;
            }
            else if (!isFirstVowel) {
                i++;
            }
            else {
                j--;
            }
        }
        return new String(ch);
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
