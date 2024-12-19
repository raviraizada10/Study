package com.gfg.gfg160.searching;

public class KthElementSortedArrays {
    public int kthElement(int a[], int b[], int k) {
        if (a.length > b.length) {
            return findKthElement(b, a, k); // Ensure a is the smaller array
        }

        int m = a.length, n = b.length;
        int low = Math.max(0, k - n), high = Math.min(k, m);

        while (low <= high) {
            int i = low + (high - low) / 2; // Partition index in a[]
            int j = k - i; // Partition index in b[]

            int aLeft = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int aRight = (i == m) ? Integer.MAX_VALUE : a[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int bRight = (j == n) ? Integer.MAX_VALUE : b[j];

            if (aLeft <= bRight && bLeft <= aRight) {
                return Math.max(aLeft, bLeft); // Valid partition
            }
            else if (aLeft > bRight) {
                high = i - 1;
            }
            else {
                low = i + 1;
            }
        }
        return 0;
    }
}
