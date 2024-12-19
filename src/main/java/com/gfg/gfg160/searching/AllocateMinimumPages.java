package com.gfg.gfg160.searching;

public class AllocateMinimumPages {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;

        // Edge case: If students are more than books, allocation is impossible
        if (k > n) {
            return -1;
        }

        // Step 1: Define the search space
        int low = getMax(arr);  // Minimum possible maximum pages
        int high = getSum(arr); // Maximum possible maximum pages
        int result = -1;

        // Step 2: Binary search to find the minimum of maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow

            // Check if it is feasible to allocate books with current mid
            if (isFeasible(arr, n, k, mid)) {
                result = mid;   // Store the feasible solution
                high = mid - 1; // Try for a smaller maximum
            }
            else {
                low = mid + 1;  // Increase the allowed maximum
            }
        }

        return result;
    }

    // Helper function to find the maximum element in the array
    private static int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Helper function to find the sum of all elements in the array
    private static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Function to check if allocation is feasible for a given maxPages
    private static boolean isFeasible(int[] arr, int n, int k, int maxPages) {
        int studentCount = 1; // Start with the first student
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            // If a single book exceeds maxPages, allocation is impossible
            if (arr[i] > maxPages) {
                return false;
            }

            // Add the current book to the student's allocation
            if (currentSum + arr[i] > maxPages) {
                // Assign books to the next student
                studentCount++;
                currentSum = arr[i];

                // If students exceed k, allocation is not feasible
                if (studentCount > k) {
                    return false;
                }
            }
            else {
                currentSum += arr[i];
            }
        }

        return true;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;

        System.out.println("Minimum of maximum pages: " + findPages(arr, k));
    }

}
