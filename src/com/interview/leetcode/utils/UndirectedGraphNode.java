package com.interview.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-23
 * Time: 下午1:40
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
