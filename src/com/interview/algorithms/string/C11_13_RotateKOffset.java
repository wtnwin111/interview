package com.interview.algorithms.string;

/**
 * Created_By: stefanie
 * Date: 14-7-7
 * Time: 下午10:39
 */
public class C11_13_RotateKOffset {

    public static String rotate(String str, int K){
        K = K % str.length();
        char[] chars = str.toCharArray();
        reserve(chars, 0, K - 1);
        reserve(chars, K, str.length() - 1);
        reserve(chars, 0, str.length() - 1);
        return String.copyValueOf(chars);
    }

    private static void reserve(char[] chars, int start, int end){
        int M = end - start + 1;
        for(int i = 0; i < M / 2; i++){
            char temp = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = temp;
        }
    }
}
