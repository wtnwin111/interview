package com.interview.algorithms.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.basics.model.graph.searcher.ASearcher;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/12/14
 * Time: 11:12 AM
 */
public class C6_5_ShortestPath_ASearch extends ASearcher {

    public C6_5_ShortestPath_ASearch(WeightedGraph graph) {
        super(graph);
    }

    @Override
    protected double heuristicEstimateDistance(int c, int t) {
        return 0;
    }
}
