package com.interview.algorithms.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

public class C6_5_WeightedShortestPathSolverTest extends TestCase {

    @Test
    public void testWeightedShortestPathSolver(){
        WeightedGraph g = TestUtil.generateWeightedGraph(10, 30, true);
        g.print();
        C6_5_WeightedShortestPathSolver solver = new C6_5_WeightedShortestPathSolver(g);
        int s = TestUtil.generateInt(g.V - 1);
        solver.solve(s);
        for(int i = 0; i < g.V; i++){
            System.out.printf("Shortest Path of %d to %d\n", s, i);
            boolean hasPath = solver.hasPathTo(i);
            if(hasPath){
                double weight = solver.distTo(i);
                for(WeightedGraph.Edge edge : solver.pathTo(i)){
                    edge.print();
                }
                System.out.printf("Step is: %.3f\n", weight);
            }
        }
    }

}