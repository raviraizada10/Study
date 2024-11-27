package com.striver;

public class ReverseBits {
    public static long reverseBits(long n) {
        char[]  binary = String.format("%32s", Long.toBinaryString(n)).replace(' ', '0').toCharArray();
        char[]  reverse  = new char[binary.length];
        for (int i = binary.length -1, j = 0; i >= 0; i--) {
            reverse[j] = binary[i];
            j++;
        }
        return Long.parseLong(String.valueOf(reverse), 2);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(12));
    }
}
