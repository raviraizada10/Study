package com.gfg.gfg160.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class StockSpan {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<int[]> spanQueue =  new ArrayDeque<>();
        for (int price: arr) {
            var count = 1;
            while(!spanQueue.isEmpty() && spanQueue.peek()[0] <= price){
                count += spanQueue.pop()[1];
            }
            spanQueue.push(new int[]{price, count});
            result.add(count);
        }
        return result;
    }
}
