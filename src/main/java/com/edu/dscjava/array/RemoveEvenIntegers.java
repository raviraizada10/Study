package com.edu.dscjava.array;

import java.util.Arrays;

public class RemoveEvenIntegers {

    public static int[] removeEvenWithCopy(int[] arr) {
        int[] result = new int[arr.length];
        int index = 0;
        for (int j : arr) {
            if (Math.abs(j) % 2 != 0) {
                result[index] = j;
                index++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static int[] removeEven(int[] arr) {
        int size = 0;
        for (int j : arr) {
            if (Math.abs(j) % 2 != 0) {
                size++;
            }
        }
        int[] result = new int[size];
        int index = 0;
        for (int j : arr) {
            if (Math.abs(j) % 2 != 0) {
                result[index] = j;
                index++;
            }
        }
        return result;
    }
}
