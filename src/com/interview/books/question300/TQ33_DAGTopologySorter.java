package com.interview.books.question300;

import com.interview.leetcode.utils.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-12-16
 * Time: 下午3:04
 */
public class TQ33_DAGTopologySorter {
    public List<GraphNode> sort(List<GraphNode> nodes){
        List<GraphNode> sorted = new ArrayList<GraphNode>();
        HashMap<GraphNode, Integer> indegree = new HashMap<>();
        for(GraphNode node : nodes){
            for(GraphNode neighbor : node.neighbors){
                if(indegree.containsKey(neighbor)) indegree.put(neighbor, indegree.get(neighbor) + 1);
                else indegree.put(neighbor, 1);
            }
        }
        //put 0-in-degree node at the beginning
        HashSet<GraphNode> visited = new HashSet<>();
        for(GraphNode node : nodes){
            if(!indegree.containsKey(node)) {
                sorted.add(node);
                visited.add(node);
            }
        }

        int index = 0;
        while(index < sorted.size()){
            GraphNode node = sorted.get(index++);
            for(GraphNode neighbor : node.neighbors){
                if(!visited.contains(neighbor)){
                    if(indegree.get(neighbor) == 1){
                        sorted.add(neighbor);
                        visited.add(neighbor);
                    } else {
                        indegree.put(neighbor, indegree.get(neighbor) - 1);
                    }
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args){
        TQ33_DAGTopologySorter sorter = new TQ33_DAGTopologySorter();
        List<GraphNode> nodes = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            nodes.add(new GraphNode(i));
        }

        nodes.get(1).neighbors.add(nodes.get(2));
        nodes.get(1).neighbors.add(nodes.get(4));
        nodes.get(2).neighbors.add(nodes.get(3));
        nodes.get(2).neighbors.add(nodes.get(5));
        nodes.get(3).neighbors.add(nodes.get(4));

        List<GraphNode> sorted = sorter.sort(nodes);
        for(int i = 0; i < sorted.size(); i++){
            System.out.println(sorted.get(i).label);
        }
    }
}
