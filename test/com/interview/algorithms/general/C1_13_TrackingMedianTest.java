package com.interview.algorithms.general;

import junit.framework.TestCase;

public class C1_13_TrackingMedianTest extends TestCase {

    public void test() throws Exception {
        C1_13_TrackingMedian tracker = new C1_13_TrackingMedian();
        tracker.add(1);
        assertEquals(1, tracker.getMedian());

        tracker.add(10);
        assertEquals(1, tracker.getMedian());

        tracker.add(5);
        assertEquals(5, tracker.getMedian());

        tracker.add(2);
        tracker.add(3); //1,2,3,5,10
        assertEquals(3, tracker.getMedian());
    }
}