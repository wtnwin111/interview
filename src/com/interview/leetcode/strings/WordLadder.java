package com.interview.leetcode.strings;

import java.util.*;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午3:20
 *
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end,
 * Only one letter can be changed at a time, and each intermediate word must exist in the dictionary
 * For example,
 * Given:   start = "hit"   end = "cog"  dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * WordLadderI is to return the min ladder number
 * WordLadderII is to return the path of all the min ladder solution
 *
 * Solution:
 *  1. both are use BSF on word graph
 *  2. WordLadderII use a prev link to store the path.
 */
public class WordLadder {

    static class WordLadderI {
        Set<String> dict;
        Set<String> visited;
        Queue<String> queue;
        String end;

        public int length(String start, String end, Set<String> dict) {
            if(start.equals(end)) return 1;
            //INIT
            this.dict = dict;
            this.end = end;
            visited = new HashSet<String>();
            queue = new LinkedList<String>();

            queue.offer(start);
            visited.add(start);

            int steps = 1;
            //DO BFS
            while(queue.size() > 0){
                int size = queue.size();
                for(int k = 0; k < size; k++){  //visit every layer
                    String word = queue.poll();
                    if(populate(word)) return steps + 1;
                }
                steps++;
            }
            return 0;
        }

        public boolean populate(String word){
            char[] chars = word.toCharArray();
            for(int i = 0; i < chars.length; i++){
                char orignal = chars[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    if(ch == orignal) continue;
                    chars[i] = ch;
                    String next = String.valueOf(chars);
                    if(next.equals(end)) return true;
                    if(dict.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
                chars[i] = orignal;
            }
            return false;
        }
    }

    static class WordLadderII {
        class Node {
            public String val;
            public int no;
            public List<Node> prev = new ArrayList<>();

            Node(int no, String val) {
                this.val = val;
                this.no = no;
            }
        }

        List<List<String>> answer;
        HashSet<String> dict;
        Queue<Node> queue;
        HashMap<String, Node> map;
        String end;

        public List<List<String>> findLadders(String start, String end, HashSet<String> dict) {
            this.dict = dict;
            this.end = end;
            map = new HashMap<String, Node>();
            queue = new LinkedList<Node>();

            Node node = new Node(0, start);
            map.put(start, node);
            queue.add(node);
            boolean stop = false;
            while (queue.size() > 0 && !stop) {
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    node = queue.poll();
                    if(populate(node)) stop = true;
                }
            }
            answer = new ArrayList<List<String>>();
            if (stop) {
                findPath(map.get(end), new ArrayList<String>(Arrays.asList(end)), start);
            }
            return answer;
        }

        public boolean populate(Node node){
            for (int j = 0; j < node.val.length(); j++) {
                StringBuilder t = new StringBuilder(node.val);
                for (char k = 'a'; k <= 'z'; k++) {
                    t.setCharAt(j, k);
                    if (dict.contains(t.toString())) {
                        Node v = map.get(t.toString());
                        if (v == null) {
                            Node temp = new Node(node.no + 1, t.toString());
                            temp.prev.add(node);
                            queue.add(temp);
                            map.put(t.toString(), temp);
                            if (t.toString().equals(end)) {
                                return true;
                            }
                        } else {
                            if (v.no == node.no + 1) {
                                v.prev.add(node);
                            }
                        }
                    }
                }
            }
            return false;
        }

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
    }

}
