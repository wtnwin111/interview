package com.interview.algorithms.dp;

import com.interview.datastructures.graph.weighted.Graph;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 3/17/14
 * Time: 5:34 PM
 */
public class C12_4_GraphShortestPathTest {

    @Test
    public void testFindShortestPath(){
        Graph graph = Graph.buildSampleGraph(false);
        C12_4_GraphShortestPath test = new C12_4_GraphShortestPath();
        C12_4_GraphShortestPath.State result = test.findShortestPath(graph, "A", "E");

        Assert.assertEquals(result.weight, 8);

        Assert.assertEquals(result.path.get(0), "A");
        Assert.assertEquals(result.path.get(1), "B");
        Assert.assertEquals(result.path.get(2), "E");
    }
}
