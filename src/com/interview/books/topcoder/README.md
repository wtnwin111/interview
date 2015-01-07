#Programming Problem from TopCoder

##Geometry
        Basic Operation on Vector
            Vector(A, B) = float[]{B[0] - A[0], B[1] - A[1]}; 
            GeoUtil.distance(A, B) = Vector(A,B).length()
                                   = Math.sqrt(AB[0]^2 + AB[1]^2)
            GeoUtil.dot(A, B, C) = Vector(A, B).dot(Vector(B, C))           
                                 = (AB[0] * BC[0] + AB[1] * BC[1]) it's a value
                                 = Vector(A, B).length * Vector(B, C).length * Cos(θ), where θ is the angle between the AB and BC.
            GeoUtil.cross(A, B, C) = Vector(A, B).cross(Vector(B, C))
                                   = (AB[0] * BC[1]) - (AB[1] * BC[2]), it's a vector, the direction based on right-hand rule.
                                   = Vector(A, B).length * Vector(B, C).length * Sin(θ). |θ| is the angle between the two vectors.
                                 
1.  Given a line L(point A and B) and a point X, write code to find the distance of L and X.
    Also consider L as a segment, not a line.
    
    *HINT: if L is line, distance(L, X) is the area of polygon (AB, BX) / length(AB).
    if L is a segment, could check if perpendicular is out of range, if YES, distance = length(AX) or length(BX)
    
        if(isSegment){
            if(GeoUtil.dot(X, Y, Z) > 0) return GeoUtil.distance(Y, Z);
            if(GeoUtil.dot(Y, X, Z) > 0) return GeoUtil.distance(X, Z);
        }
        return Math.abs(GeoUtil.cross(X, Y, Z) / GeoUtil.distance(X, Y)); 
    *Code is in com.interview.basic.model.geometry.Line.distance(float[] point);*    
    
2.  Given a list points identify a polygon, write code to calculate the area of the polygon.

    *HINT: cross product is the area of parallelogram. 
    
        For any two vector ab.cross(bc) is the area of parallelogram created by (ab, bc), so the area of 
        triangle abc = ab.cross(bc)/2; 
            float area = 0;
            for(int i = 1; i < points.length - 1; i++){
                area += GeoUtil.cross(points[0], points[i], points[i+1]);
            }
            return Math.abs(area/2);
        And cross product is positive if C is in the right of ab, otherwise will be negative, so the solution
        also workable for non-convex polygon.
    *Code is in com.interview.basic.model.geometry.Polygon.distance(float[] point);*  
      
3.  Given two line, write code to find the intersection if have.
    
    *HINT: Line can be identified as Ax + By = C. The intersection can be found following both equation. 
    A1x + B1y = C1 and A2x + B2y = C2. so x' = (A1*C2 - A2*C1)/A1*B2 - A2*B1, and y' = (B2*C1 - B1*C2)/A1*B2 - A2*B1.
    If A1*B2 - A2*B1 == 0, means the two lines are parallel, no intersection.*
    
        Note: If give two point, need find the equation by solve A, B, C: A = y2-y1, B = x1-x2, C = A*x1+B*y1.
        If line is a segment, need check if intersection on the segments, by check x,y in range for both segment:
            min(x1, x2) <= intersection.x <= max(x1, x2) and min(y1, y2) <= intersection.y <= max(y1, y2)
    *Code is in com.interview.basic.model.geometry.Line.intersection(Line line);* 
    
4.  Given a line, write code to find the perpendicular line.

    *HINT: the perpendicular line is -Bx + Ay = D, D can be resolve by a given point or the midpoint of the line.*
    
    *Code is in com.interview.basic.model.geometry.Line.perpendicular() and perpendicular(float[] point); 

5.  Given three points A,B,C not in one line, find a Circle can go through all the three points.

    *HINT: Circle can be identify by center and radius. The center of circle can be found as the intersection of
    perpendicular through midpoint of AB and BC, and radius is distance of center to A or B or C.*
     
        Line ab = new Line(A, B);
        Line abPerpendicular = ab.perpendicular();
        Line bc = new Line(B, C);
        Line bcPerpendicular = bc.perpendicular();
        
        float[] center = abPerpendicular.intersection(bcPerpendicular);
        float radius = GeoUtil.distance(center, A);
    *Code is in com.interview.basic.model.geometry.Circle(float[] X, float[] Y, float[] Z);*   

6.  Given a point X and a Line L, find the reflection of X against L.
 
    *HINT: the reflection of X against L can be resolved by Y, Y is the intersection of L's perpendicular through X.
     reflection of X = Y - (X - Y).*
     
        Line perpendicular = L.perpendicular(X);
        float[] intersection = L.intersection(perpendicular);
        float[] reflection = new float[2];
        reflection[0] = intersection[0] * 2 - X[0];
        reflection[1] = intersection[1] * 2 - X[1];
    *Code is in com.interview.basic.model.geometry.Line.reflection(float[] point);*

7.  Given a point A, rotate the point by the center of B counterclockwise by θ degrees. 

    *HINT: A's rotation based on (0,0) counterclockwise by θ degrees is x' = x Cos(θ) - y Sin(θ), 
    and y' = x Sin(θ) + y Cos(θ). A's rotation based on B, can change the coordinate system using B as origin 
    by minus(A, B), and do rotation, then move back to (0,0) by plus(A, B).*
    
        minus(point, origin);
        double radians = Math.toRadians(degree);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        
        float[] rotated = new float[2];
        rotated[0] = (float) (point[0] * cos - point[1] * sin);
        rotated[1] = (float) (point[0] * sin - point[1] * cos);
        
        plus(rotated, origin);
        plus(point, origin);
    *Note: a vector is defined by a direction and a magnitude, not begin and end. so rotated of a vector
    counterclockwise by θ degrees, is rotated as one point is origin, just do x' = x Cos(θ) - y Sin(θ), 
    and y' = x Sin(θ) + y Cos(θ), only change the direction, magnitude still the same.*

8.  **Convex Hull** Given a list of points, find the convex hull. 
    A convex hull of a set of points is the smallest convex polygon that contains every one of the points.
    
    *HINT: start with leftmost point, then loop to find next point on convex hull while it not leftmost.
    In each loop, if cross(vector(start, i), vector(start, next)) < 0, let next = i; since cross product 
    is |A||B|Sin(θ), if cross < 0, -180 < θ < 0, so point[i] is on convex hull. Optimized method is sort
    point based on θ to x-axis of leftmost, then scan one by one to find convex hull.*
    
9.  **PolygonPointRelation** Given a list points identify a polygon and a point X, write code to get the 
    relation of X and polygon. The relation should be "INTERIOR", "EXTERIOR", or "BOUNDARY".
    
    *HINT: solve based on cross product, also could solve by Point-Line-Distance and Line-Line-Intersection.*
    
        Solve by calculating cross product of Vector(points[i], points[i+1]) and Vector(points[i], X), 
        if the cross product is:
            negative, X is in the right of Line(point[i+1],[i]),
            positive, X is in the left of Line(point[i+1],[i]),
            0, X is on the Line(point[i+1],[i]), but may not on segment, if on segment, BOUNDARY
        If X is in the right of all edges, X is INTERIOR, otherwise X is in left of one edge, X is EXTERIOR.
        If X is on the segment, X is BOUNDARY.
    
        Solution using Point-Line-Distance and Line-Line-Intersection.
        If X on boundary of polygon, line.distance(X) == 0
        To determine "INTERIOR", "EXTERIOR", pick a point Y very far away, and count the intersection of
        every line in polygon with Line(X, Y), if count is even, X is out of polygon, if is odd, X is in polygon.

10. **TVTower** There is N towns, write code to find where to locate our TV station's broadcasting tower. 
    The location the tower should minimize the broadcast radius that includes all the towns.
    
    *HINT: solve based on ThreePointOnCircle.*
    
        Three points can identity a circle, but for min radius circle cover all the town, there are two cases:
        1. If X and Y are diameter of a circle, the midpoint of X and Y are center, and the radius is min.
        2. If X, Y, Z are all on the circle, center could be found by ThreePointOnCircle, and radius is min. 
        So loop town to find the center to get the min radius.
            1. loop X and Y, get center = midpoint(X, Y)
            2. loop X, Y, Z, get center = new Circle(X, Y, Z).center
        init tower.radius = Float.MAX_VALUE, update the radius as the max distance between center to any town.
        The solution is O(N^4)

11. Surveyor: A plot has been surveyed. Its boundary consists of segments that form a polygon. 
    Each segment runs either North-South or East-West. Create a class Surveyor that contains a method area that 
    takes as input a String direction and a int[] length and returns the enclosed area.
    For example, direction: "NWWSE", steps: {10,3,7,10,10}, the plot is a 10 x 10 square, return area 100.
    
    *HINT: an polygon can be created based on direction and steps, then return the area of polygon.*

12. **Symmetry** A line of symmetry is a line through the cartesian plane such that if you reflect everything
    from one side of the line to the other, you still have the same image. For example, if the x-axis is a line
    of symmetry, it means that for every point (x,y) there is also a point (x,-y).
    Your task is, given a list of points, determine how many such lines exist.
    
    *HINT: get perpendicular line of each two point, and try to find if reflection point of other point in the 
     given points. If exist, it will be re-calculate point.size()/2 time for each reflection point pair.*
    
13. Given four points, write code to check if the four points can form a rectangle.

    *HINT: assume given point is A,B,C,D, if AB is perpendicular with BC, and AD is perpendicular with CD, than 
    ABCD is a rectangle. Two vector is perpendicular can be identified by dot product == 0.*
    
##String
1.  A palindrome is a String that is spelled the same forward and backwards. Given a word, you can adjust it to
    palindrome by adding some chars. The add operation can perform at any offset in the word. 
    Your task is to make base into a palindrome by adding as few letters as possible and return the resulting 
    String. When there is more than one palindrome of minimal length that can be made, return the lexicographically 
    earliest.
    
    


     
 



    
    
    