package com.leetcode.essential.seventyFive.stack;

import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
//735
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack to keep track of asteroids that are still in motion
        Stack<Integer> stack = new Stack<>();

        // Iterate through each asteroid in the input array
        for (int asteroid : asteroids) {
            boolean exploded = false; // Flag to check if the current asteroid gets destroyed

            // Check for collisions only when the current asteroid is moving left (< 0)
            // and there is an asteroid in the stack moving right (> 0)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek(); // Peek the top asteroid in the stack

                if (Math.abs(asteroid) > top) {
                    // Current asteroid is larger, so the top asteroid explodes
                    stack.pop(); // Remove the top asteroid from the stack
                }
                else if (Math.abs(asteroid) == top) {
                    // Both asteroids have the same size, so both explode
                    stack.pop(); // Remove the top asteroid from the stack
                    exploded = true; // Mark the current asteroid as destroyed
                    break; // Stop further checks for this asteroid
                }
                else {
                    // Current asteroid is smaller, so it explodes
                    exploded = true; // Mark the current asteroid as destroyed
                    break; // Stop further checks for this asteroid
                }
            }

            // If the current asteroid didn't explode, push it onto the stack
            if (!exploded) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to an array for the final result
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop(); // Pop elements from the stack in reverse order
        }

        return result; // Return the array of surviving asteroids
    }
}
