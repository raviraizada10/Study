package com.leetcode.essential.oneFifty.hashmap;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.HashSet;
import java.util.Set;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/happy-number/", problemNumber = "202", solutionLink = "https://algo.monster/liteproblems/202")
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            int sum =0;
            while(n!=0){
                int digit = n % 10;
                sum += digit * digit;
                n = n/10;
            }
            n = sum;

        }
        return n==1;
    }
}   