package com.interview.algorithms.general;

/**
 * Created_By: stefanie
 * Date: 14-7-29
 * Time: 下午10:18
 */
public class C4_41_OddEvenNumber {

    public static void order(int[] a){
        int low = 0;
        int high = a.length - 1;
        while(low < high){
            while(low < high && a[low] % 2 != 0) low++;
            while(high > low && a[high] % 2 == 0) high--;
            if(low < high)
                swap(a, low++, high--);
        }
    }

    private static void swap(int[] a, int low, int high){
        int tmp = a[low];
        a[low] = a[high];
        a[high] = tmp;
    }
}
