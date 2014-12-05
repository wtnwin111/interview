package com.interview.flag.o;

/**
 * Created_By: stefanie
 * Date: 14-12-5
 * Time: 上午10:39
 *
 * http://leetcode.com/2011/05/a-distance-maximizing-problem.html
 *
 * Generally, we want to choose only starting points with no such lines that are shorter to its left side.
 */
public class O3_MaxDistance {
    public static int maxDistance(int[] array){
        boolean[] isStart = new boolean[array.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){   //find the decrease sequence
            if(array[i] < min) {
                isStart[i] = true;
                min = array[i];
            }
        }
        int max = 0;
        int start = array.length - 1;
        int end = array.length - 1;
        while(start >= 0){
            if(!isStart[start]) {  //find the first start point
                start--;
                continue;
            }
            while(array[end] <= array[start] && end > start) end--; //find the end which larger than start
            max = Math.max(max, end - start);
            start--;
        }
        return max;
    }

    public static void main(String[] args){
        int[] array = new int[]{4,3,5,2,1,3,2,3};
        System.out.println(maxDistance(array));
    }
}
