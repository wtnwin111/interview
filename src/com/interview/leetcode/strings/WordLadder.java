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
    static Integer PATH_WEIGHT = 10000;

    static class WordLadderI {
        class Word implements Comparable<Word> {
            String word;
            Integer steps;
            Integer score = 0;

            Word(String word, Integer steps, String target) {
                this.word = word;
                this.steps = steps;
                this.score = steps;
                int diff = 0;
                for (int i = 0; i < target.length(); i++) {
                    if (target.charAt(i) != word.charAt(i)) diff++;
                }
                this.score = PATH_WEIGHT * score + diff;
            }

            @Override
            public int compareTo(Word o) {
                return this.score - o.score;
            }
        }

        Set<String> dict;
        Queue<Word> queue;
        Set<String> visited;

        public int minLength(String start, String end, Set<String> dict) {
            if (start.equals(end)) return 0;
            this.dict = dict;
            visited = new HashSet<String>();
            queue = new PriorityQueue<>();   //for shortest, general Queue will work, since we already by layer visit
            queue.add(new Word(start, 1, end));
            while (!queue.isEmpty()) {
                Word w = queue.poll();
                char[] chars = w.word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char ch = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == ch) continue;
                        chars[i] = j;
                        String opt = String.valueOf(chars);
                        if (opt.equals(end)) return w.steps + 1;
                        if (!dict.contains(opt) || visited.contains(opt)) continue;
                        queue.add(new Word(opt, w.steps + 1, end));
                        visited.add(opt);
                    }
                    chars[i] = ch;
                }
            }
            return 0;
        }
    }

    static class WordLadderII {
        class Node {
            String val;
            int no;
            List<Node> prev = new ArrayList<>();

            Node(int no, String val) {
                this.val = val;
                this.no = no;
            }

            void addPrev(Node pre) {
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
                                } else {
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

}
