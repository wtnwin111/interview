package com.interview.algorithms.stackqueue;

import com.interview.basics.model.collection.list.List;
import junit.framework.TestCase;

public class C7_6_HanoiUsingStackTest extends TestCase {

    public void test3Disk() throws Exception {
        List<Step> steps = C7_6_HanoiUsingStack.solve(3);
        assertEquals(7, steps.size());
    }

    public void test5Disk(){
        List<Step> steps = C7_6_HanoiUsingStack.solve(5);
        assertEquals(31, steps.size());
    }

}