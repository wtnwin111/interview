package com.interview.algorithms.dp;

/**
 * Created_By: zouzhile
 * Date: 3/24/14
 * Time: 2:53 PM
 *
 See http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493

 A sequence of numbers is called a zig-zag sequence if the differences
 between successive numbers strictly alternate between positive and negative.
 The first difference (if one exists) may be either positive or negative.
 A sequence with fewer than two elements is trivially a zig-zag sequence.

 For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3)
 are alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences,
 the first because its first two differences are positive and the second because its last difference is zero.

 Given a sequence of integers, sequence, return the length of the longest subsequence of sequence
 that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero)
 from the original sequence, leaving the remaining elements in their original order.
 */
public class C12_5_ZigZag {

    public int longestZigZag(int[] array) {
        // optimal[i] is the length of the longest zigzag for subarray [0..i]
        int[] optimal = new int[array.length];
        // sol[i] is the members of the longest zigzag for subarray [0..i]
        boolean[][] sol = new boolean[array.length][array.length];

        // init states
        for(int i = 0; i < array.length; i ++) {
            optimal[i] = 1;
            sol[i][i] = true; // at least the element itself is a zigzag of length 1
        }

        for(int i = 1; i < array.length; i ++) {
            for(int j = i - 1; j >= 0; j --) {
                // for each previous known longest zigzag of subarray[0..j]
                // check whether it can produce a new longest zigzag by combining with array[i]
                for(int k = j - 1; k >=0; k --)  {
                    if(sol[j][k]) {
                        if((array[i] - array[j]) * (array[j] - array[k]) < 0 // zigzag found
                                && optimal[j] + 1 > optimal[i]) { // longer than current sol[i]
                            // copy j including j
                            for(int m = 0; m <= j; m ++)
                                sol[i][m] = sol[j][m];
                            sol[i][i] = true; // array[i] is counted
                            optimal[i] = optimal[j] + 1;
                        } else {
                            if(array[i] > array[j] && array[j] > array[k] ||
                                    array[i] < array[j] && array[j] < array[k]) {
                                // choose the larger or smaller i
                                // copy j excluding j
                                for(int m = 0; m < j; m ++)
                                    sol[i][m] = sol[j][m];
                                sol[i][i] = true;  // selecting i
                                //sol[i][j] = false; // deselecting j
                            }
                        }
                        break;
                    }
                }

                // longest zigzag of subarray [0..j] is length 1, i.e. array[j] itself
                if(optimal[i] == 1 && array[i] != array[j]) {
                    optimal[i] = 2;
                    sol[i][j] = true;
                    sol[i][i] = true;
                }

                if(optimal[j] > optimal[i]) {
                    optimal[i] = optimal[j];
                    // copy j including j
                    for(int m = 0; m <= j; m ++)
                        sol[i][m] = sol[j][m];
                }
            }
        }
        System.out.println("\n");
        for(int i = 0; i < array.length; i ++)
            if(sol[array.length - 1][i])
                System.out.print(array[i] + "\t");
        return optimal[array.length - 1];
    }


}
