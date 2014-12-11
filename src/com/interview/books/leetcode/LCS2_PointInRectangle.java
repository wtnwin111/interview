package com.interview.books.leetcode;

import com.interview.leetcode.utils.Point;

/**
 * Created_By: stefanie
 * Date: 14-12-10
 * Time: 下午10:12
 */
public class LCS2_PointInRectangle {
    public boolean isInRectangle(Point[] points, Point target){
        double slopA = (points[0].y - points[2].y) / (points[0].x - points[2].x);
        return false;
    }

    //http://leetcode.com/2010/04/how-to-determine-if-point-is-inside.html
//    bool is_point_in_rectangle(const Rect& rect, const Point& p) {
//        Vector2d P1(rect.p1.x, rect.p1.y);
//        Vector2d P2(rect.p2.x, rect.p2.y);
//        Vector2d P3(rect.p3.x, rect.p3.y);
//        Vector2d P4(rect.p4.x, rect.p4.y);
//        Vector2d P(p.x, p.y);
//
//        Vector2d P1_P4 = P1 - P4;
//        Vector2d P3_P4 = P3 - P4;
//        Vector2d TWO_P_C = 2.0*P - P1 - P3;    // TWO_P_C=2P-C, C=Center of rectangle
//
//        return (P3_P4.Dot(TWO_P_C - P3_P4) <= 0 && P3_P4.Dot(TWO_P_C + P3_P4) >= 0) &&
//                (P1_P4.Dot(TWO_P_C - P1_P4) <= 0 && P1_P4.Dot(TWO_P_C + P1_P4) >= 0);
//    }

    public boolean isInAlignedRectangle(Point[] points, Point target){
        return !(target.x < points[0].x || target.x > points[1].x || target.y > points[0].y || target.y < points[1].y);
    }
}
