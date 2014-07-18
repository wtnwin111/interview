package com.interview.algorithms.array;

/**
 * Created_By: stefanie
 * Date: 14-7-18
 * Time: 下午11:17
 *
 * A int array contains positive and negative number, find the max of sum of continous sub array.
 */
public class C4_29_MaxSubArraySum {

    public static int max(int[] array){
        int sum = 0, max = 0;
        for(int i = array.length - 1; i >= 0; i--){
            sum = Math.max(sum + array[i], 0);
            if(sum > max) max = sum;
        }
        return max;
    }
}
