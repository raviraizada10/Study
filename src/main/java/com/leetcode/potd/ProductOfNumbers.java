package com.leetcode.potd;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/product-of-the-last-k-numbers/", problemNumber = "1352", solutionLink = "https://algo.monster/liteproblems/1352")
public class ProductOfNumbers {
    private static List<Integer> stream;

    public ProductOfNumbers() {
        stream = new ArrayList<>();
    }

    public void add(int num) {
        stream.add(num);
    }

    public int getProduct(int k) {
        AtomicInteger result = new AtomicInteger(1);
        stream
                .listIterator(stream.size() - k)
                .forEachRemaining(num -> result.updateAndGet(current -> current * num));
        return result.intValue();
    }

}   