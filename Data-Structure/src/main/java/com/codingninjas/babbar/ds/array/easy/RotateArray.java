package com.codingninjas.babbar.ds.array.easy;

import java.util.Scanner;
import java.util.function.BiFunction;

public class RotateArray {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int j, first;
            first = arr[0];
            for ( j = 0; j < arr.length-1; j++) {
                arr[j] = arr[j +1];
            }
            arr[j] = first;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    BiFunction<Integer, Integer, Integer> gcd = (a, b) -> {
        if (b == 0)
            return a;
        return this.gcd.apply(b, a % b);
    };
}
