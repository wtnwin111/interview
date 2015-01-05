package com.interview.books.topcoder.geometry;

import com.interview.basics.model.geometry.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created_By: stefanie
 * Date: 15-1-5
 * Time: 下午4:02
 */
public class TC_G9_PointPolygonRelation {
    public static final String INTERIOR = "INTERIOR";
    public static final String EXTERIOR = "EXTERIOR";
    public static final String BOUNDARY = "BOUNDARY";

    public String relation(float[][] ploygon, float[] X){
        List<Line> edges = new ArrayList();
        for(int i = 0; i < ploygon.length - 1; i++) edges.add(new Line(ploygon[i], ploygon[i+1]));
        edges.add(new Line(ploygon[ploygon.length - 1], ploygon[0]));

        //check if on BOUNDARY
        for(Line line : edges){
            if(line.distance(X) == 0) return BOUNDARY;
        }

        //check INTERIOR or EXTERIOR based on count intersection
        float[] Y = new float[2];
        Random random = new Random();
        Y[0] = random.nextFloat() * 1000 + 1000;
        Y[1] = random.nextFloat() * 1000 + 1000;

        Line XY = new Line(X, Y);
        int intersection = 0;
        for(Line line : edges){
            if(line.intersection(XY) != null) intersection++;
        }
        return intersection % 2 == 0? EXTERIOR : INTERIOR;
    }

    public static void main(String[] args){
        TC_G9_PointPolygonRelation checker = new TC_G9_PointPolygonRelation();
        float[][] polygon = new float[][]{
                {0, 0},
                {0, 10},
                {10,10},
                {10, 0}
        };
        System.out.println(checker.relation(polygon, new float[]{5,10})); //BOUNDARY
        System.out.println(checker.relation(polygon, new float[]{10,15}));//EXTERIOR
        System.out.println(checker.relation(polygon, new float[]{5,5}));  //INTERIOR



    }
}
