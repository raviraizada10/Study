package com.gfg.gfg160.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class ParanthesisChecker {
    static boolean isBalanced(String s) {
        Deque<Character> bracketStack = new ArrayDeque<>();
        int length = s.length();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                bracketStack.push(ch);
            }
            else {
                if (bracketStack.isEmpty()) return false;
                Character bracket = bracketStack.pop();
                if (ch == '}' && !Objects.equals(bracket, '{') ||
                        ch == ']' && !Objects.equals(bracket, '[') ||
                        ch == ')' && !Objects.equals(bracket, '(')) {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }
}