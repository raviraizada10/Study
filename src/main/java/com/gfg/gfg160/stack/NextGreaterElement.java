package com.gfg.gfg160.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(-1);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            if (!stack.isEmpty()) result.set(i, stack.peek());
            stack.push(arr[i]);
        }
        return result;
    }
}
