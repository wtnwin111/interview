package com.interview.leetcode.strings;

import java.util.*;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午5:50
 * Given a string s and a dictionary of words dict, determine if s can be segmented into
 * a space-separated sequence of one or more dictionary words.
 * For example, given s = "leetcode",   dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * 1. check if a sens can be segmented, using DP
 *    State: boolean[] dp: canSegment[*] indicate if substr(0,i) can segment or not;
 *    Init:  canSegment[0] = true
 *    Produce: get the max length of the words in the dict
 *        scan 1 ~ length, every step divide s into prefix + suffix.
 *        suffix is length = j before i, substr(i - j, i)  j between 1 ~ max(i, max word length)
 *        if prefix can be segmented and suffix is a valid word, canSegment[i] = true;
 *    Return canSegment[s.length];
 *
 * 2. get all the segment solution of a given sens. like combination
 *      Using a HashMap to store the segment result to avoid duplicate calculation.
 */
public class WordBreak {

    static class WordBreakI {
        public static int maxLength(Set<String> dict) {
            int length = 0;
            for (String word : dict) length = Math.max(length, word.length());
            return length;
        }

        public static boolean couldBreak(String s, Set<String> dict) {
            if (s == null || s.length() == 0) return false;
            int max = maxLength(dict);
            boolean[] canSegment = new boolean[s.length() + 1];
            canSegment[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                canSegment[i] = false;
                for (int j = 1; j <= max && j <= i; j++) {
                    if (!canSegment[i - j]) continue;
                    String word = s.substring(i - j, i);
                    if (dict.contains(word)) {
                        canSegment[i] = true;
                        break;
                    }
                }
            }
            return canSegment[s.length()];
        }
    }

    static class WordBreakII {
        public static List<String> wordBreak(String s, Set<String> dict) {
            if (s == null || s.length() == 0) return new ArrayList<String>();
            Map<String, List<String>> memo = new HashMap<>();
            return wordBreak(s, dict, memo);
        }

        public static List<String> wordBreak(String s, Set<String> dict, Map<String, List<String>> memo) {
            if (memo.containsKey(s)) return memo.get(s);
            ArrayList<String> result = new ArrayList<String>();
            if (s.length() == 0) return result;
            for (int i = s.length(); i >= 0; i--) {
                String prefix = s.substring(0, i);
                if (!dict.contains(prefix)) continue;
                if (i == s.length()) result.add(prefix);
                List<String> partition = wordBreak(s.substring(i), dict, memo);
                for (String sol : partition) {
                    result.add(prefix + " " + sol);
                }
            }
            memo.put(s, result);
            return result;
        }
    }
}
