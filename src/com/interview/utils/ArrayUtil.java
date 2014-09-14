package com.interview.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chenting on 2014/6/27.
 */
public class ArrayUtil {

    public static Integer[] sort(Integer[] numbers){
        List<Integer> input = Arrays.asList(numbers);
        Collections.sort(input);
        Integer[] sorted = input.toArray(new Integer[input.size()]);
        return sorted;
    }

    public static Character[] getCharArray(String str){
        Character[] chars = new Character[str.length()];
        for(int i = 0; i < str.length(); i++) chars[i] = str.charAt(i);
        return chars;
    }

    public static String getString(Character[] chars){
        char[] str = new char[chars.length];
        for(int i = 0; i < chars.length; i++) str[i] = chars[i];
        return String.copyValueOf(str);
    }

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static String swap(String str, int i, int j){
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return String.copyValueOf(chars);
    }

    public static void swap(Integer[][] matrix, int x1, int y1, int x2, int y2){
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void swap(Object[] array, int i, int j){
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void reverse(int[] array, int s, int e){
        while(s < e){
            swap(array, s++, e--);
        }
    }

    public static void reverse(Object[] array, int s, int e){
        while(s < e){
            swap(array, s++, e--);
        }
    }
}
