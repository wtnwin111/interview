package com.interview.leetcode.strings;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 上午8:27
 */
public class Palindrome {

    /**
     * validate the input s is palindrome or not.
     *  only consider letter and digit, and have a boolean flag for case sensitive or not.
     */
    public boolean valid(String s, boolean caseSensitive) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(caseSensitive){
                if(s.charAt(i) != s.charAt(j)) return false;
            } else {
                if (Character.toLowerCase(s.charAt(i))
                        != Character.toLowerCase(s.charAt(j))) return false;
            }
            i++; j--;
        }
        return true;
    }
}
