package com.interview.algorithms.geometry;

/**
 * Created_By: zouzhile
 * Date: 1/16/15
 * Time: 3:26 PM
 */
public class C18_5_PointLocationDetection {

    public String detect(int[] x, int[] y, int testX, int testY) {
        int size = x.length - 1;

        Segment testSegment = new Segment(new int[]{testX, testY + 1000}, new int[]{testX, testY - 1000});
        int cuts = 0;
        for(int current = 1; current <= size; current ++) {
            current %= size;
            int previous = (current - 1) % size;

            Segment border = new Segment(new int[] {x[current], y[current]}, new int[]{x[previous], y[previous]});
            if(GeoUtil.isPointOnSegment(border, testX, testY)) return "border";
            else if (GeoUtil.getSegmentIntersection(testSegment, border) != null) cuts ++;
        }

        return cuts % 2 == 0 ? "exterior" : "interior";
    }
}
