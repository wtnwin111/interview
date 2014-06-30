package com.interview.algorithms.array;

/**
 * Created_By: stefanie
 * Date: 14-6-30
 * Time: 下午9:37
 *
 * Given a rotated sorted array, the element might appears in the order 3,4,5,6,7,1,2.
 * How would you find the minimum element
 */
public class C4_27_MinFinderInRotateSortedList {
    public static int findMin(int[] array){
        return findMin(array, 0, array.length - 1);
    }

    private static int findMin(int[] array, int start, int end){
        if(start == end) return array[end];
        else if(end - start == 1) return array[start] > array[end]? array[end] : array[start];
        int mid = start + (end - start) / 2;
        if(array[mid] > array[end]){
            return findMin(array, mid, end);
        } else {
            return findMin(array, start, mid);
        }
    }
}
