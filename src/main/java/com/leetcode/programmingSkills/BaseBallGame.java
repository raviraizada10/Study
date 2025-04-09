package com.leetcode.programmingSkills;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/baseball-game/", problemNumber = "682", solutionLink = "https://algo.monster/liteproblems/682")
public class BaseBallGame {
    public int calPoints(String[] operations) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "+": {
                    int last = stack.pop();
                    int secondLast = stack.peek();
                    stack.push(last);
                    stack.push(last + secondLast);
                    break;
                }
                case "C": {
                    stack.pop();
                    break;
                }
                case "D": {
                    stack.push(stack.peek() * 2);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }
}   