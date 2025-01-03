package com.gfg.gfg160.hashing;

import java.util.HashSet;

public class UnionOfTwoArrays {
    public static int findUnion(int a[], int b[]) {
        var unionSet = new HashSet<Integer>();
        for (int element : a) {
            unionSet.add(element);
        }

        for (int element : b) {
            unionSet.add(element);
        }
        return unionSet.size();
    }
}
