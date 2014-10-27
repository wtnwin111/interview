package com.interview.algorithms.general;

import com.interview.competation.Count2;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-10-27
 * Time: 下午9:02
 */
public class C1_37_A_CountMFrom0ToNTest extends TestCase {
    public void testCount1() throws Exception {
        int count = Count2.count(23, 1);
        assertEquals(count, Count2.answer(23, 1));
        count = Count2.count(223, 1);
        assertEquals(count, Count2.answer(223, 1));
        count = Count2.count(1223, 1);
        assertEquals(count, Count2.answer(1223, 1));
    }

    public void testCount2() throws Exception {
        int count = Count2.count(23, 2);
        assertEquals(count, Count2.answer(23, 2));
        count = Count2.count(223, 2);
        assertEquals(count, Count2.answer(223, 2));
        count = Count2.count(1223, 2);
        assertEquals(count, Count2.answer(1223, 2));
    }

//    public void testCount0() throws Exception {
//        int count = Count2.count(23, 0);
//        assertEquals(count, Count2.answer(23, 0));
//        count = Count2.count(223, 0);
//        assertEquals(count, Count2.answer(223, 0));
//        count = Count2.count(1223, 2);
//        assertEquals(count, Count2.answer(1223, 0));
//    }
}
