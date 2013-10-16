package com.interview.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

/***
 * Problem: Find a (general) cycle that uses every edge exactly once.
 * @author chenting
 *
 */
public class EulerianTour {
	
	private List<Integer> visited = new ArrayList<Integer>();
	
	public boolean eulerianCheck(Graph g, Integer start){
		return true;
	}
	
	
	
	public static void main(String[] args){
		Graph g = new AdjListGraph();
		g.type = Graph.UNDIRECTED;
		g.addEdge(new Vertex(0), new Vertex(1));
		g.addEdge(new Vertex(0), new Vertex(2));
		g.addEdge(new Vertex(0), new Vertex(5));
		g.addEdge(new Vertex(0), new Vertex(6));
		g.addEdge(new Vertex(1), new Vertex(2));
		g.addEdge(new Vertex(2), new Vertex(3));
		g.addEdge(new Vertex(2), new Vertex(4));
		g.addEdge(new Vertex(3), new Vertex(4));
		g.addEdge(new Vertex(4), new Vertex(5));
		g.addEdge(new Vertex(4), new Vertex(6));
	}
}
