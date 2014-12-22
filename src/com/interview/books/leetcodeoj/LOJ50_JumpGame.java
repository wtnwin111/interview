package com.interview.books.leetcodeoj;

/**
 * Created_By: stefanie
 * Date: 14-12-22
 * Time: 下午6:09
 */
public class LOJ50_JumpGame {
    //scan i from 0 to A.length - 1,
    //find a break point j from [0-i-1] where canJump[j] == true and A[j] + j >= i
    public boolean canJump(int[] A) {
        boolean[] canJump = new boolean[A.length];
        canJump[0] = true;
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < i; j++){
                if(canJump[j] && A[j] + j >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[A.length - 1];
    }
}
