package com.interview.basics.model.geometry;

/**
 * Created_By: stefanie
 * Date: 15-1-4
 * Time: 下午8:24
 */
public class Polygon {
    float[][] points;

    public Polygon(float[][] points){
        this.points = points;
    }

    public float area(){
        float area = 0;
        int origin = 0;
        Vector previous = new Vector(points[origin], points[1]);
        for(int i = 2; i < points.length; i++){
            Vector next = new Vector(points[origin], points[i]);
            area += previous.cross(next);
            previous = next;
        }
        return Math.abs(area / 2);
    }
}
