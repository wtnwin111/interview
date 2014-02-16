package com.interview.algorithms.graph;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Created_By: zouzhile
 * Date: 2/13/14
 * Time: 11:04 AM
 *
 * The term of the vertex is not case sensitive, i.e. Calvin and calvin points to the same vertex
 */
class VocabularyGraphVertex implements Serializable {
    private Long id;
    private String term;
    private boolean isEntry = false;
    private HashSet<VocabularyGraphVertex> outgoingTargets = new HashSet<VocabularyGraphVertex>();

    VocabularyGraphVertex(String term, boolean isEntry) {
        this.term = term.trim().toLowerCase();
        this.isEntry = isEntry;
        this.id = generateID(this.term);
    }

    public boolean isEntryVertex(){
        return this.isEntry;
    }

    /**
     *
     * @return  true if the vertex represents the last term of at least one corpus phrase
     */
    public boolean isEndingVertex() {
        VocabularyGraphVertex terminator = new VocabularyGraphVertex(VocabularyGraph.TERMINATION_TERM, false);
        return this.outgoingTargets.contains(terminator);
    }

    void changeIntoEntryVertex() {
        this.isEntry = true;
    }

    public Long getID() {
        return this.id;
    }

    public String getTerm() {
        return this.term;
    }

    public void addOutgoingTarget(VocabularyGraphVertex target) {
        if(target == null || this.equals(target))
            return;
        this.outgoingTargets.add(target);
    }

    public HashSet<VocabularyGraphVertex> getOutgoingTargets() {
        return this.outgoingTargets;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || ! (obj instanceof VocabularyGraphVertex))
            return false;
        boolean result = this.getID().longValue() == ((VocabularyGraphVertex)obj).getID().longValue();
        return result;
    }

    public static long generateID(String term){
        return term.trim().toLowerCase().hashCode();
    }

    @Override
    public int hashCode(){
        return this.term.hashCode();
    }

}
