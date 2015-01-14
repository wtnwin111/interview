package com.interview.design.questions;

import com.interview.utils.ConsoleWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created_By: stefanie
 * Date: 15-1-14
 * Time: 上午9:34
 */
public class DZ22_Tries {
    //Space: O(26^L) L is the average length of words
    class TrieNode{
        boolean isWord = false;
        HashMap<Character, TrieNode> children = new HashMap();
    }
    TrieNode root = new TrieNode();

    //Time: O(L)    L is the length of the word
    public void add(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(current.children.containsKey(ch)){
                current = current.children.get(ch);
            } else {
                TrieNode node = new TrieNode();
                current.children.put(ch, node);
                current = node;
            }
        }
        current.isWord = true;
    }

    //Time: O(L)
    private TrieNode getNode(String str){
        TrieNode current = root;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(! current.children.containsKey(ch)) return null;
            current = current.children.get(ch);
        }
        return current;
    }

    //Time: O(L)
    public boolean isWord(String word){
        TrieNode node = getNode(word);
        return node != null && node.isWord;
    }

    //Time: O(L)
    public boolean isPrefix(String prefix){
        TrieNode node = getNode(prefix);
        return node != null;
    }
    //Time: O(M), M words having this prefix. M < 26^(the max length - prefix length)
    public List<String> words(String prefix){
        List<String> words = new ArrayList();
        TrieNode node = getNode(prefix);
        visit(node, prefix, words);
        return words;
    }

    private void visit(TrieNode node, String prefix, List<String> words){
        if(node == null) return;
        if(node.isWord) words.add(prefix);
        for(Map.Entry<Character, TrieNode> child : node.children.entrySet()){
            visit(child.getValue(), prefix + child.getKey(), words);
        }
    }

    public static void main(String[] args){
        DZ22_Tries tries = new DZ22_Tries();
        tries.add("English");
        tries.add("French");
        tries.add("Engineer");
        tries.add("Summer");

        System.out.println(tries.isWord("French"));  //true
        System.out.println(tries.isWord("Fre"));     //false
        System.out.println(tries.isWord("Frencha")); //false
        System.out.println(tries.isPrefix("Frech")); //false
        System.out.println(tries.isPrefix("Fre"));   //true
        List<String> words = tries.words("En");
        ConsoleWriter.printCollection(words);        //English, Engineer
        words = tries.words("Engl");
        ConsoleWriter.printCollection(words);        //English
    }
}
