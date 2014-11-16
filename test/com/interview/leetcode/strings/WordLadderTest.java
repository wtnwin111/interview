package com.interview.leetcode.strings;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午4:11
 */
public class WordLadderTest extends TestCase {
    static HashSet<String> dict = new HashSet<String>();
    static {
        String[] dicts = new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
        for(String str : dicts) dict.add(str);
    }
    public void testMinLength(){
        WordLadder ladder = new WordLadder();
        int length = ladder.minLength("red", "tax", dict);
        assertEquals(4, length);
    }
    public void testFindLadders() throws Exception {
        WordLadderII ladder = new WordLadderII();
        List<List<String>> paths = ladder.findLadders("red", "tax", dict);
        ConsoleWriter.printStringList(paths);
        assertEquals(3, paths.size());
    }
}
