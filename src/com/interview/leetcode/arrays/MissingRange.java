package com.interview.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-18
 * Time: 下午7:57
 */
public class MissingRange {

    public static List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> miss = new ArrayList<>();
        if(vals == null || vals.length == 0){
            miss.add(getRange(start, end));
            return miss;
        }
        if(vals[0] != start) miss.add(getRange(start, vals[0] - 1));
        for(int i = 1; i < vals.length; i++){
            if(vals[i] == vals[i - 1] + 1) continue;
            miss.add(getRange(vals[i - 1] + 1, vals[i] - 1));
        }
        if(vals[vals.length - 1] != end)  miss.add(getRange(vals[vals.length - 1] + 1, end));
        return miss;
    }

    public static String getRange(int begin, int end){
        return begin == end? begin + "" : begin + "->" + end;
    }
}
