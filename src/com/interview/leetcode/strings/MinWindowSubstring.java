package com.interview.leetcode.strings;

import java.util.HashMap;

/**
 * Created_By: stefanie
 * Date: 14-11-17
 * Time: 上午12:11
 */
public class MinWindowSubstring {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0) return S;
        if (T == null || T.length() == 0) return "";

        HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();  //count how many char appear in T
        for (int i = 0; i < T.length(); i++) {
            Character c = T.charAt(i);
            if (tCounter.containsKey(c)) {
                tCounter.put(c, tCounter.get(c) + 1);
            } else {
                tCounter.put(c, 1);
            }
        }

        HashMap <Character, Integer> mCounter = new HashMap<Character, Integer>();  //count how many char appear in min window
        String window = "";
        int count = 0, begin = 0;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (!tCounter.containsKey(c)) continue;

            if (mCounter.containsKey(c)) mCounter.put(c, mCounter.get(c) + 1);
            else mCounter.put(c, 1);

            if (mCounter.get(c) <= tCounter.get(c)) count ++;  //if not a duplication, count one

            if (count == T.length()) {  //find a substring contains all char, shrink begin
                while (begin < S.length()) {
                    Character ch = S.charAt(begin);
                    if (tCounter.containsKey(ch) ) {
                       if(mCounter.get(ch) > tCounter.get(ch)) mCounter.put(ch, mCounter.get(ch) - 1); //have duplication
                       else break;
                    }
                    begin ++;
                }
                if (window == "" || i - begin + 1 < window.length()) window = S.substring(begin, i + 1);
            }
        }

        return window;
    }
}
