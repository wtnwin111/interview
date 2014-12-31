package com.interview.flag.g;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-27
 * Time: 下午2:58
 */

/**
 * Given an array of non-negative integers, each element is the max jump length at that position,
 * You can jump both to the left and right.
 * Find out which elements can jump to A[0]
 */
public class G6_JumpGame {

    boolean[] reachable;
    boolean[] visited;
    public List<Integer> jumpToZero(int[] A){
        reachable = new boolean[A.length];
        visited = new boolean[A.length];

        List<Integer> reachableNodes = new ArrayList<>();
        for(int i = 1; i < A.length; i++){
            if(!visited[i]) dfs(A, i);
            if(reachable[i]) reachableNodes.add(i);
        }

        return reachableNodes;
    }

    public boolean dfs(int[] A, int node){
        if(visited[node] == true) return reachable[node];
        visited[node] = true;
        if((node - A[node] == 0)
                || node - A[node] > 0 && dfs(A, node - A[node])
                || node + A[node] < A.length && dfs(A, node + A[node])){
            reachable[node] = true;
        }
        return reachable[node];
    }
}
