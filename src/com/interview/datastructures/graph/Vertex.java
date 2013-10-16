package com.interview.datastructures.graph;

import java.util.UUID;

/**
 * Created_By: zouzhile
 * Date: 10/16/13
 * Time: 10:24 AM
 */


public class Vertex implements Comparable<Vertex> {

    VertexColor color;
    int distance = -1;
    int value = -1;
    String id;

    public Vertex(int value) {
        this(VertexColor.WHITE, value);
    }

    public Vertex(VertexColor color, int value) {
        this.id = UUID.randomUUID().toString();
        this.color = color;
        this.value = value;
    }

    public VertexColor getColor() {
        return color;
    }

    public void setColor(VertexColor color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getValue() {
        return value;
    }

    public String getInternalId() {
        return this.id;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.id.compareTo(o.getInternalId());
    }

    @Override
    public boolean equals(Object o) {
        if(! (o instanceof Vertex))
             return false;
        return this.id.equals(((Vertex)o).getInternalId());
    }
}
