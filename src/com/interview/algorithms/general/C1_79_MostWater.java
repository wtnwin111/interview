package com.interview.algorithms.general;

/**
 * Created_By: stefanie
 * Date: 14-11-7
 * Time: 下午11:26
 */
public class C1_79_MostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
                while(left < right && height[left] <= height[left - 1]) left++;
            } else {
                right--;
                while(left < right && height[right] <= height[right + 1]) right--;
            }
        }
        return max;
    }
}
