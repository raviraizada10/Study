package com.gfg.gfg160.twopointer;

public class ContainerWithMostWater {
    public int maxWater(int arr[]) {
        var maxVolume = 0;
        for (int i = 0, j = arr.length - 1; i < j; ) {
            var volume = Math.min(arr[j], arr[i]) * (j - i);
            if (arr[i] < arr[j]) i++;
            else j--;
            maxVolume = Math.max(maxVolume, volume);
        }
        return maxVolume;
    }
}
