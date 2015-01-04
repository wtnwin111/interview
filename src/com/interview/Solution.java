package com.interview;

import com.interview.utils.ArrayUtil;

/**
 * Created_By: stefanie
 * Date: 14-12-17
 * Time: 上午8:30
 */
public class Solution {

    public int KthLargest(int[] num, int K){
        if(num.length == 0 || num.length < K) return -1;
        int low = 0;
        int high = num.length - 1;
        while(low <= high){
            int partition = partition(num, low, high);
            if(partition == K) return num[partition];
            else if(partition < K) low = partition + 1;
            else high = partition - 1;
        }
        return -1;
    }

    public int partition(int[] num, int low, int high){
        int pivot = low;
        for(int i = low + 1; i <= high; i++){
            if(num[i] > num[low]) ArrayUtil.swap(num, ++pivot, i);
        }
        ArrayUtil.swap(num, pivot, low);
        return pivot;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.KthLargest(null, 20);
        //int result = solution.compareVersion("1", "0");
        //System.out.println(result);
//        List<Integer> list = new ArrayList(2);
//        list.set(1, 1);

//        System.out.println();
//        ConsoleWriter.printCollection(sols);
    }
}
