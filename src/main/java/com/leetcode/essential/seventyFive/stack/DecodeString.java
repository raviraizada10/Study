package com.leetcode.essential.seventyFive.stack;

import java.util.Stack;

//https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
//394
public class DecodeString {
    public String decodeString(String s) {
        // Stack to store repeat counts for nested encoded strings
        Stack<Integer> countStack = new Stack<>();
        // Stack to store previously built strings before encountering '['
        Stack<String> stringStack = new Stack<>();
        // StringBuilder to build the current decoded string
        StringBuilder currentString = new StringBuilder();
        // Variable to hold the current repeat count
        int currentCount = 0;

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the current count
                // Multiply by 10 to handle multi-digit numbers (e.g., "12[a]")
                currentCount = currentCount * 10 + (ch - '0');
            }
            else if (ch == '[') {
                // When encountering an opening bracket '[':
                // 1. Push the current repeat count onto the countStack
                countStack.push(currentCount);
                // 2. Push the current string onto the stringStack
                stringStack.push(currentString.toString());
                // 3. Reset currentCount for the next potential repeat count
                currentCount = 0;
                // 4. Reset currentString to start building the inner substring
                currentString = new StringBuilder();
            }
            else if (ch == ']') {
                // When encountering a closing bracket ']':
                // 1. Pop the last repeat count from the countStack
                int repeatCount = countStack.pop();
                // 2. Pop the last saved string from the stringStack
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                // 3. Append the current string repeated `repeatCount` times
                for (int i = 0; i < repeatCount; i++) {
                    decodedString.append(currentString);
                }
                // 4. Update currentString to include the combined result
                currentString = decodedString;
            }
            else {
                // If the character is a letter, append it to the currentString
                currentString.append(ch);
            }
        }

        // Return the fully decoded string
        return currentString.toString();
    }
}
