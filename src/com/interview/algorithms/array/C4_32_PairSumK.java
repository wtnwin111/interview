package com.interview.algorithms.array;

import com.interview.basics.sort.QuickSorter;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/22/14
 * Time: 4:42 PM
 */
class Pair{
    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
public class C4_32_PairSumK {

    public static Pair findPair(Integer[] a, Integer K){
        QuickSorter<Integer> sorter = new QuickSorter<>();
        sorter.sort(a);

        int i = 0;
        int j = a.length - 1;
        while(i < j){
            int sum = a[i] + a[j];
            if(sum == K) return new Pair(a[i], a[j]);
            else if(sum > K) j--;
            else i++;
        }
        return null;
    }
}
