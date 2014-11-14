package com.interview.leetcode.arrays;

import com.interview.leetcode.arrays.searching.SearchingRotatedArray;
import com.interview.leetcode.arrays.searching.SearchingSortedArray;
import com.interview.leetcode.arrays.searching.SearchingSortedArrayWithDuplication;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午2:41
 */
public class SearchingTest extends TestCase {
    public void testFind() throws Exception {
        int[] num = new int[]{1,2,3,4,5,6,7,8};
        assertEquals(-1, SearchingSortedArray.findL(num, 0));
        assertEquals(-1, SearchingSortedArray.findL(num, 9));
        assertEquals(4, SearchingSortedArray.findL(num, 5));
        assertEquals(7, SearchingSortedArray.findL(num, 8));
        assertEquals(0, SearchingSortedArray.findL(num, 1));

        assertEquals(-1, SearchingSortedArray.findR(num, 0));
        assertEquals(-1, SearchingSortedArray.findR(num, 9));
        assertEquals(4, SearchingSortedArray.findR(num, 5));
        assertEquals(7, SearchingSortedArray.findR(num, 8));
        assertEquals(0, SearchingSortedArray.findR(num, 1));
    }

    public void testFindFirst() throws Exception {
        int[] num = new int[]{1,1,2,3,4,5,5,5,5,6,7,8};
        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstL(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstL(num, 9));
        assertEquals(5, SearchingSortedArrayWithDuplication.findFirstL(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findFirstL(num, 8));
        assertEquals(0, SearchingSortedArrayWithDuplication.findFirstL(num, 1));

        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstR(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findFirstR(num, 9));
        assertEquals(5, SearchingSortedArrayWithDuplication.findFirstR(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findFirstR(num, 8));
        assertEquals(0, SearchingSortedArrayWithDuplication.findFirstR(num, 1));
    }

    public void testFindLastLoop() throws Exception {
        int[] num = new int[]{1,1,2,3,4,5,5,5,5,6,7,8};
        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastL(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastL(num, 9));
        assertEquals(8, SearchingSortedArrayWithDuplication.findLastL(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findLastL(num, 8));
        assertEquals(1, SearchingSortedArrayWithDuplication.findLastL(num, 1));

        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastR(num, 0));
        assertEquals(-1, SearchingSortedArrayWithDuplication.findLastR(num, 9));
        assertEquals(8, SearchingSortedArrayWithDuplication.findLastR(num, 5));
        assertEquals(11, SearchingSortedArrayWithDuplication.findLastR(num, 8));
        assertEquals(1, SearchingSortedArrayWithDuplication.findLastR(num, 1));
    }

    public void testMinInRotatedNoDup() throws Exception {
        assertEquals(1, SearchingRotatedArray.minL(new int[]{1, 2}));
        assertEquals(1, SearchingRotatedArray.minL(new int[]{2, 1}));
        assertEquals(1, SearchingRotatedArray.minR(new int[]{1, 2}));
        assertEquals(1, SearchingRotatedArray.minR(new int[]{2, 1}));
    }

    public void testMaxInRotatedNoDup() throws Exception {
        assertEquals(2, SearchingRotatedArray.maxL(new int[]{1, 2}));
        assertEquals(2, SearchingRotatedArray.maxL(new int[]{2, 1}));
        assertEquals(2, SearchingRotatedArray.maxR(new int[]{1, 2}));
        assertEquals(2, SearchingRotatedArray.maxR(new int[]{2, 1}));
        assertEquals(3, SearchingRotatedArray.maxR(new int[]{1, 2,3}));
        assertEquals(3, SearchingRotatedArray.maxR(new int[]{2, 3,1}));
    }

    public void testFindInRotatedNoDup() throws Exception {
        int[] num = new int[]{4,5,6,7,1,2,3};
        assertEquals(5, SearchingRotatedArray.findL(num, 2));
        assertEquals(1, SearchingRotatedArray.findL(num, 5));
        assertEquals(-1, SearchingRotatedArray.findL(num, 9));
        assertEquals(-1, SearchingRotatedArray.findL(num, 0));
        assertEquals(5, SearchingRotatedArray.findL(num, 2));
        assertEquals(1, SearchingRotatedArray.findL(num, 5));
        assertEquals(-1, SearchingRotatedArray.findL(num, 9));
        assertEquals(-1, SearchingRotatedArray.findL(num, 0));

        num = new int[]{4,5,1,2,3};
        assertEquals(3, SearchingRotatedArray.findR(num, 2));
        assertEquals(1, SearchingRotatedArray.findR(num, 5));
        assertEquals(-1, SearchingRotatedArray.findR(num, 9));
        assertEquals(-1, SearchingRotatedArray.findR(num, 0));
        assertEquals(3, SearchingRotatedArray.findR(num, 2));
        assertEquals(1, SearchingRotatedArray.findR(num, 5));
        assertEquals(-1, SearchingRotatedArray.findR(num, 9));
        assertEquals(-1, SearchingRotatedArray.findR(num, 0));
    }
}
