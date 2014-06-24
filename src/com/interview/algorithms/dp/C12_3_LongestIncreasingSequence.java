package com.interview.algorithms.dp;

/**
 * Created_By: zouzhile
 * Date: 3/14/14
 * Time: 5:39 PM
 *
 * Given a sequence of N numbers - A[1] , A[2] , ..., A[N] .
 * Find the length of the longest non-decreasing sequence.
 * and print out the sequence
 */
public class C12_3_LongestIncreasingSequence {

    public int[] getLengthOfLongestIncreasingSequence(int[] values) {
        int[] optimal = new int[values.length];
        int[] seq = new int[values.length];

        for(int i = 0; i < optimal.length; i ++) {
            optimal[i] = 1;
            seq[i] = i;
        }

        for(int i = 1; i < optimal.length; i ++) {
            for(int j = 0; j < i; j ++ ) {
                if(values[j] < values[i])
                    if(optimal[j] + 1 > optimal[i]) {
                        optimal[i] = optimal[j] + 1;
                        seq[i] = j;
                    }
            }
        }

        //backtrace the result
        int[] result = new int[optimal[values.length - 1]];
        int current = values.length - 1;
        for(int i = result.length - 1; i >= 0; i-- ){
            result[i] = values[current];
            current = seq[current];
        }
        return result;
    }
}
