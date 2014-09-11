package com.interview.algorithms.array;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/11/14
 * Time: 2:07 PM
 */
public class C4_54_DivideArray {

    public static boolean[] divide(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++) sum += array[i];
        sum >>= 1;

        return C4_12_SubArraysWithSumClosestToK.find(array, sum);
    }
}
