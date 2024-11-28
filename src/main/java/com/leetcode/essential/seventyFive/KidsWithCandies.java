package com.leetcode.essential.seventyFive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }
        List<Boolean> result = new ArrayList<>(Collections.nCopies(candies.length, false));
        for (int i = 0; i < candies.length; i++) {
            int candy = candies[i];
            if (candy + extraCandies >= maxCandies) {
                result.set(i, true);
            }
        }
        return result;
    }
}
