package com.interview.leetcode.graph;

import com.interview.leetcode.utils.UndirectedGraphNode;

import java.util.*;

/**
 * Created_By: stefanie
 * Date: 14-11-23
 * Time: 下午2:28
 */
public class GraphTraverse {

    public void DFS(UndirectedGraphNode node) {
        if(node == null) return;
        HashSet<UndirectedGraphNode> visited = new HashSet<>();

        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.add(node);

        //Do DFS
        while(stack.size() > 0){
            UndirectedGraphNode cur = stack.pop();
            System.out.println(cur.label);
            visited.add(cur);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!visited.contains(neighbor)) {
                    stack.push(neighbor); //neighbor haven't been visited
                }
            }
        }
    }

    public void BFS(UndirectedGraphNode node) {
        if(node == null) return;
        HashSet<UndirectedGraphNode> visited = new HashSet<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        //Do BFS
        while(queue.size() > 0){
            UndirectedGraphNode cur = queue.poll();
            System.out.println(cur.label);
            visited.add(cur);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor); //neighbor haven't been visited
                }
            }
        }
    }
}
