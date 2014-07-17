package com.interview.algorithms.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.util.TestUtil;
import junit.framework.TestCase;
import org.junit.Test;

public class C6_3_MSTSolverTest extends TestCase {
    WeightedGraph g = TestUtil.generateWeightedGraph(10, 15, false);

    @Test
    public void testKruskalMSTSolver(){
        g.print();
        C6_3_MSTSolver solver = new C6_3_KruskalMSTSolver(g);
        System.out.println("Test KruskalMSTSolver");
        testMSTSolver(solver);
    }


    @Test
    public void testPrimMSTSolver(){
        g.print();
        C6_3_MSTSolver solver = new C6_3_PrimMSTSolver(g);
        System.out.println("Test PrimMSTSolver");
        testMSTSolver(solver);
    }

    public void testMSTSolver(C6_3_MSTSolver solver){
        solver.solve();
        System.out.println("Print the MST: ");
        Iterable<WeightedGraph.Edge> edges = solver.getMST();
        for(WeightedGraph.Edge edge : edges){
            edge.print();
            System.out.println();
        }
        System.out.printf("Weight of the MST is: %.3f\n", solver.weight());
    }

}