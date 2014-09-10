package com.interview.algorithms.string;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 8/29/14
 * Time: 4:25 PM
 */
public class C11_25_StringSetCombine {
    public static List<Set<String>> combine(List<Set<String>> input) {
        for(int i = 0; i < input.size() - 1; i++){
            if(input.get()){

            }
        }
        return input;
    }
//    public static List<Set<String>> combine(List<Set<String>> input) {
//        Map<String, Set<Set<String>>> reverseIndex = new HashMap<String, Set<Set<String>>>();
//        boolean hasChange = true;
//        while (hasChange) {
//            hasChange = false;
//            for (Set<String> item : input) {
//                for (String str : item) {
//                    Set<Set<String>> index = reverseIndex.get(str);
//                    if (index == null) {
//                        index = new HashSet<>();
//                        reverseIndex.put(str, index);
//                    }
//                    index.add(item);
//                }
//            }
//            for (Set<Set<String>> entry : reverseIndex.values()) {
//                if (entry.size() < 1) continue;
//                Iterator<Set<String>> iterator = entry.iterator();
//                Set<String> base = iterator.next();
//                int base_size = base.size();
//                while (iterator.hasNext()) {
//                    Set<String> set = iterator.next();
//                    base.addAll(set);
//                    set.clear();
//                }
//                if(base.size() > base_size) hasChange = true;
//            }
//        }
//        return input;
//    }
}
