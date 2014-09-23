package com.interview.algorithms.general;

import com.interview.util.TestUtil;
import junit.framework.TestCase;

public class C1_62_ClosestTwoPointsTest extends TestCase {

    public void testcase(){
        Point[] points = new Point[10];
        for(int i = 0; i < 10; i++){
            int x = TestUtil.generateInt(100);
            int y = TestUtil.generateInt(10);
            points[i] = new Point(x, y);
            System.out.println(points[i].toString());
        }


        Point[] expected = C1_62_ClosestTwoPoints.correct(points);
        System.out.println("Expected Answer");
        System.out.println(expected[0].toString());
        System.out.println(expected[1].toString());
        System.out.println(C1_62_ClosestTwoPoints.distanceCount);


        C1_62_ClosestTwoPoints.distanceCount = 0;
        Point[] closest = C1_62_ClosestTwoPoints.closest(points);
        System.out.println("Find Answer");
        System.out.println(closest[0].toString());
        System.out.println(closest[1].toString());
        System.out.println(C1_62_ClosestTwoPoints.distanceCount);
    }

}