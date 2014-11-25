package com.interview.leetcode.dp;

import java.util.Set;

/**
 * Created_By: stefanie
 * Date: 14-11-25
 * Time: 上午10:06
 */
public class OneSequenceDP {

    /**
     * Given a sequence of integers, find the longest increasing subsequence (LIS).
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int[] len = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            len[i] = 1;  //INIT
            for(int j = 0; j < i; j++){
                if(nums[j] <= nums[i]) {
                    len[i] = Math.max(len[j] + 1, len[i]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(len[i], max);
        }
        return max;
    }

    /**
     * A message containing letters from A-Z is being encoded to numbers, A -> 1 B -> 2 ... Z -> 26
     * Given an encoded message containing digits, determine the total number of ways to decode it.
     * When the digits is in-valid, return 0
     *  State：ways[i]       s.substring(0, i)
     *  Transfer：canSegment[i] = true, if can find j canSegment[j] == true and s.substring(j, i)在字典里
     *  Init：   canSegment[0] = true
     *  Answer：canSegment[s.length()]
     */
    static class DecodeWays{
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

    /**
     * Given a word dict, and a sens, figure out if the sens can be segmented into words in the dict
     *  State：canSegment[i]     if  s.substring(0, i) can be segmented or not
     *  Transfer：canSegment[i] = true, if can find j canSegment[j] == true and s.substring(j, i) in the dict
     *  Init：   canSegment[0] = true
     *  Answer：canSegment[s.length()]
     */
    static class WordBreak {
        //Time: O(N^2)  Space: O(N)
        public static boolean couldBreak(String s, Set<String> dict) {
            if (s == null || s.length() == 0) return false;
            int maxLen = maxLength(dict);
            boolean[] canSegment = new boolean[s.length() + 1];
            canSegment[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                canSegment[i] = false;
                for(int j = i - 1; j >= 0 && i - j <= maxLen; j--){
                    if (!canSegment[j]) continue;
                    String word = s.substring(j, i);
                    if (dict.contains(word)) {
                        canSegment[i] = true;
                        break;
                    }
                }
            }
            return canSegment[s.length()];
        }

        public static int maxLength(Set<String> dict) {
            int length = 0;
            for (String word : dict) length = Math.max(length, word.length());
            return length;
        }
    }
}
