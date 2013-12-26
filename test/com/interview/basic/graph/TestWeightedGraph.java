package com.interview.basic.graph;

import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.basic.graph.model.WeightedGraph;
import com.interview.basic.graph.model.WeightedGraph.Edge;
import com.interview.basic.graph.questions.mst.KruskalMSTSolver;
import com.interview.basic.graph.questions.mst.MSTSolver;
import com.interview.basic.graph.questions.mst.PrimMSTSolver;
import com.interview.util.TestUtil;

public class TestWeightedGraph {
	static WeightedGraph g;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = TestUtil.generateWeightedGraph(10, 15, false);
		g.print();
	}
	
	@Test
	public void testSortEdge(){
		WeightedGraph g = TestUtil.generateWeightedGraph(10, 10, false);
		Iterable<Edge> edges = g.getSortedEdge(true);
		for(Edge edge : edges){
			edge.print();
			System.out.println();
		}
	}
	
	@Test
	public void testKruskalMSTSolver(){
		MSTSolver solver = new KruskalMSTSolver(g);
		System.out.println("Test KruskalMSTSolver");
		testMSTSolver(solver);
	}
	
	@Test
	public void testPrimMSTSolver(){
		MSTSolver solver = new PrimMSTSolver(g);
		System.out.println("Test PrimMSTSolver");
		testMSTSolver(solver);
	}
	
	public void testMSTSolver(MSTSolver solver){
		solver.solve();
		System.out.println("Print the MST: ");
		Iterable<Edge> edges = solver.getMST();
		for(Edge edge : edges){
			edge.print();
			System.out.println();
		}
		System.out.printf("Weight of the MST is: %.3f\n", solver.weight());
	}
}
