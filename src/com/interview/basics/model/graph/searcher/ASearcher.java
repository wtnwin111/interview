package com.interview.basics.model.graph.searcher;

import com.interview.basics.model.collection.Heap;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/12/14
 * Time: 1:50 PM
 */

public abstract class ASearcher<T, S extends ASearcher.State<T>, Input> {
    public interface State<T> {
        public int index();
        public T key();
    }

    protected class Candidate implements Comparable<Candidate>{
        public S state;
        public double cost;

        @Override
        public int compareTo(Candidate candidate) {
            if(this.cost > candidate.cost) return 1;
            else if(this.cost == candidate.cost) return 0;
            else return -1;
        }

        Candidate(S state, double cost) {
            this.state = state;
            this.cost = cost;
        }
    }

    public class Path{
        public Iterable<T> path;
        public double weight;

        public Path(Iterable<T> path, double weight) {
            this.path = path;
            this.weight = weight;
        }
    }

    public int stateNumber = 5000;
    protected Input input;
    protected double[] gScore;
    protected double[] hScore;
    protected Map<T, S> previous;

    public ASearcher(Input input){
        this.input = input;
    }

    private void prepare(){
        this.gScore = new double[stateNumber];
        this.hScore = new double[stateNumber];
        this.previous = new HashMap<T, S>();
    }

    private double fScore(State c){
        int index = c.index();
        return gScore[index] + hScore[index];
    }

    protected abstract double heuristicEstimateDistance(S c, S t);
    protected abstract boolean isSame(S s, S t);
    protected abstract S[] nextState(S s);
    protected abstract double gScore(Candidate c, S t);

    public Path pathTo(S s, S t){
        Stack<T> path = new Stack<T>();
        if(s.key().equals(t.key())) return new Path(path, 0.0);
        double weight = search(s, t);
        if(weight != -1){
            for(S state = t; state != null && !state.equals(s); state = previous.get(state.key())){
                path.push(state.key());
            }
        }
        return new Path(path, weight);
    }

    public double search(S s, S t){
        prepare();
        Set<State> close = new HashSet<State>();
        Heap<Candidate> open = new Heap<Candidate>(Heap.MIN_HEAD);
        open.add(new Candidate(s, fScore(s)));

        while(open.size() != 0){
            Candidate c = open.pollHead();
            if(isSame(c.state, t))   return c.cost;
            if(!close.contains(c.state)){
                close.add(c.state);
                S[] nextStates = nextState(c.state);
                if(nextStates == null) continue;
                for(int i = 0; i < nextStates.length; i++){
                    S e = nextStates[i];
                    double ten = gScore(c, e);
                    if(gScore[e.index()] == 0 || gScore[e.index()] > ten){
                        gScore[e.index()] = ten;
                        previous.put(e.key(), c.state);
                        hScore[e.index()] = heuristicEstimateDistance(e, t);
                        Candidate nc = new Candidate(e, fScore(e));
                        open.add(nc);
                    }
                }
            }
        }
        return -1;
    }
}
