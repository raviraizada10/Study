package com.leetcode.essential.seventyFive.arraystring;

//https://leetcode.com/problems/can-place-flowers/
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 &&
                    (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;
                count++;
                i++;
            }
            if (count >= n) return true;
        }
        return false;
    }
}
