package com.edu.dscjava.array;

public class ProductArrayExceptSelf {
    public static int[] findProduct(int arr[]) {
        int n = arr.length;
        int i, left = 1;
        int[] product = new int[n];
        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            product[i] = left;
            left *= arr[i];
        }
        int right = 1;
        for (i = n - 1; i >= 0; i--) {
            product[i] *= right;
            right *= arr[i];
        }
        return product;
    }
}
