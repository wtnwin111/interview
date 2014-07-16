package com.interview.datastructures.graph;

import com.interview.basics.model.graph.WeightedGraph;
import com.interview.basics.model.graph.WeightedGraph.Edge;
import com.interview.datastructures.graph.questions.WeightedShortestPathSolver;
import com.interview.datastructures.graph.questions.mst.KruskalMSTSolver;
import com.interview.datastructures.graph.questions.mst.MSTSolver;
import com.interview.datastructures.graph.questions.mst.PrimMSTSolver;
import com.interview.util.TestUtil;
import org.junit.BeforeClass;
import org.junit.Test;

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
	

	@Test
	public void testWeightedShortestPathSolver(){
		WeightedGraph g = TestUtil.generateWeightedGraph(10, 30, true);
		g.print();
		WeightedShortestPathSolver solver = new WeightedShortestPathSolver(g);
		int s = TestUtil.generateInt(g.V - 1);
		solver.solve(s);
		for(int i = 0; i < g.V; i++){
			System.out.printf("Shortest Path of %d to %d\n", s, i);
			boolean hasPath = solver.hasPathTo(i);
			if(hasPath){
				double weight = solver.distTo(i);
				for(Edge edge : solver.pathTo(i)){
					edge.print();
				}
				System.out.printf("Step is: %.3f\n", weight);
			}
		}
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
