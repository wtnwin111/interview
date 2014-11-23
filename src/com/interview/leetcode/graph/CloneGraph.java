package com.interview.leetcode.graph;

import com.interview.leetcode.utils.UndirectedGraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created_By: stefanie
 * Date: 14-11-23
 * Time: 下午1:40
 */
public class CloneGraph {

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();

        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.add(node);
        nodeMap.put(node, new UndirectedGraphNode(node.label));  //make sure the node in stack have a copy in nodeMap

        //Do DFS
        while(stack.size() > 0){
            UndirectedGraphNode cur = stack.pop();
            UndirectedGraphNode clone = nodeMap.get(cur);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(nodeMap.containsKey(neighbor)){
                    clone.neighbors.add(nodeMap.get(neighbor));
                } else {
                    stack.push(neighbor); //neighbor haven't been visited
                    UndirectedGraphNode cloneneighbor = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor, cloneneighbor);
                    clone.neighbors.add(cloneneighbor);
                }
            }
        }
        return nodeMap.get(node);
    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        nodeMap.put(node, new UndirectedGraphNode(node.label));  //make sure the node in stack have a copy in nodeMap

        //Do DFS
        while(queue.size() > 0){
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode clone = nodeMap.get(cur);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(nodeMap.containsKey(neighbor)){
                    clone.neighbors.add(nodeMap.get(neighbor));
                } else {
                    queue.offer(neighbor); //neighbor haven't been visited
                    UndirectedGraphNode cloneneighbor = new UndirectedGraphNode(neighbor.label);
                    nodeMap.put(neighbor, cloneneighbor);
                    clone.neighbors.add(cloneneighbor);
                }
            }
        }
        return nodeMap.get(node);
    }



    //Recursively
    public UndirectedGraphNode cloneGraphDFSRecursively(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<>();
        return cloneDFS(node, nodeMap);
    }

    public UndirectedGraphNode cloneDFS(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> nodeMap){
        if(nodeMap.containsKey(node)) return nodeMap.get(node); //already cloned
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        nodeMap.put(node, clone);
        for(UndirectedGraphNode neighbor : node.neighbors){
            clone.neighbors.add(cloneDFS(neighbor, nodeMap));
        }
        return clone;
    }

}
