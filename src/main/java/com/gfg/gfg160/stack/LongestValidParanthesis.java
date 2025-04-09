package com.gfg.gfg160.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParanthesis {
    static int maxLength(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        var longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                else{
                    longest = Math.max(longest, i-stack.peek());
                }
            }
        }
        return longest;
    }
}
