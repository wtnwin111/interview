package com.interview.books.leetcodeoj;

/**
 * Created_By: stefanie
 * Date: 14-12-19
 * Time: 上午10:18
 */
public class LOJ28_SubstringMatching {

    //Naive solution: for every position of str, try to check if it can match pattern. O(N^2).
    //KMP: optimize by minimize the backtracing in str, str only go forward, and pattern backtracing to least.
    //1. i as offset of str, j as offset of pattern.
    //2. if str.charAt(i) == pattern.charAt(j) i++, j++;
    //3. if not matched, if(j == 0) i++; else j = next[j];
    //4. if(j == pattern.length()) return i - j;
    //5. callNext() as the same process of strStr();
    public int strStr(String str, String pattern) {
        if(pattern == null || pattern.length() == 0) return 0;
        else if(str == null || str.length() == 0) return -1;
        int[] next = calNext(pattern);
        int i = 0; int j = 0;
        while(i < str.length() && j < pattern.length()){
            if(str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else if(j == 0) i++;
            else j = next[j];
            if(j == pattern.length()) return i - j;
        }
        return -1;
    }

    private int[] calNext(String pattern){
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int front = 0;
        int back = -1;
        while(front < next.length - 1){
            if(back == -1 || pattern.charAt(front) == pattern.charAt(back)){
                next[++front] = ++back;
            } else {
                back = next[back];
            }
        }
        return next;
    }
}
