package com.gfg.gfg160.twopointer;

public class PairWithSumSorted {
    int countPairs(int arr[], int target) {
        var leftPointer = 0;
        var rightPointer = arr.length - 1;
        int pairCount = 0;

        while (leftPointer < rightPointer) {
            var sum = arr[leftPointer] + arr[rightPointer];
            if (sum < target) {
                leftPointer++;
            }
            else if (sum > target) {
                rightPointer--;
            }
            else {
                var leftCount = 0;
                var rightCount = 0;
                var leftElement = arr[leftPointer];
                var rightElement = arr[rightPointer];

                while (leftPointer <= rightPointer && arr[leftPointer] == leftElement) {
                    leftPointer++;
                    leftCount++;
                }
                while (leftPointer <= rightPointer && arr[rightPointer] == rightElement) {
                    rightPointer--;
                    rightCount++;
                }
                if (leftElement == rightElement) {
                    pairCount += (leftCount * (leftCount - 1)) / 2;
                }
                else {
                    pairCount += (leftCount * rightCount);
                }
            }
        }
        return pairCount;
    }
}
