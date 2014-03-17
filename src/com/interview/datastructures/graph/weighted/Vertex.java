package com.interview.datastructures.graph.weighted;

/**
 * Created_By: zouzhile
 * Date: 3/16/14
 * Time: 9:34 AM
 */
public class Vertex {
    private String value ;

    public Vertex(String value) {
        this.value = value;
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || ! (o instanceof Vertex))
            return false;
        return this.hashCode() == o.hashCode();
    }

    public String getValue(){
        return this.value;
    }
}
