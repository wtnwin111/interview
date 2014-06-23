package com.interview.algorithms.general;

import java.util.*;

/**
 * Created_By: stefanie
 * Date: 14-6-23
 * Time: 下午8:44
 *
 * Given a set of ranges, find the two ranges with the greatest overlap.
 */

class Range{
    int start;
    int end;

    public Range(int start, int end){
        this.start = start;
        this.end = end;
    }
}

class MaxOverlapRange{
    public Range r1;
    public Range r2;
    public int overlap = 0;
}

public class C1_10_GreatestOverlap {


    public static MaxOverlapRange getGreatestOverlap(List<Range> ranges) {
        Collections.sort(ranges, new Comparator<Range>() {
            @Override
            public int compare(Range range1, Range range2) {
                return range1.start > range2.start ? 1 : -1;
            }
        });


        Iterator<Range> rangesItr = ranges.iterator();
        // initialize result
        MaxOverlapRange maxOverlap = new MaxOverlapRange();
        Range current = rangesItr.next();
        while(rangesItr.hasNext()) {
            Range next = rangesItr.next();
            int overlap = getOveralap(current, next);
            if(overlap > maxOverlap.overlap) {
                maxOverlap.r1 = current;
                maxOverlap.r2 = next;
                maxOverlap.overlap = overlap;
            }
            if(next.end > current.end)
                current = next;
        }
        return maxOverlap;
    }

    private static int getOveralap(Range r1, Range r2) {
        if(r2.end <= r1.end)
            return r2.end - r2.start;

        if(r2.start >= r1.end)
            return 0;

        return r1.end - r2.start;
    }

}
