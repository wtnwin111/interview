package com.interview.basics.model.graph.searcher;

import com.interview.basics.model.collection.Heap;
import com.interview.basics.model.graph.WeightedGraph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/12/14
 * Time: 1:50 PM
 */
public abstract class ASearcher {
    class Candidate implements Comparable<Candidate>{
        int id;
        double cost;

        @Override
        public int compareTo(Candidate candidate) {
            if(this.cost > candidate.cost) return 1;
            else if(this.cost == candidate.cost) return 0;
            else return -1;
        }

        Candidate(int id, double cost) {
            this.id = id;
            this.cost = cost;
        }
    }

    private WeightedGraph graph;
    private double[] gScore;
    private double[] hScore;
    private WeightedGraph.Edge[] edgeTo;

    public ASearcher(WeightedGraph graph){
        this.graph = graph;
    }

    private void prepare(){
        this.gScore = new double[graph.V];
        this.hScore = new double[graph.V];
        this.edgeTo = new WeightedGraph.Edge[graph.V];
    }

    private double fScore(int c){
        return gScore[c] + hScore[c];
    }

    protected abstract double heuristicEstimateDistance(int c, int t);

    public Iterable<WeightedGraph.Edge> pathTo(int s, int t){
        double weight = search(s, t);
        Stack<WeightedGraph.Edge> path = new Stack<WeightedGraph.Edge>();
        if(weight != -1){
            WeightedGraph.Edge edge;
            do{
                edge = edgeTo[t];
                path.push(edge);
                t = edge.s;
            } while(edge != null && edge.s != s);
        }
        return path;
    }

    public double search(int s, int t){
        prepare();
        Set<Integer> close = new HashSet<Integer>();
        Heap<Candidate> open = new Heap<Candidate>(Heap.MIN_HEAD);
        open.add(new Candidate(s, fScore(s)));

        while(open.size() != 0){
            Candidate c = open.pollHead();
            if(c.id == t)   return c.cost;
            if(!close.contains(c.id)){
                close.add(c.id);
                if(graph.adj[c.id] == null) continue;
                for(WeightedGraph.Edge e : graph.adj[c.id]){
                    double ten = gScore[c.id] + e.w;
                    if(gScore[e.t] == 0 || gScore[e.t] > ten){
                        gScore[e.t] = ten;
                        edgeTo[e.t] = e;
                        hScore[e.t] = heuristicEstimateDistance(e.t, t);
                        Candidate nc = new Candidate(e.t, fScore(e.t));
                        open.add(nc);
                    }
                }
            }
        }
        return -1;
    }
}
