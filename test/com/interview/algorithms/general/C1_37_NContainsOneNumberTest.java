package com.interview.algorithms.general;

import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-23
 * Time: 下午10:08
 */
public class C1_37_NContainsOneNumberTest extends TestCase {
    public void testcase1(){
        assertEquals(5, C1_37_NContainsOneNumber.number(12));
    }

    public void testcase2(){
        assertEquals(2, C1_37_NContainsOneNumber.number(10));
    }

    public void testcase3(){
        assertEquals(4, C1_37_NContainsOneNumber.number(11));
    }

    public void testcase4(){
        assertEquals(29, C1_37_NContainsOneNumber.number(111));
    }
}
