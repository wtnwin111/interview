#Technical Interview Question

1.  [Array] Given three sorted arrays (in ascending order), you are required to find a triplet (one element from each array) 
    such that distance is minimum. Please give a solution in O(n) time complexity 
    
        Distance is defined like this : If a[i], b[j] and c[k] are three elements then 
            distance = max(abs(a[i]-b[j]), abs(a[i]-c[k]) ,abs(b[j]-c[k]))
    *HINT: three point, and always move the smallest one to next. Tracking the min distance during visiting. O(N).*

2.  [Array/Graph] Given a un-directed graph with N vertex, and M edges, find the connected components on the graph.
 
    *HINT: Balanced Union Find, note that UnionFind only for un-directly graph or directed graph to find WCC.*
    
3.  [Digital Convert] Write a function (with helper functions if needed) called to Excel that takes an excel column value (A,B,C,D
    ,..Z,AA,AB,AC,..,ZZ,AAA..) and returns a corresponding integer value (A=1,B=2,..,AA=26..).
    
    *HINT: A-Z is 26-based digital system, but without 0, so add one after conversion if not the last bit.*
    
4.  [Interval] Given a set of ranges, find the two ranges with the greatest overlap.
    
    *HINT: sort the interval by start, and keep tracking the max end, and max overlap. Since i.start <= j.start when j > i, 
    and if j.end > i.end, and for any k, k > j > i, the max overlap should be j.end - k.start.* 
       
5.  [Math] Given a time, calculate the angle between the hour and minute hands.

    *HINT: pre-calculate degree per minute and per hour. degree_hour = (hour + minute/60F) * DEGREE_PRE_HOUR. Also remember to 
     do mod on hour and minutes, and normalize angle if it < 0 or > 180.*
     
6.  [Math] Write a method to get the greatest common divisor(GCD) of two given integer. And if you can't use division and mod.
    
    *HINT: while(i % j != 0) {int mod = i % j; i = j; j = mod; }, be careful the condition of i > j.
     Without division and mod, use Binary Bit Manipulation.*
     
         Avoid to use division and mode, instead using >> or & bit operation.
             if x, y both are even        f(x,y) = 2 * f(x/2, y/2)
             if x is even, y is not,      f(x,y) = f(x/2, y)
             if y is even, x is not,      f(x,y) = f(x, y/2)
             if x, y both are not even,   f(x,y) = f(x, y - x)

7.  [Combination] There are k exactly same boxes, and we have to put n exactly same items into them. Assume there is no limitation on box, 
    and the only requirement is that each item should be put into one box. Please write out the code to print out all the possible 
    possibilities, print error the input can not get any result. 
                   
    *HINT: standard combination problem, be careful is box could empty or not (add "index == k - 1" condition when print solution).*
       
8.  **[Math] In Lucky 7 sequence, we need remove all the number contains 7 from the integer, such as 7, 17, 71, etc, and define a method 
    to return corresponding number when giving a regular number, and decode the Lucky 7 number to the regular number.**

    *HINT: Consider this problem as convert this integer to base9 digit system, and if digit >= 7 increasing one.*
    
9. 