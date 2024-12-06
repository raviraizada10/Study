package com.leetcode;

//https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
public class PrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        var sentenceArray = sentence.split(" ");
        for (int i = 0; i < sentenceArray.length; i++) {
            String sen = sentenceArray[i];
            if (sen.startsWith(searchWord))
                return i;
        }
        return -1;
    }
}
