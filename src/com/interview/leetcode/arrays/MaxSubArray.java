package com.interview.leetcode.arrays;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 下午5:38
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 *
 * If the array doesn't contain 0, so every time we multiple a number, it went to max(pos) or min(neg).
 *      if neg it will become positive when have a neg number after i-th.
 * So cal forward and backward product,
 *      1 -1 1,     if 2nd element -1 is not used in forward and backward, so backward and forward will all be negative
 *      -1, -1, 1   if 2nd element -1 is used in forward, forward will be the max.
 *      1, -1, -1   if 2nd element -1 is used in backward, backward will be the max.
 * so max = Math.max(max, Math.max(backward, forward))
 *
 * if have zero, product will be 0, so set forward and backward as 1.
 *
 * Tricks:
 *   1. if one variable get effect from previous and bring effect to post. we could scan array forward and backward.
 *   2. define a general case (no zero), and try to handle special case (zeros)
 *
 */
public class MaxSubArray {
    public static int maxProduct(int[] A) {
        int backward = 1;
        int forward = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            backward *= A[A.length - 1 - i];
            forward *= A[i];
            int tmp = Math.max(backward, forward);
            max = Math.max(max, tmp);
            if(backward == 0) backward = 1;
            if(forward == 0) forward = 1;
        }
        return max;
    }
}
