package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-12-17
 * Time: 上午8:30
 */
public class Solution {

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
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.strStr("mississippi", "mississippi");
        List<Integer> list = new ArrayList(2);
        list.set(1, 1);

//        System.out.println();
//        ConsoleWriter.printCollection(sols);
    }
}
