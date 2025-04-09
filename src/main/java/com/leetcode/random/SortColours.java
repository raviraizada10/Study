package com.leetcode.random;

import com.customannotation.DifficultyLevel;
import com.customannotation.ProblemCategory;
import com.customannotation.ProblemInfo;

import static com.customannotation.enums.Difficulty.MEDIUM;
import static com.customannotation.enums.ProblemTag.ARRAY;

@DifficultyLevel(MEDIUM)
@ProblemCategory({ARRAY})
@ProblemInfo(problemLink = "https://leetcode.com/problems/sort-colors/", problemNumber = "75", solutionLink = "https://algo.monster/liteproblems/75")
public class SortColours {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zero++;
                case 1:
                    one++;
                case 2:
                    two++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (two > 0) {
                nums[i] = 2;
                two--;
            }
            else if (one > 0) {
                nums[i] = 1;
                one--;
            }
            else if (zero > 0) {
                nums[i] = 0;
                zero--;
            }
        }
    }


    //Dutch National Flag Algo
    public void sortColorsAlternative(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high--);
                    break;
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}