package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午8:53
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 *  Given:
 *      s1 = "aabcc",
 *      s2 = "dbbca",
 *  When s3 = "aadbbcbcac", return true.
 *  When s3 = "aadbbbaccc", return false.
 *
 *  Tricks:
 *    1. for dp problem, at first should define a state
 *          state is if select i-th seq and j-th seq in s1 and s2 could match i+j+2 th seq in s3  optimal[n+1][m+1]
 *       then define a iterator solution on state: how to get optimal[i+1][*] from optimal[0][*] ~ optimal[i][*]
 *    2. after code is complete, check if space complexity can be reduces.
 *          when optimal[i+1][*] only depends on optimal[i][*], could use optimal[m+1] instead.
 *       if reuse optimal, please update the value whatever it should be.
 */
public class InterleavingString {
    /**
     * using dp to tracking select i-th seq and j-th seq in s1 and s2 could match i+j+2 th seq in s3
     *  1. init optimal[0] by check no select from s1
     *  2. init optimal[*][0] by check no select from s2
     *  3. do search for every i-th and j-th,
     *     could match when
     *      if i-th char in s2 equals to the (i+j+1)th char in s3, and previous j-th in s2 is matched without i-th char
     *      or
     *      if j-th char in s1 equals to the (i+j+1)th char in s3, and previous j-1th in s2 is matched with i-th char
     *
     *  a straight-forward solution should be Time: O(n*m), and Space: O(n*m)
     *  and space could optimize since
     *      optimal[i+1][*] only depends on optimal[i][*], so could use Space O(m)
     */
    // state[i][j]: whether i chars from s1 and j chars from s2 interleaves the first i + j chars in s3
    // initialize: state[0][0] = true;
    //             state[i][0] = state[i-1][0] && s1[i-1] == s3[i-1], i = 1 .. s1.length();
    //             state[0][j] = state[0][j-1] && s2[j-1] == s3[j-1], j = 1 .. s2.length();
    // function: state[i][j] = state[i][j] || state[i-1][j] if s1[i-1] == s3[i + j - 1]
    //           state[i][j] = state[i][j] || state[i][j-1] if s2[j-1] == s3[i + j - 1]
    //           state[i][j] = false otherwise
    // result: state[s1.length()][s2.length()]
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;

        // initialize
        int length = s1.length() > s2.length() ? s1.length() : s2.length();
        boolean[][] match = new boolean[length + 1][length+1];

        match[0][0] = true;
        for(int i = 1; i <= s1.length(); i ++)
            match[i][0] = match[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);

        for(int i = 1; i <= s2.length(); i ++)
            match[0][i] = match[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);

        // function
        for(int i = 1; i <= s1.length(); i ++)
            for(int j = 1; j<= s2.length(); j ++) {
                match[i][j] = false;
                if(s1.charAt(i-1) == s3.charAt(i + j - 1))  match[i][j] = match[i][j] || match[i-1][j];
                if(s2.charAt(j-1) == s3.charAt(i + j - 1))  match[i][j] = match[i][j] || match[i][j-1];
            }
        return match[s1.length()][s2.length()];
    }

    /**
     * optimal space usage to O(m)
     */
    public static boolean isInterleaveOptz(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;

        // initialize
        int length = s1.length() > s2.length() ? s1.length() : s2.length();
        boolean[] match = new boolean[length + 1];

        match[0] = true;
        for(int i = 1; i <= s2.length(); i ++)
            match[i] = match[i-1] && s2.charAt(i-1) == s3.charAt(i-1);

        // function
        for(int i = 1; i <= s1.length(); i ++)
            for(int j = 0; j<= s2.length(); j ++) {
                if(j == 0){
                    if(s1.charAt(i-1) == s3.charAt(i-1)) match[0] = true;
                    else match[0] = false;
                    continue;
                }
                boolean couldMatch = false;
                if(s1.charAt(i-1) == s3.charAt(i + j - 1))  couldMatch = couldMatch || match[j];
                if(s2.charAt(j-1) == s3.charAt(i + j - 1))  couldMatch = couldMatch || match[j-1];
                match[j] = couldMatch;
            }
        return match[s2.length()];
    }
}
