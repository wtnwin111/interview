package com.interview.algorithms.string;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-9
 * Time: 下午8:59
 */
public class C11_36_DecodeWaysTest extends TestCase {
    public void testNumDecodings() throws Exception {
        assertEquals(0, C11_36_DecodeWays.numDecoding("00"));
        assertEquals(0, C11_36_DecodeWays.numDecoding("01"));
        assertEquals(0, C11_36_DecodeWays.numDecoding("40"));
        assertEquals(0, C11_36_DecodeWays.numDecoding(""));
        assertEquals(1, C11_36_DecodeWays.numDecoding("10"));
        assertEquals(1, C11_36_DecodeWays.numDecoding("110"));
        assertEquals(3, C11_36_DecodeWays.numDecoding("124"));

    }
}
