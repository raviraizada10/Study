package com.leetcode.essential.seventyFive.arraystring;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.EASY;
import static com.customannotation.enums.ProblemTag.ARRAY;
import static com.customannotation.enums.ProblemTag.GREEDY;

@DifficultyLevel(EASY)
@ProblemCategory({ARRAY, GREEDY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/can-place-flowers/", problemNumber = "605", solutionLink = "https://algo.monster/liteproblems/605")
public class CanPlaceFlowers {
    /**
     * Checks if a given number of flowers can be placed in a flowerbed without adjacent flowers touching.
     * Each position in the flowerbed array represents whether a spot is empty (0) or occupied (1).
     * <p>
     * The strategy is to iterate through the flowerbed and attempt to place a flower whenever we find
     * a suitable spot where the current position and its adjacent positions are all empty (0).
     *
     * @param flowerbed An array representing the flowerbed where 0 indicates an empty spot and 1 indicates an occupied spot.
     * @param n         The number of flowers to place.
     * @return True if it's possible to place all n flowers in the flowerbed without adjacent flowers touching; false otherwise.
     * <p>
     * Edge Cases:
     * - If n is 0, it's always possible to place 0 flowers, so the method returns true.
     * - Works correctly for flowerbeds of size 1 or larger.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0; // Counter for the number of flowers placed

        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current spot is empty and its adjacent spots are also empty or out of bounds
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1; // Place a flower at the current spot
                count++; // Increment the count of placed flowers
                i++; // Skip the next spot since it's adjacent and cannot place a flower there
            }

            // If we've placed enough flowers, return true
            if (count >= n) {
                return true;
            }
        }

        // If we couldn't place enough flowers, return false
        return false;
    }

}
