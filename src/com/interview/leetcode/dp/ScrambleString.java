package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-17
 * Time: 上午11:40
 *
 * Question: https://oj.leetcode.com/problems/scramble-string/
 *
 * Solution:
 *  State match[len][i][j]: s1.substring(i, i+len-1) matched s2.substring(j, j+len-1), the substr which length is len.
 *  Init: for len = 0, match[0][i][j] = true if s1.charAt(i) ==  s2.charAt(j)
 *  Produce:  match[len-1][i][j] = true when we could find a break point k:
 *              match[k-1][i][j] and match[len-k-1][i+k][j+k]     which means s1.substring(i, i+k-1) matches s2.substring(j, j+k-1),
 *                                                                        and s1.substring(i+k, i+len-1) matches s2.substring(j+k, j+len-1)
 *        or    match[k-1][i][j+len-k] and match[len-k-1][i+k][j] which means s1.substring(i, i+k-1) matches s2.substring(j+len-k, j+len-1)
 *                                                                        and s1.substring(i+k, i+len-1) matches s2.substring(j,j+len-k-1)
 *        example s1 -> s11 and s12 and s2 -> s21 and s22 by K
 *              first s11 matches s21 and s12 matches s22
 *              or    s11 matches s22 and s12 matches s12     //be carefully to calculate the substring
 *        since match[*][i][j] depends on match[*][>i][>j] so, scan len from 2 ~ n and i, j from n-len ~ 0
 *  Result: match[n-1][0][0]
 */
public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        if( s1.length() != s2.length()) return false;

        if( s1.length() == 0 || s1.equals(s2)) return true;

        int n = s1.length();
        boolean[][][] match = new boolean[n][n][n];
        for(int i=0; i< n; i++){
            for(int j=0;j<n; j++){
                match[0][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for(int len = 2; len <= n; len++){
            for(int i = n - len; i>= 0; i--) {
                for(int j = n - len;  j>=0; j--){
                    boolean r = false;
                    for(int k = 1; k < len && r == false; k++){  //loop for break pointer, left & right part can both match.
                        r = (match[k-1][i][j] && match[len-k-1][i+k][j+k])
                          || (match[k-1][i][j+len-k] && match[len-k-1][i+k][j]);
                    }
                    match[len-1][i][j] = r;
                }
            }
        }

        return match[n-1][0][0];
    }
}
