package com.gfg.gfg160.stack;

import java.util.Stack;

public class SpecialStack {
    Stack<Integer> stack;
    int minEle;

    public SpecialStack() {
        stack = new Stack<>();
        minEle = -1;
    }


    // Add an element to the top of Stack
    public void push(int x) {
        if (stack.isEmpty()) {
            minEle = x;
            stack.push(x);
        }
        else if (x < minEle) {
            stack.push(2 * x - minEle);
            minEle = x;
        }
        else {
            stack.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top < minEle) {
            minEle = 2 * minEle - top;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        int top = stack.peek();
        return (minEle > top) ? minEle : top;
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return minEle;
    }
}
