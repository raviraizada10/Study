package com.gfg.gfg160.string;

import java.util.ArrayList;

public class FizzBuzz {
    public static ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if(i % 3 != 0 && i % 5 != 0) {
                sb.append(i+1);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
