package com.gfg.gfg160;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

        // First pass: Find potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        // Second pass: Verify the actual counts of the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        // Collect the result
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Sort the result in increasing order
        result.sort(Integer::compareTo);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println(findMajority(arr));  // Output: [5, 6]
    }
}
