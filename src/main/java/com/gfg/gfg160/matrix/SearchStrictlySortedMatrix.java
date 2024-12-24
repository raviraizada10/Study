package com.gfg.gfg160.matrix;

public class SearchStrictlySortedMatrix {
    public boolean searchMatrix(int[][] mat, int x) {
        for (int[] row : mat) {
            if (x <= row[row.length - 1])
                if (binarySearch(row, x)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] row, int x) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == x) {
                return true;
            }
            else if (row[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
