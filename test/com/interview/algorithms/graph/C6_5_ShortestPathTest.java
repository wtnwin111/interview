package com.interview.algorithms.graph;

import com.interview.algorithms.graph.C6_5_ShortestPath;
import com.interview.basics.model.graph.generic.weighted.Graph;
import com.interview.basics.model.graph.generic.weighted.Vertex;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created_By: zouzhile
 * Date: 4/17/14
 * Time: 10:08 PM
 */
public class C6_5_ShortestPathTest {

    @Test
    public void testDijkstra() {
        C6_5_ShortestPath test = new C6_5_ShortestPath();
        Graph graph = Graph.buildSampleGraph(true);
        Vertex source = graph.getVertex("A");
        Vertex target = graph.getVertex("D");
        Assert.assertEquals(test.Dijkstra(graph, source, target), 14);

        target = graph.getVertex("E");
        Assert.assertEquals(test.Dijkstra(graph, source, target), 8);

        target = graph.getVertex("B");
        Assert.assertEquals(test.Dijkstra(graph, source, target), 2);
    }
}
