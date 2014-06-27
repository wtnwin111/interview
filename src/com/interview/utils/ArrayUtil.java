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
}
