package com.interview.books.svinterview;

import com.interview.utils.ArrayUtil;

/**
 * Created_By: stefanie
 * Date: 14-12-5
 * Time: 下午7:18
 */
public class SV6_SmallestSubsetSumLargerThanK {

    public static int find(int[] array, int K){
        return find(array, K, 0, array.length - 1);
    }

    public static int find(int[] array, int K, int low, int high){
        if(low > high) return -1;
        int pivot = low;
        int sum = 0;
        for(int j = low + 1; j <= high; j++){
            if(array[j] > array[low]) {
                sum += array[j];
                ArrayUtil.swap(array, ++pivot, j);
            }
        }
        ArrayUtil.swap(array, pivot, low);
        sum += array[pivot];
        if(sum < K) return find(array, K - sum, pivot + 1, high);
        else {
            int index = find(array, K, low, pivot - 1);
            return index != -1 ? index : pivot;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{5,2,1,7,3,4,9};
        int index = find(array, 18);
        for(int i = 0; i <= index; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        index = find(array, 10);
        for(int i = 0; i <= index; i++)
            System.out.print(array[i] + " ");
    }
}
