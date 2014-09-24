package com.interview.basics.search.array;

import com.interview.utils.models.Range;
import junit.framework.TestCase;

public class IntervalBSTSearcherTest extends TestCase {

    public void testSearch() throws Exception {
        Range[] ranges = new Range[]{new Range(2,4), new Range(1,6), new Range(5,13)};
        IntervalBSTSearcher searcher = new IntervalBSTSearcher(ranges);
        Range item = new Range(2,5);
        int index = searcher.search(item);
        assertEquals(1, index);

        item = new Range(5,17);
        index = searcher.search(item);
        assertEquals(-1, index);

        item = new Range(4,7);
        index = searcher.search(item);
        assertEquals(-1, index);

        item = new Range(2,3);
        index = searcher.search(item);
        assertEquals(0, index);

        item = new Range(8,12);
        index = searcher.search(item);
        assertEquals(2, index);
    }
}