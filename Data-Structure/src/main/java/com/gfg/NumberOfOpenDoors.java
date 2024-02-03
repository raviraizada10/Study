package com.gfg;

public class NumberOfOpenDoors {
    static int noOfOpenDoors(Long N) {
        int count = 0;
        for (long i = 1L; i <= N; i++) {
            double root_n = (Math.sqrt(i));
            if (root_n % 1 == 0) count++;
        }
        return count;
    }
}
