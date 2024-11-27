package com.gfg.gfg160;

public class MaxProductSubarray {

    int maxProduct(int[] arr) {
        var currentProd = 1;
        var maxProd = 1;
        for (int j : arr) {
            if (currentProd < 0) currentProd = j;
            else currentProd *= j;
            if (maxProd < currentProd) maxProd = currentProd;
        }
        return maxProd;
    }
}
