package com.gfg;

import java.util.LinkedList;

public class NthRoot {

    public int NthRootPow(int n, int m) {
        double root = Math.pow(m, 1.0 / n);
        int roundedRoot = (int) Math.round(root);

        if (Math.pow(roundedRoot, n) == m) {
            return roundedRoot;
        }
        else {
            return -1;
        }
    }

    public int NthRoot(int n, int m) {
        int low = 1;
        int high = m;
        int mid;
        double res;
        while (low < high) {
            mid = (low + high) / 2;
            res = Math.pow(mid, n);
            if (res == m) return mid;
            else if (res > m) high = mid--;
            else low = mid++;
        }
        return -1;
    }

    /*
    1C0C1C1A0B1
    C
     */
    public static int operationsBinaryString (String str){
        char[] array = str.toCharArray();
        int res = array[0];
        for (int i = 1; i < array.length;) {
            char prev = array[i];
            i++;
            if(prev == 'A') res &= array[i];
            else if(prev == 'B') res |= array[i];
            else if(prev == 'C') res ^= array[i];
        }
        return res-'0';
    }


    public static void main(String[] args) {
        System.out.println(operationsBinaryString("1C0C1C1A0B1"));
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("A");
        list1.remove(0);
        list1.set(0, "B");

    }

}
