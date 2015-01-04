package com.interview.basics.model.geometry;

/**
 * Created_By: stefanie
 * Date: 15-1-4
 * Time: 下午8:58
 */
public class Line {
    boolean isSegment;
    float A;
    float B;
    float C;

    float[] X;
    float[] Y;

    public Line(float A, float B, float C){
        isSegment = false;
        this.A = A;
        this.B = B;
        this.C = C;
    }

    /**
     * A = y2-y1, B = x1-x2, C = A*x1+B*y1
     */
    public Line(float[] p1, float[] p2){
        isSegment = true;
        this.A = p2[1] - p1[1];
        this.B = p1[0] - p2[0];
        this.C = A * p1[0] + B * p1[1];
        X = p1;
        Y = p2;
    }

    public Line(float A, float B, float[] point){
        isSegment = false;
        this.A = A;
        this.B = B;
        this.C = A * point[0] + B * point[1];
    }

    public float[] getMidpoint(){
        return new float[]{(X[0] + Y[0])/2, (X[1] + Y[1])/2};
    }

    public float distance(float[] Z){
        Vector xy = new Vector(X, Y);
        Vector yz = new Vector(Y, Z);
        Vector xz = new Vector(X, Z);
        Vector yx = new Vector(Y, X);
        if(isSegment){
            if(xy.dot(yz) > 0) return yz.length();
            if(yx.dot(xz) > 0) return xz.length();
        }
        return Math.abs(xy.cross(yz) / xy.length());
    }

    public float[] intersection(Line line){
        float det = this.A * line.B - line.A * this.B;
        if(det == 0){
            return null;
        } else {
            float x = (line.B * this.C - this.B * line.C)/det;
            float y = (this.A * line.C - line.A * this.C)/det;
            return new float[]{x, y};
        }
    }
    //Ax+By = C -> -Bx+Ay = D
    public Line perpendicular(){
        if(isSegment){
            float[] midpoint = getMidpoint();
            return new Line(-this.B, this.A, midpoint);
        } else {
            return new Line(-this.B, this.A, 0);
        }
    }

    public Line perpendicular(float[] point){
        return new Line(-this.B, this.A, point);
    }

    public float[] reflection(float[] point){
        Line perpendicular = perpendicular(point);
        float[] intersection = intersection(perpendicular);
        float[] reflection = new float[2]; //intersection - (point - intersection).
        reflection[0] = 2 * intersection[0] - point[0];
        reflection[1] = 2 * intersection[1] - point[1];
        return reflection;
    }
}
