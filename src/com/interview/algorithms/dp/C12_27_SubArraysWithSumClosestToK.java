package com.interview.algorithms.dp;

import java.util.HashMap;
import java.util.List;

/**
 * Given an int array, find the sub arrays whose sum is closest to a given K
 * @author stefanie
 *
 */
public class C12_27_SubArraysWithSumClosestToK {

	private static HashMap<Integer, List<Integer>> subarrays = new HashMap<Integer, List<Integer>>();

    public static boolean[] find(int[] array, int K){
        int len = array.length;
        boolean[] mark = new boolean[len];

        int sum = 0;
        for (int i = 0; i < len; i++) sum += array[i];
        if(sum <= K) {
            for(int i = 0; i < len; i++) mark[i] = true;
            return mark;
        }

        int[][] result = new int[len][K + 1];
        for (int i = 0; i < len; i++) {
            for(int j = 0; j < K + 1; j++){
                int previous_no = i-1 < 0? 0 : result[i-1][j];
                if(j >= array[i]){
                    int previous_yes = i - 1 < 0? 0 : result[i-1][j-array[i]];
                    result[i][j] = Math.max(previous_no, previous_yes + array[i]);
                } else
                    result[i][j] = previous_no;
            }
        }
        int j = K;
        int i = len - 1;
        while(i >= 0 && j > 0){
            if(( i > 0 && result[i][j] > result[i-1][j]) || (i == 0 && j == array[i])){ // 找到第一个接近 sum/2 的，然后与 它上面的比较，如果大于，则代表当前 i 被选中
                mark[i] = true;
                j -= array[i];
            }
            i--;
        }

        return mark;
    }

}
