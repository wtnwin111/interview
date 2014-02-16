package com.interview.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created_By: zouzhile
 * Date: 2/13/14
 * Time: 3:49 PM
 *
 * A vocabulary searcher that searches what vocabularies (phrases/terms)
 * in a vocabulary graph are contained in a given piece of text.
 */

public class VocabularySearcher {

    /**
     *
     * @param text
     * @param graph
     * @param shingleSizeLimit the maximum amount of terms in product names indicating the shingle size.
     *                         Usually, this should be smaller than 20.
     * @return
     */
    public static HashSet<String> search(String text, VocabularyGraph graph, int shingleSizeLimit) {
        HashSet<String> vocabularies = new HashSet<String>();

        // find the entries
        String[] terms = text.split("\\s+");
        HashMap<String, List<Integer>> offsets = new HashMap<String, List<Integer>>();
        for(int i = 0; i < terms.length; i++) {
            String term = terms[i];
            List<Integer> termOffsets = offsets.get(term);
            if(termOffsets == null)
                termOffsets = new ArrayList<Integer>();
            termOffsets.add(i);
            offsets.put(term, termOffsets);
        }

        HashSet<VocabularyGraphVertex> entries = graph.getEntryVertexByTerms(terms);
        for(VocabularyGraphVertex entry : entries) {
            String term = entry.getTerm();
            for(int i : offsets.get(term)){
                // for each occurrence of the term, build the longest shingle, and search prefixes in corpus
                String shingle = getLongestShingle(terms, i, shingleSizeLimit);
                HashSet<String> phrases = graph.getPrefixesInCorpus(shingle);
                vocabularies.addAll(phrases);
            }
        }

        return vocabularies;
    }

    private static String getLongestShingle(String[] terms, int from, int termsCount) {
        StringBuffer result = new StringBuffer();
        for(int i = from, count = 0; i < terms.length && count < termsCount; i ++, count ++) {
            result.append(terms[i] + " ");
        }
        return result.toString().trim();
    }
}
