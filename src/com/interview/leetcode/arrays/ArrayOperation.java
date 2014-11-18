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

        reverse(array, 0, k - 1);
        reverse(array, k, array.length - 1);
        reverse(array, 0, array.length - 1);

//        reverseByLength(array, 0, k);
//        reverseByLength(array, k, array.length - k);
//        reverseByLength(array, 0, array.length);
    }

    public static void reverse(int[] array, int begin, int end){
        for(int i = 0; i < (end - begin + 1)/ 2; i++){
            int temp = array[begin + i];
            array[begin + i] = array[end - i];
            array[end - i] = temp;
        }
    }

    public static void reverseByLength(int[] array, int begin, int length){
        int end = begin + length - 1;
        for(int i = 0; i < length / 2; i++){
            int temp = array[begin + i];
            array[begin + i] = array[end - i];
            array[end - i] = temp;
        }
    }
}
