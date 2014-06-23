package com.interview.datastructures.graph;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.datastructures.graph.model.BFSearcher;
import com.interview.datastructures.graph.model.DFSearcher;
import com.interview.datastructures.graph.model.Graph;
import com.interview.datastructures.graph.model.Processor;
import com.interview.datastructures.graph.model.Searcher;
import com.interview.datastructures.graph.questions.ConnectedComponent;
import com.interview.datastructures.graph.questions.CycleFinder;
import com.interview.datastructures.graph.questions.ShortestPathSolver;
import com.interview.datastructures.graph.questions.TopologicalSorter;
import com.interview.datastructures.graph.questions.bipartite.BiPartiteGraph;
import com.interview.datastructures.graph.questions.bipartite.BiPartiteGraphBFS;
import com.interview.datastructures.graph.questions.bipartite.BiPartiteGraphDFS;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;

public class TestGraph {
	public static Graph g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = TestUtil.generateGraph(10, 30, true);
		g.print();
	}
	
	@Test
	public void testDFSearcher(){
		DFSearcher searcher = new DFSearcher(g);
		testSearcher(searcher);
	}
	
	@Test
	public void testBFSearcher(){
		BFSearcher searcher = new BFSearcher(g);
		testSearcher(searcher);
	}
	
	@Test
	public void testConnectedComponent(){
		testConnectedComponent(g);
		
		Graph g = TestUtil.generateGraph(10, 15, true);
		g.print();
		testConnectedComponent(g);
	}
	
	@Test
	public void testBiPartiteGraphDFS(){
		BiPartiteGraphDFS bpg = new BiPartiteGraphDFS(g);
		testBiParitionGraph(bpg, g);
		
		Graph g = TestUtil.generateBiPartitionGraph();
		g.print();
		bpg = new BiPartiteGraphDFS(g);
		testBiParitionGraph(bpg, g);
	}
	
	@Test
	public void testBiPartiteGraphBFS(){
		BiPartiteGraphBFS bpg = new BiPartiteGraphBFS(g);
		testBiParitionGraph(bpg, g);
		
		Graph g = TestUtil.generateBiPartitionGraph();
		g.print();
		bpg = new BiPartiteGraphBFS(g);
		testBiParitionGraph(bpg, g);
	}
	
	@Test
	public void testCycleFinder(){
		CycleFinder finder = new CycleFinder(g);
		finder.solve();
		System.out.println("Find a cycle: " +  finder.getCycle());
		
		Graph g = TestUtil.generateGraph(10, 15, true);
		g.adj[0] = new HashSet<Integer>();
		g.print();
		finder = new CycleFinder(g);
		finder.solve();
		System.out.println("Find a cycle: " +  finder.getCycle());
		
		g = TestUtil.generateDAGGraph();
		g.print();
		finder = new CycleFinder(g);
		finder.solve();
		System.out.println("Find a cycle: " +  finder.getCycle());
	}
	
	@Test
	public void testTopologicalSort(){
		testTopologicalSort(g);
		
		Graph g = TestUtil.generateDAGGraph();
		g.print();
		testTopologicalSort(g);
	}
	
	@Test
	public void testGetShortestPath(){
		ShortestPathSolver solver = new ShortestPathSolver(g);
		int s = TestUtil.generateInt(g.V - 1);
		int t = TestUtil.generateInt(g.V - 1);;
		while(t == s){
			t = TestUtil.generateInt(g.V - 1);
		}
		solver.solve(s, t);
		System.out.printf("Shortest Path of %d to %d: %s\t, Step is: %d", s, t, solver.getPath(), solver.getStep());
		System.out.println();
	}
	
	public void testTopologicalSort(Graph g){
		TopologicalSorter sorter = new TopologicalSorter(g);
		boolean canSort = sorter.canSort();
		System.out.println("Can do topological sort: " +  canSort);
		if(canSort){
			sorter.solve();
			System.out.println("Topological sort: " +  sorter.getOrder());
		} else {
			System.out.println("Find a cycle: " + sorter.why());
		}
	}
	
	public void testBiParitionGraph(BiPartiteGraph bpg, Graph g){
		bpg.solve();
		boolean isPartition = bpg.isBiPartite();
		System.out.println("Is a graph bipartite? " +  isPartition);
		if(isPartition){
			Set<Integer>[] partition = bpg.getBiPartite();
			for(int i = 0; i < 2; i++){
				System.out.print(i + "th Partition is: ");
				ConsoleWriter.printIntSet(partition[i]);
			}
		}
	}
	
	public void testConnectedComponent(Graph g){
		//Graph g = TestUtil.generateGraph(10, 20, false);
		ConnectedComponent cc = new ConnectedComponent(g);
		cc.solve();
		System.out.println("Find " + cc.count + " Connected Components.");
		for(int i = 1; i <= cc.count; i++){
			System.out.print(i + "th Connected Components: ");
			ConsoleWriter.printIntSet(cc.components[i]);
		}
	}
	
	public void testSearcher(Searcher searcher){
		int s = TestUtil.generateInt(g.V - 1);
		System.out.print("Search of " + s + ": \t");
		searcher.search(s, new Processor(){
			@Override
			public void preProcess(int v) {
				System.out.print(v + "-");
			}

			@Override
			public void postProcess(int v) {
				// TODO Auto-generated method stub
				
			}
		});
		System.out.println();
		int v = TestUtil.generateInt(g.V - 1);;
		while(v == s){
			v = TestUtil.generateInt(g.V - 1);
		}
		System.out.printf("Path of %d to %d: \t", s, v);
		String path = searcher.path(s, v);
		System.out.println(path);
	}
	
}
