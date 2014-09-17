package com.interview.algorithms.array;

import com.interview.utils.ArrayUtil;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/17/14
 * Time: 3:49 PM
 */
public class C4_59_MergePartialSortedArray {
    public static void merge(int[] array, int split){
        int i = 0;
        int j = split;

        while(true){
            while(array[i] < array[j]) i++;
            ArrayUtil.swap(array, i++, j);
            int k = j;
            while(i <= j && k+1 < array.length && array[j] > array[k+1])
                ArrayUtil.swap(array, i++, ++k);
            if(k > j) ArrayUtil.insert(array, j+1, k+1);

            if(i == array.length - 1 || i >= k) break;
            else if(j <= i)   j = k;
        }
    }

}
