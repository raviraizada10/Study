package com.codingninjas.babbar.ds.array.easy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @see <a href="https://www.codingninjas.com/codestudio/problems/duplicate-in-array_893397?topList=love-babbar-dsa-sheet-problems">Duplicate in Array</a>
 */
public class FindDuplicate {
    public static int findDuplicate(ArrayList<Integer> arr) {
        Collections.sort(arr);
        for (int i = 0; i < arr.size() -1 ; i++) {
            if(arr.get(i).equals(arr.get(i+1))){
                return arr.get(i);
            }
        }
        return 0;
    }
}
