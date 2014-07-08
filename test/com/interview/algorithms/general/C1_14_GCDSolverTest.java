package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_14_GCDSolverTest extends TestCase {
    public void testcase1(){
        int gcd = C1_14_GCDSolver.gcd(56, 24);
        assertEquals(8, gcd);
    }

    public void testcase2(){
        int gcd = C1_14_GCDSolver.gcd(3, 7);
        assertEquals(1, gcd);
    }

}