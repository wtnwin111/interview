package com.interview.leetcode.dp;

/**
 * Created_By: stefanie
 * Date: 14-11-24
 * Time: 下午9:23
 */
public class SimpleDP {
    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     */
    //Time: O(N), Space: O(1)
    public int climbStairs(int n) {
        int[] ways = new int[3];
        ways[0] = 1;
        ways[1] = 2;
        for(int i = 2; i < n; i++){
            ways[i%3] = ways[(i - 2)%3] + ways[(i - 1)%3];
        }
        return ways[(n - 1)%3];
    }

    /**
     * A message containing letters from A-Z is being encoded to numbers, A -> 1 B -> 2 ... Z -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * When the digits is in-valid, return 0
     */
    //Time: O(N), Space: O(1)
    public int decodeWays(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] ways = new int[3];
        ways[0] = 1;
        ways[1] = 1;

        for(int i = 2; i <= s.length(); i++){
            char ch = s.charAt(i - 1);
            char pre = s.charAt(i - 2);
            if(ch == '0'){
                if(pre == '0' || pre > '2') return 0;
                else ways[i%3] = ways[(i - 2)%3];
            } else {
                int num = (pre - '0') * 10 + ch - '0';
                if(num < 10 || num > 26) ways[i%3] = ways[(i - 1)%3];
                else ways[i%3] = ways[(i - 1)%3] + ways[(i - 2)%3];
            }
        }
        return ways[s.length()%3];
    }
}
