package com.interview.leetcode.arrays;

/**
 * Created_By: stefanie
 * Date: 14-11-17
 * Time: 下午7:52
 */
public class ArrayOperation {

    public static void rotateKStep(int[] array, int k){
        if(array.length <= 1) return;
        k = k % array.length;

        reverse(array, 0, array.length - 1);
        reverse(array, 0, array.length - 1 - k);
        reverse(array, array.length - k, array.length - 1);
    }

    public static void reverse(int[] array, int begin, int end){
        for(int i = 0; i < (end - begin + 1)/ 2; i++){
            int temp = array[begin + i];
            array[begin + i] = array[end - i];
            array[end - i] = temp;
        }
    }
}
