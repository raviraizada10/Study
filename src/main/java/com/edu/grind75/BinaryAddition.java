package com.edu.grind75;

public class BinaryAddition {

    public static String addBinary(String str1, String str2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int ptr1 = str1.length() - 1;
        int ptr2 = str2.length() - 1;
        while (ptr1 >= 0 || ptr2 >= 0) {
            int second = (ptr1 >= 0) ? Character.getNumericValue(str1.charAt(ptr1)) : 0;
            int first = (ptr2 >= 0) ? Character.getNumericValue(str1.charAt(ptr2)) : 0;
            int totalSum = first + second + carry;
            int currentDigit = totalSum % 2;
            carry = totalSum / 2;
            sum.append(currentDigit);

            ptr1--;
            ptr2--;
        }
        if (carry != 0) {
            sum.append(carry);
        }
        sum.reverse();
        return sum.toString();
    }
}

