package com.interview.leetcode.strings;

import com.interview.leetcode.dp.RegularExpressionMatching;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午10:41
 */
public class RegularExpressionMatchingTest extends TestCase {
    public void testIsMatch() throws Exception {
        assertTrue(RegularExpressionMatching.isMatch("aa", "aa"));
        assertTrue(RegularExpressionMatching.isMatch("a", "a*"));
        assertTrue(RegularExpressionMatching.isMatch("ab", "a."));
        assertTrue(RegularExpressionMatching.isMatch("ab", "a*b"));
        assertTrue(RegularExpressionMatching.isMatch("abc", "ac*bc"));
        assertTrue(RegularExpressionMatching.isMatch("abc", "d*a*b*c"));
        assertTrue(RegularExpressionMatching.isMatch("abc", "a*b*c"));
        assertFalse(RegularExpressionMatching.isMatch("abc", "a*b"));
        assertFalse(RegularExpressionMatching.isMatch("abc", "a.b"));
        assertFalse(RegularExpressionMatching.isMatch("abc", "ab"));


    }
}
