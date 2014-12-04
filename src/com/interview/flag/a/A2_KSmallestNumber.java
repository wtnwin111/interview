package com.interview.flag.a;

import com.interview.utils.ArrayUtil;
import com.interview.utils.ConsoleWriter;

/**
 * Created_By: stefanie
 * Date: 14-12-4
 * Time: 下午5:42
 */
public class A2_KSmallestNumber {
    public static int[] find(int[] array, int k){
        int[] smallest = new int[k];
        find(array, k, 0, array.length - 1);
        for(int i = 0; i < k; i++) smallest[i] = array[i];
        return smallest;
    }

    public static void find(int[] array, int k, int low, int high){
        if(low > high) return;
        int pivot = partition(array, low, high);
        if(pivot == k - 1 || pivot == k) return;
        else if(pivot > k) find(array, k, low, pivot - 1);
        else find(array, k, pivot + 1, high);
    }

    public static int partition(int[] array, int low, int high){
        int pivot = low;
        for(int j = low + 1; j <= high; j++){
            if(array[j] < array[low]) ArrayUtil.swap(array, ++pivot, j);
        }
        ArrayUtil.swap(array, pivot, low);
        return pivot;
    }

    public static void main(String[] args){
        int[] array = new int[]{9, 5, 1, 4, 13, 6};
        int[] smallest = A2_KSmallestNumber.find(array, 3);
        //1, 4, 5
        ConsoleWriter.printIntArray(smallest);
    }
}
