package com.edu.grok.patterns.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

    }

//    s -> {1,2,3,4}
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        for (int i : s) {
            if (count < g.length && g[count] <= i) count++;
        }
        return count;
    }


    String reverseWords(String S)
    {
        String[] arr = S.split("\\.");
        StringBuilder s = new StringBuilder();
        for (int i = arr.length - 1; i > 0 ; i--) {
            s.append(arr[i]);
        }
        return s.subSequence(0, s.length() -1).toString();
    }
}
