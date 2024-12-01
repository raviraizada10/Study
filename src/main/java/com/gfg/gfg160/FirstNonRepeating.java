package com.gfg.gfg160;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/string-gfg-160/problem/non-repeating-character-1587115620
public class FirstNonRepeating {
    static char nonRepeatingChar(String s) {
        char[] ascii = new char[26];
        for (int i = 0; i < s.length(); i++) {
            ascii[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(ascii[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return '$';
    }
}
