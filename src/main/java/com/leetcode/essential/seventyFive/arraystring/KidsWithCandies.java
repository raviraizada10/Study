package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/", problemNumber = "1431", solutionLink = "https://algo.monster/liteproblems/1431")
public class KidsWithCandies {
    /**
     * Determines which kids can have the maximum number of candies after adding extra candies.
     * A kid can have the maximum number of candies if the sum of their candies and extra candies is at least the maximum number of candies among all kids.
     *
     * @param candies      An array representing the number of candies each kid has.
     * @param extraCandies The number of extra candies that can be added to any kid's total.
     * @return A list where each element is true if the corresponding kid can have the maximum number of candies after adding extra candies; false otherwise.
     * <p>
     * Edge Cases:
     * - Works correctly when there are no kids or when all kids have the same number of candies.
     * - Handles negative extra candies appropriately.
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Find the maximum number of candies among all kids.
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // Initialize a result list with false values, indicating initially no kid can have the maximum candies.
        List<Boolean> result = new ArrayList<>(Collections.nCopies(candies.length, false));

        // Iterate through each kid's candies and check if they can have the maximum candies after adding extra candies.
        for (int i = 0; i < candies.length; i++) {
            int candy = candies[i];
            if (candy + extraCandies >= maxCandies) {
                result.set(i, true); // Mark the corresponding kid as true if they can have maximum candies.
            }
        }

        return result;
    }
}
