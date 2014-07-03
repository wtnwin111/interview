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
}
