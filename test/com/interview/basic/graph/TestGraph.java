package com.interview.basic.graph;

import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;
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
		//Graph g = TestUtil.generateGraph(10, 20, false);
		ConnectedComponent cc = new ConnectedComponent(g);
		cc.find();
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
			public void process(int v) {
				System.out.print(v + "-");
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
