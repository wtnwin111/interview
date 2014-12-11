#Problem Lists and HITs

1.  Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such 
    that it remains a cyclic sorted list. The given node can be any single node in the list.
    
    *HIT: Careful for edge case: list only have 1 element, value is smaller than head, etc*

2.  Given two axis-aligned rectangles A(p1,p2) and B(q1,q2). Write a function to determine if the two rectangles overlap.

    !(p2.x < q1.x || p1.x > q2.x || p2.y > q1.y || p1.y < q2.y)

3.  **Given a 2D point and a rectangle(p1, p2, p3, p4), determine if the point is inside the rectangle.**
    Note that the rectangle maybe rotated.
    
    http://leetcode.com/2010/04/how-to-determine-if-point-is-inside.html

4.  **Fair Painter**

    You have to paint N boards of length {A0, A1, A2 … AN-1}. There are K painters available (they are in the same speed to paint the house). 
    You have to get this job done as soon as possible under the constraints that any painter will only paint continuous sections of board, 
    say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
    
    *HIT: It's a DP, the problem can be transformed to following:*
        
        Given an array of non-negative integers A and a positive integer K, we want to:
        Divide A into K or fewer partitions,
        such that the maximum sum over all the partitions is minimized.

5. **Fair Painter**
    
    Could you find a solution without extra Space. Non DP solution
    
    *HIT: BinarySearch in range(max, sum)*

#Not in OJ



http://leetcode.com/2011/04/the-painters-partition-problem.html
http://leetcode.com/2011/04/the-painters-partition-problem-part-ii.html
http://leetcode.com/2011/01/sliding-window-maximum.html
http://leetcode.com/2011/01/nuts-in-oasis-interview-question-from.html
http://leetcode.com/2011/01/studious-student-problem-analysis.html
http://leetcode.com/2011/01/peg-game-problem-analysis.html
http://leetcode.com/2011/01/double-square-problem-analysis.html
http://leetcode.com/2011/01/ctrla-ctrlc-ctrlv.html
http://leetcode.com/2010/11/largest-binary-search-tree-bst-in_22.html
http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html
http://leetcode.com/2010/11/rejection-sampling.html
http://leetcode.com/2010/11/microsoft-string-replacement-problem.html
http://leetcode.com/2010/10/print-edge-nodes-boundary-of-binary.html
http://leetcode.com/2010/09/serializationdeserialization-of-binary.html
http://leetcode.com/2010/09/saving-binary-search-tree-to-file.html
http://leetcode.com/2010/09/how-to-pretty-print-binary-tree.html
http://leetcode.com/2010/05/problem-snapper-chain-gcj-qualification.html
http://leetcode.com/2010/05/problem-b-fair-warning-solution.html
http://leetcode.com/2010/05/problem-c-theme-park-solution.html
http://leetcode.com/2010/05/here-is-another-google-phone-interview.html
http://leetcode.com/2010/02/here-is-one-of-questions-from-microsoft.html

