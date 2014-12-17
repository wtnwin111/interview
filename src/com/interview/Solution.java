package com.interview;

import com.interview.utils.ConsoleWriter;

import java.util.Arrays;

/**
 * Created_By: stefanie
 * Date: 14-12-17
 * Time: 上午8:30
 */
public class Solution {
    public int[] getTriangleSides(int[] segments){
        if(segments.length < 3) return new int[0];
        Arrays.sort(segments);
        for(int i = 0; i < segments.length - 2; i ++){
            int j = i + 1;
            int k = segments.length - 1;
            while(j < k){
                if(segments[i] + segments[j] < segments[k]){
                    k--;
                } else {//find a solution
                    return new int[]{segments[i], segments[j], segments[k]};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] triangle = solution.getTriangleSides(new int[]{6, 8, 10, 23, 25});
        ConsoleWriter.printIntArray(triangle);
    }
}
