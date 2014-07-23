package com.interview.algorithms.array;

import junit.framework.TestCase;

public class C4_32_PairSumKTest extends TestCase {
    Integer[] a = new Integer[] {4,2,11,5,7,15,1};

    public void testFindPair() throws Exception {
        Pair p = C4_32_PairSumK.findPair(a, 18);
        assertNotNull(p);
        assertTrue(p.i == 11 || p.j == 11);
        assertTrue(p.i == 7 || p.j == 7);
    }

    public void testNotFindPair(){
        Pair p = C4_32_PairSumK.findPair(a, 10);
        assertNull(p);

        p = C4_32_PairSumK.findPair(a, 40);
        assertNull(p);
    }
}