package com.interview.algorithms.general;

import com.interview.utils.models.Range;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/24/14
 * Time: 3:50 PM
 */
public class C1_63_RangeCheck {
    public static boolean cover(Range source, Range[] target){
        Arrays.sort(target, new Comparator<Range>() {
            @Override
            public int compare(Range o1, Range o2) {
                if(o1.start < o2.start) return -1;
                else if(o1.start > o2.start) return 1;
                else return 0;
            }
        });

        int cur = 0;
        for(int i = 1; i < target.length; i++){
            if(target[i].start <= target[cur].end && target[i].end > target[cur].end)
                target[cur].end = target[i].end;
            else cur = i;
        }

        cur = 0;
        for(int i = 0; i < target.length; i++){
            if(i == 0 || target[i].end > target[cur].end)
                if(cover(source, target[i])) return true;
            else cur = i;
        }
        return false;
    }

    private static boolean cover(Range s, Range t){
        return (t.start <= s.start && t.end >= s.end);
    }
}
