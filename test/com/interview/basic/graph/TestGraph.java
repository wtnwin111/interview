package com.interview.basic.graph;

import org.junit.BeforeClass;
import org.junit.Test;

import com.interview.basic.graph.model.Graph;
import com.interview.basic.graph.model.Processor;
import com.interview.util.TestUtil;

public class TestGraph {
	public static Graph g;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = TestUtil.generateGraph(10, 30, false);
		g.print();
	}
	
	@Test
	public void testDFSearcher(){
		int s = TestUtil.generateInt(g.V - 1);
		DFSearcher searcher = new DFSearcher(g, new Processor(){
			@Override
			public void process(int v) {
				System.out.print(v + "-");
			}
		});
		System.out.print("DFSearch of " + s + ": \t");
		searcher.dfs(s);
		System.out.println();
		int v = TestUtil.generateInt(g.V - 1);;
		while(v == s){
			v = TestUtil.generateInt(g.V - 1);
		}
		searcher.setProcessor(null);
		System.out.printf("Path of %d to %d: \t", s, v);
		String path = searcher.path(s, v);
		System.out.println(path);
	}
	
}
