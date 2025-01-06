package com.leetcode.essential.seventyFive.monotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures {
    /**
     * Given an array of daily temperatures, this method calculates how many days
     * one must wait until a warmer temperature. If no future day has a warmer
     * temperature, the result is 0 for that day.
     *
     * @param temperatures an array of integers representing daily temperatures
     * @return an array of integers where resultDays[i] is the number of days
     * until a warmer temperature is encountered for the i-th day. If
     * there is no warmer temperature in the future, resultDays[i] will be 0.
     */
    public int[] dailyTemperatures(int[] temperatures) {

        // A deque to store indices of the temperatures array.
        // This deque will maintain a decreasing order of temperatures.
        Deque<Integer> temperatureMonotonicStack = new LinkedList<>();

        // Array to store the result.
        int[] resultDays = new int[temperatures.length];

        // Iterate through each temperature in the array
        for (int i = 0; i < temperatures.length; i++) {

            // While the deque is not empty and the current temperature is greater
            // than the temperature at the index stored at the top of the deque
            while (!temperatureMonotonicStack.isEmpty() && temperatures[temperatureMonotonicStack.peek()] < temperatures[i]) {

                // Pop the index from the deque (this corresponds to the day we are processing)
                int prevIndex = temperatureMonotonicStack.poll();

                // Calculate the number of days between the current day (i) and the day
                // represented by prevIndex where the temperature was lower.
                resultDays[prevIndex] = i - prevIndex;
            }

            // Push the current index onto the deque.
            temperatureMonotonicStack.push(i);
        }

        // Return the result array.
        return resultDays;
    }
}

