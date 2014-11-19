package com.interview.leetcode.arrays;

import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-18
 * Time: 下午7:57
 */
public class MissingRangeTest extends TestCase {
    public void testcase(){
        int[] num = new int[]{0, 1, 3, 50, 75};
        List<String> ranges = MissingRange.findMissingRanges(num, 0, 99);
        for(String range : ranges) System.out.println(range);

        ranges = MissingRange.findMissingRanges(num, -4, 75);
        for(String range : ranges) System.out.println(range);

        num = new int[0];
        ranges = MissingRange.findMissingRanges(num, 0, 99);
        for(String range : ranges) System.out.println(range);
    }
}
