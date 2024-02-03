package com.edu.grok.patterns.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        String[] arr = s.split("");
        for (int i = 0, j = arr.length - 1; i < j; ) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }


    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }

    public static String[] findWordsStream(String[] words) {

        Set<Character> first = "qwertyuiop"
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        Set<Character> second = "asdfghjkl"
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());
        Set<Character> third = "zxcvbnm"
                .chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toSet());

        Predicate<String> isPresentInSets = word -> {
            Set<Character> wordSet = word.toLowerCase().chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
            return first.containsAll(wordSet) || second.containsAll(wordSet) || third.containsAll(wordSet);
        };

        return Arrays
                .stream(words)
                .filter(isPresentInSets)
                .toArray(String[]::new);
    }

    public static String[] findWords(String[] words) {
        Set<Character> first = new HashSet<>();
        char[] firstArr = "qwertyuiop".toCharArray();
        for (char c : firstArr) {
            first.add(c);
        }

        Set<Character> second =new HashSet<>();
        char[] secondArr = "asdfghjkl".toCharArray();
        for (char c : secondArr) {
            second.add(c);
        }
        Set<Character> third =new HashSet<>();
        char[] thirdArr = "zxcvbnm".toCharArray();
        for (char c : thirdArr) {
            third.add(c);
        }

        String[] result = new String[words.length];
        int i =0;
        for (String word : words) {
            Set<Character> wordSet = word.toLowerCase().chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
            if(first.containsAll(wordSet) || second.containsAll(wordSet) || third.containsAll(wordSet)){
                result[i] = word;
                i++;
            }

        }
        return Arrays.copyOfRange(result, 0, i-1);
    }

    public static void main(String[] args) {
        String[] words =  new String[]{"Hello","Alaska","Dad","Peace"};
        String[] res = findWords(words);
        System.out.println(res);
    }
}
