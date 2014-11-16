package com.interview.leetcode.strings;

import java.util.*;

/**
 * Created_By: stefanie
 * Date: 14-11-16
 * Time: 下午3:20
 */
public class WordLadder {
    static Integer PATH_WEIGHT = 10000;
    class Word implements Comparable<Word> {
        String word;
        Integer steps;
        Integer score = 0;

        Word(String word, Integer steps, String target) {
            this.word = word;
            this.steps = steps;
            this.score = steps;
            int diff = 0;
            for(int i = 0; i < target.length(); i++){
                if(target.charAt(i) != word.charAt(i)) diff++;
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
        while (!queue.isEmpty()){
            Word w = queue.poll();
            char[] chars = w.word.toCharArray();
            for(int i = 0; i < chars.length; i++){
                char ch = chars[i];
                for(char j = 'a'; j <= 'z'; j++){
                    if(j == ch) continue;
                    chars[i] = j;
                    String opt = String.valueOf(chars);
                    if(opt.equals(end)) return w.steps + 1;
                    if(!dict.contains(opt) || visited.contains(opt)) continue;
                    queue.add(new Word(opt, w.steps + 1, end));
                    visited.add(opt);
                }
                chars[i] = ch;
            }
        }
        return 0;
    }
}
