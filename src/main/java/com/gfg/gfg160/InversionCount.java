package com.gfg.gfg160;

//https://www.geeksforgeeks.org/batch/gfg-160-problems/track/sorting-gfg-160/problem/inversion-of-array-1587115620
//https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
public class InversionCount {

    // Main method to find the inversion count in the array
    public static int inversionCount(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    // Recursive function to implement Merge Sort and count inversions
    private static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            // Find the midpoint of the array
            int mid = left + (right - left) / 2;

            // Recursively count inversions in the left half
            count += mergeSortAndCount(arr, left, mid);

            // Recursively count inversions in the right half
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions while merging the two halves
            count += mergeAndCount(arr, left, mid, right);
        }

        return count; // Return total inversion count
    }

    // Function to merge two sorted halves and count inversions
    private static int mergeAndCount(int[] arr, int left, int mid, int right) {
        // Create temporary arrays for the left and right halves
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        // Copy data into the temporary arrays
        System.arraycopy(arr, left, leftArr, 0, mid - left + 1);
        System.arraycopy(arr, mid + 1, rightArr, 0, right - mid);

        int i = 0, j = 0, k = left, inversions = 0;

        // Merge the arrays and count inversions
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                // No inversion if leftArr[i] <= rightArr[j]
                arr[k++] = leftArr[i++];
            }
            else {
                // Inversion found: all remaining elements in leftArr form inversions with rightArr[j]
                arr[k++] = rightArr[j++];
                inversions += leftArr.length - i; // Count inversions
            }
        }

        // Copy remaining elements from the left array, if any
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements from the right array, if any
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }

        return inversions; // Return the count of inversions during this merge
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println("Inversion Count: " + inversionCount(arr)); // Output: 3
    }
}
