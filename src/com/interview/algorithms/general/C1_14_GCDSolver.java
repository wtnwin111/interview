package com.interview.algorithms.general;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/8/14
 * Time: 2:00 PM
 */
public class C1_14_GCDSolver {
    public static int gcd(int i, int j){
        if(j > i) swap(i, j);
        while(i % j != 0){
            int mod = i % j;
            i = j;
            j = mod;
        }
        return j;
    }

    private static void swap(int i, int j){
        int temp = i;
        i = j;
        j = temp;
    }
}
