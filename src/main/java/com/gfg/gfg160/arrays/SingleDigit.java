package com.gfg.gfg160.arrays;

public class SingleDigit {
    public int singleDigit(int n) {
        int result = 0;
        while (n > 0 || result > 9) {
            if (n == 0) {
                n = result;
                result = 0;
            }
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}
