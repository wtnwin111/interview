package com.interview.flag.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 15-1-28
 * Time: 下午10:02
 */
public class F12_MinimunWindowSubstringWithOrder {
    public String minSubstring(String str, String pattern){
        if(str == null || str.length() == 0) return str;
        if(pattern == null || pattern.length() == 0 || pattern.length() > str.length()) return "";

        String minSubstring = "";

        HashMap<Character, List<Integer>> indexes = new HashMap();
        for(int i = 0; i < pattern.length(); i++) indexes.put(pattern.charAt(i), new ArrayList());

        int[] currentIndex = new int[pattern.length()];
        int idx = 0;

        for(int i = 0; i < str.length(); i++){
            if(idx < pattern.length() && str.charAt(i) == pattern.charAt(idx)) { //haven't found all the chars
                    currentIndex[idx] = i;
                    idx++;
            }
            if (indexes.containsKey(str.charAt(i)))  {
                indexes.get(str.charAt(i)).add(i);

                if(idx == pattern.length()){    //found all the chars, and start to shrink
                    //shrink from the end to begin, shrink the index to higher if its value smaller than the index of all chars in its right to keep the order.
                    for(int j = pattern.length() - 1; j >= 0; j--){
                        List<Integer> pos = indexes.get(pattern.charAt(j));
                        for(int p = pos.size() - 1; p >= 0 && pos.get(p) > currentIndex[j]; p--){
                            boolean smaller = true;
                            for(int k = j + 1; k < pattern.length(); k++){  //all the char in the right
                                if(pos.get(p) >= currentIndex[k]) {
                                    smaller = false;
                                    break;
                                }
                            }
                            if(smaller) {     //do shrink
                                currentIndex[j] = pos.get(p);
                                break;
                            }
                        }
                    }
                    int end = currentIndex[pattern.length() - 1];
                    int begin = currentIndex[0];
                    if(minSubstring.length() == 0 || end - begin + 1 < minSubstring.length())
                        minSubstring = str.substring(begin, end + 1);
                }
            }
        }
        return minSubstring;
    }

    public static void main(String[] args){
        F12_MinimunWindowSubstringWithOrder finder = new F12_MinimunWindowSubstringWithOrder();
        System.out.println(finder.minSubstring("UAXXBAUB", "AB")); //AUB
        System.out.println(finder.minSubstring("UAXSSXSXAAUB", "XXA")); //XSXA
    }

}
