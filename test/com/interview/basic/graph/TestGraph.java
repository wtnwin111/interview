package com.interview.basic.graph;

import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;
import com.interview.basic.graph.questions.BiPartiteGraph;
import com.interview.basic.graph.questions.ConnectedComponent;
import com.interview.basic.graph.questions.CycleFinder;
import com.interview.util.TestUtil;
import com.interview.utils.ConsoleWriter;

public class TestGraph {
	public static Graph g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = TestUtil.generateGraph(10, 30, false);
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
		
		Graph g = TestUtil.generateGraph(10, 15, false);
		g.print();
		testConnectedComponent(g);
	}
	
	@Test
	public void testBiPartiteGraph(){
		testBiParitionGraph(g);
		
		Graph g = TestUtil.generateBiPartitionGraph();
		g.print();
		testBiParitionGraph(g);
	}
	
	@Test
	public void testCycleFinder(){
		CycleFinder finder = new CycleFinder(g);
		finder.solve();
		System.out.println("Find a cycle: " +  finder.getCycle());
		
		Graph g = TestUtil.generateGraph(10, 15, false);
		g.adj[0] = new HashSet<Integer>();;
		g.print();
		finder = new CycleFinder(g);
		finder.solve();
		System.out.println("Find a cycle: " +  finder.getCycle());
	}
	
	public void testBiParitionGraph(Graph g){
		BiPartiteGraph bpg = new BiPartiteGraph(g);
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
