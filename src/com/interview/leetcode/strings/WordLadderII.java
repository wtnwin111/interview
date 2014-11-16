package com.interview.leetcode.strings;

import java.util.*;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午5:31
 */
public class WordLadderII {
    class Node{
        String val;
        int no;
        List<Node> prev = new ArrayList<>();

        Node(int no, String val) {
            this.val = val;
            this.no = no;
        }

        void addPrev(Node pre){
            prev.add(pre);
        }

    }
    List<List<String>> answer;

    public void findPath(Node node, ArrayList<String> cur, String start) {
        if (node.val.equals(start)) {
            answer.add(cur);
            return;
        }
        ArrayList<String> temp;
        for (Node n : node.prev) {
            temp = new ArrayList<String>(cur);
            temp.add(0, n.val);
            findPath(n, temp, start);
        }
    }

    public List<List<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, Node> map = new HashMap<String, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        Node node = new Node(0, start);
        Node endNode = null;
        map.put(start, node);
        queue.add(node);
        boolean stop = false;
        while (queue.size() > 0 && !stop) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                node = queue.poll();
                for (int j = 0; j < node.val.length(); j++) {
                    StringBuilder t = new StringBuilder(node.val);
                    for (char k = 'a'; k <= 'z'; k++) {
                        t.setCharAt(j, k);
                        if (dict.contains(t.toString())) {
                            Node v = map.get(t.toString());
                            if (v == null) {
                                Node temp = new Node(node.no + 1, t.toString());
                                temp.addPrev(node);
                                queue.add(temp);
                                map.put(t.toString(), temp);
                                if (t.toString().equals(end)) {
                                    endNode = temp;
                                    stop = true;
                                }
                            }
                            else {
                                if (v.no == node.no + 1) {
                                    v.addPrev(node);
                                }
                            }
                        }
                    }
                }
            }
        }
        answer = new ArrayList<List<String>>();
        if (endNode != null) {
            findPath(endNode, new ArrayList<String>(Arrays.asList(end)), start);
        }
        return answer;
    }
}
