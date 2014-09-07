package com.interview.algorithms.string;

/**
 * Created_By: stefanie
 * Date: 14-9-7
 * Time: 下午1:55
 */
public class C11_23_LongestNonduplicateSubstring {

    public static int find(String input){
        boolean[] mark = new boolean[256]; //assume unicode
        char[] chars = input.toCharArray();
        int max = 0;
        int begin = 0;
        for(int i = 0; i < chars.length; i++){
            char ch = chars[i];
            if(mark[ch]) {
                while(chars[begin] != ch){
                    mark[chars[begin]] = false;
                    begin++;
                }
                begin++;
            } else {
                mark[ch] = true;
            }
            int length = i - begin + 1;
            if(length > max) max = length;
        }
        return max;
    }
}
