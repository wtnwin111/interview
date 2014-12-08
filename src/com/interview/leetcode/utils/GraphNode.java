package com.interview.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-23
 * Time: 下午1:40
 */
public class GraphNode {
    public int label;
    public List<GraphNode> neighbors;

    public GraphNode(int x) {
        label = x;
        neighbors = new ArrayList<GraphNode>();
    }
}
