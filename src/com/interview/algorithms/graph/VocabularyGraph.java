package com.interview.algorithms.graph;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created_By: zouzhile
 * Date: 2/13/14
 * Time: 10:57 AM
 *
 *
 */
public class VocabularyGraph {

    private boolean initialized = false;
    // the vertex that are entries of the graph
    private HashMap<Long, VocabularyGraphVertex> entries = new HashMap<Long, VocabularyGraphVertex>();
    // the vertex that non entries, i.e. internal and only reachable from entries or other non entry vertex.
    private HashMap<Long, VocabularyGraphVertex> internals = new HashMap<Long, VocabularyGraphVertex>();

    public static final String NODE_SYMBOL = "N";
    public static final String EDGE_SYMBOL = "E";
    public static final String TERMINATION_TERM = "^^^";
    public static final String GRAPH_PERSISTED_DATA_SEP = "\t";

    public VocabularyGraph() {
        VocabularyGraphVertex terminator = new VocabularyGraphVertex(TERMINATION_TERM, false);
        internals.put(terminator.getID(), terminator);
    }
    /**
     * The graph file has two sections: nodes and edges. The edges are serialized after all nodes are serialized.
     *
     * @param inputGraphStream
     */
    public void deserialize(InputStream inputGraphStream) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputGraphStream));
        String line = null;
        while((line = reader.readLine()) != null){
            line = line.trim();
            if(isNodeLine(line)) {
                // N vertex_id vertex_term entry_flag
                String[] data = line.split(GRAPH_PERSISTED_DATA_SEP);
                if(data.length != 4)  // bad data
                    continue;
                Long vertexID = Long.parseLong(data[1].trim());
                String term = data[2].trim();
                int flag = Integer.parseInt(data[3]);
                boolean isEntry = flag == 1 ? true : false;
                VocabularyGraphVertex vertex = new VocabularyGraphVertex(term, isEntry);
                if(isEntry)
                    entries.put(vertexID, vertex);
                else
                    internals.put(vertexID, vertex);
            } else if (isEdgeLine(line)) {
                // E from_vertex_id to_vertex_id1 to_vertex_id2 .....
                String[] data = line.split(GRAPH_PERSISTED_DATA_SEP);
                if(data.length < 2)  // bad data
                    continue;
                Long sourceVertexID = Long.parseLong(data[1]);
                VocabularyGraphVertex vertex = getVertexByID(sourceVertexID);
                if(vertex == null) // the graph doesn't have such a node.
                    continue;
                for(int i = 2; i < data.length; i++) {
                    Long targetVertexID = Long.parseLong(data[i].trim());
                    VocabularyGraphVertex outgoingTargetVertex = getVertexByID(targetVertexID);
                    if(outgoingTargetVertex != null)
                        vertex.addOutgoingTarget(outgoingTargetVertex);
                }
            }
        }
        reader.close();
        initialized = true;
    }

    /**
     *
     * @param id
     * @return
     */
    public VocabularyGraphVertex getVertexByID(Long id) {
        VocabularyGraphVertex vertex = entries.get(id);
        if(vertex == null)
            vertex = internals.get(id);
        return vertex;
    }

    private static boolean isNodeLine(String line) {
        boolean result = (line != null && line.trim().startsWith(NODE_SYMBOL + GRAPH_PERSISTED_DATA_SEP)) ? true : false;
        return result;

    }

    private static boolean isEdgeLine(String line) {
        boolean result = (line != null && line.trim().startsWith(EDGE_SYMBOL + GRAPH_PERSISTED_DATA_SEP)) ? true : false;
        return result;
    }

    /**
     *
     * @param inputCorpusStream the input vocabulary phrases, one phrase each line
     */
    public void build(InputStream inputCorpusStream) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputCorpusStream));

        String line = null;
        while((line = reader.readLine()) != null) {
            line = line.trim();
            if("".equals(line))
                continue;
            line += " " + TERMINATION_TERM;

            String[] terms = line.split("\\s+");
            for(int i = 0; i < terms.length; i ++) {
                boolean isEntry = i == 0 ? true : false;
                /*
                 * Build the vertex information
                 */
                String term = terms[i];
                Long vertexID = VocabularyGraphVertex.generateID(term);
                VocabularyGraphVertex vertex = getVertexByID(vertexID);
                if(vertex == null) {  // vertex not created yet
                    vertex = new VocabularyGraphVertex(term, isEntry);
                    if(isEntry)
                        entries.put(vertexID, vertex);
                    else
                        internals.put(vertexID, vertex);
                } else {
                    // During building the graph, if an existing internal vertex is found as the entry vertex of another phrase,
                    // the vertex' isEntryVertex flag is set to true, and move the vertex from internals to entries.
                    if(isEntry == true && vertex.isEntryVertex() == false) {
                        vertex.changeIntoEntryVertex();
                        if(internals.containsKey(vertexID)) {
                            internals.remove(vertexID);
                            entries.put(vertexID, vertex);
                        }
                    }
                }

                /*
                 * Update the outgoing vertex target information, i.e. setting up the edges.
                 */
                if(i > 0) { // current term is not the beginning term
                    // add current vertex to the vertex representing term at i-1 position
                    String previousTerm = terms[i-1];
                    Long previousVertexID = VocabularyGraphVertex.generateID(previousTerm);
                    VocabularyGraphVertex previousVertex = getVertexByID(previousVertexID);
                    if(previousVertex != null ) { // not likely to be null, just to be safe.
                        previousVertex.addOutgoingTarget(vertex);
                    }
                }
            }
        }
        initialized = true;
    }


    /**
     * The graph file has two sections: nodes and edges. The edges are serialized after all nodes are serialized.
     *
     * Each node is serialized into this format: N^Avertex_id^Avertex term^Aentry_flag
     * Each Edge is serialized into this format: E^Afrom_vertex_id^Ato_vertex_id1^Ato_vertex_id2
     *
     * @param outputGraphStream
     */
    public void serialize(OutputStream outputGraphStream) throws IOException{
        if(! initialized)
            return;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputGraphStream));
        // write the nodes
        serializeNodes(writer, entries);
        serializeNodes(writer, internals);

        // write the edges
        // Graph serialization happens rarely depends on vocabulary change.
        // Thus, we are ok to iterate over the vertex set two times
        serializeEdges(writer, entries);
        serializeEdges(writer, internals);
        writer.close();
    }

    private void serializeNodes(BufferedWriter writer, HashMap<Long, VocabularyGraphVertex> nodes) throws IOException{
        for(VocabularyGraphVertex vertex : nodes.values()){
            int flag = vertex.isEntryVertex() ? 1 : 0;
            writer.write(NODE_SYMBOL + GRAPH_PERSISTED_DATA_SEP + vertex.getID().toString() + GRAPH_PERSISTED_DATA_SEP + vertex.getTerm() + GRAPH_PERSISTED_DATA_SEP + flag + "\n");
        }
    }

    private void serializeEdges(BufferedWriter writer, HashMap<Long, VocabularyGraphVertex> nodes) throws IOException{
        for(VocabularyGraphVertex vertex : nodes.values()){
            StringBuffer buffer = new StringBuffer();
            buffer.append(EDGE_SYMBOL + GRAPH_PERSISTED_DATA_SEP + vertex.getID());
            for(VocabularyGraphVertex target : vertex.getOutgoingTargets()) {
                buffer.append(GRAPH_PERSISTED_DATA_SEP + target.getID());
            }
            buffer.append("\n");
            writer.write(buffer.toString());
        }
    }

    public HashSet<VocabularyGraphVertex> getEntryVertexByTerms(String[] terms){
        HashSet<VocabularyGraphVertex> matchedEntries = new HashSet<VocabularyGraphVertex>();
        if(! initialized)
            return matchedEntries;
        for(String term : terms) {
            Long candidateVertexID = VocabularyGraphVertex.generateID(term);
            VocabularyGraphVertex entry = entries.get(candidateVertexID);
            if(entry != null)
                matchedEntries.add(entry);
        }
        return matchedEntries;
    }

    public VocabularyGraphVertex getEntryVertexByTerm(String term) {
        if(! initialized)
            return null;
        Long candidateVertexID = VocabularyGraphVertex.generateID(term);
        return entries.get(candidateVertexID);
    }

    public VocabularyGraphVertex getVertexByTerm(String term) {
        if(! initialized)
            return null;
        return this.getVertexByID(VocabularyGraphVertex.generateID(term));
    }

    /**
     * Check whether the given phrase matches full or part of any corpus phrase.
     * @param phrase the length of the input phrase must be smaller or equal to the length of one corpus phrase
     * @param isReachTerminationRequired If true, the input phrase must match with one of phrase in the
     *                                   corpus of the graph;
     *                                   If false, the input phrase only has to be a substring of one
     *                                   of phrase in the corpus of the graph.
     * @return
     */
    public boolean match(String phrase, boolean isReachTerminationRequired) {
        if(! initialized || phrase == null || "".equals(phrase))
            return false;
        phrase = phrase.trim();
        if(isReachTerminationRequired)
            phrase += " " + TERMINATION_TERM;
        String[] terms = phrase.split("\\s+");
        String entryTerm = terms[0];
        VocabularyGraphVertex vertex = getEntryVertexByTerm(entryTerm);
        if(vertex == null )
            return false;

        for(int i = 0; i < terms.length - 1; i++) {
            if(! hasEdge(terms[i], terms[i+1]))
                return false;
        }

        return true;
    }

    /**
     * For any given corpus phrase P, P is a prefix of the text if text.startWith(P) is true.
     *
     * @param text
     * @return
     */
    public HashSet<String> getPrefixesInCorpus(String text) {
        HashSet<String> prefixes = new HashSet<String>();
        if(text == null)
            return prefixes;
        text = text.trim();
        String[] terms = text.split("\\s+");
        String longestMatchedPrefix = "";
        for(int i = 0; i < terms.length; i ++) {
            String term = terms[i];
            VocabularyGraphVertex vertex = getVertexByID(VocabularyGraphVertex.generateID(term));

            // stop processing because current term doesn't exist in graph or first term is not entry term of the graph
            if(vertex == null || (i == 0 && ! vertex.isEntryVertex()))
                break;

            if(i == 0 || (i >= 1 && this.hasEdge(terms[i-1], term))) {
                longestMatchedPrefix += " " + term;
                if(vertex.isEndingVertex())
                    prefixes.add(new String(longestMatchedPrefix.trim()));
            } else {
                break; // there isn't any longer corpus phrase could be a match
            }
        }
        return prefixes;
    }

    public boolean hasEdge(String fromTerm, String toTerm) {
        if(! initialized || fromTerm == null || toTerm == null)
            return false;

        fromTerm = fromTerm.trim();
        toTerm = toTerm.trim();
        if("".equals(fromTerm) || "".equals(toTerm))
            return false;

        VocabularyGraphVertex from = getVertexByID(VocabularyGraphVertex.generateID(fromTerm));
        VocabularyGraphVertex to = getVertexByID(VocabularyGraphVertex.generateID(toTerm));

        return hasEdge(from, to);
    }

    public boolean hasEdge(VocabularyGraphVertex from, VocabularyGraphVertex to) {
        if(! initialized || from == null || to == null)
            return false;
        return from.getOutgoingTargets().contains(to);
    }

    public long size() {
        return entries.size() + internals.size() - 1;  // minus the terminator vertex
    }

}
