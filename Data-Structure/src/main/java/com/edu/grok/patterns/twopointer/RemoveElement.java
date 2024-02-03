package com.edu.grok.patterns.twopointer;

/*
 * Given an unsorted array of numbers and a target ‘key’,
 * remove all instances of ‘key’ in-place and return the new length of the array.
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 * */
public class RemoveElement {
    public static int remove(int[] arr, int key) {
        int nextDuplicateKey = 0;
        for (int i = 0; i < arr.length; i++) {
            if(key != arr[i]){
                arr[nextDuplicateKey] = arr[i];
                nextDuplicateKey++;
            }
        }
        return  nextDuplicateKey;
    }
}
