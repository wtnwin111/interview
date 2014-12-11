#Problem Lists and HINTs

1.  Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such 
    that it remains a cyclic sorted list. The given node can be any single node in the list.
    
    *HINT: Careful for edge case: list only have 1 element, value is smaller than head, etc*

2.  Given two axis-aligned rectangles A(p1,p2) and B(q1,q2). Write a function to determine if the two rectangles overlap.

    !(p2.x < q1.x || p1.x > q2.x || p2.y > q1.y || p1.y < q2.y)

3.  **Given a 2D point and a rectangle(p1, p2, p3, p4), determine if the point is inside the rectangle.**
    Note that the rectangle maybe rotated.
    
    http://leetcode.com/2010/04/how-to-determine-if-point-is-inside.html

4.  **Fair Painter**

    You have to paint N boards of length {A0, A1, A2 … AN-1}. There are K painters available (they are in the same speed to paint the house). 
    You have to get this job done as soon as possible under the constraints that any painter will only paint continuous sections of board, 
    say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
    
    *HINT: It's a DP, the problem can be transformed to following:*
        
        Given an array of non-negative integers A and a positive integer K, we want to:
        Divide A into K or fewer partitions,
        such that the maximum sum over all the partitions is minimized.

5. **Fair Painter**
    
    Could you find a solution without extra Space. Non DP solution
    
    *HINT: BinarySearch in range(max, sum)*
    
6.  **Max Element in the Window**

    Given a long array A[], and a sliding window of size w which is moving from the very left of the array to the very right. 
    You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. 
    Return an array B[], which B[i] contains the max value in sliding window start from A[i] to A[i+w-1]
    
    *HINT: Heap could achieve O(NlgN), and Double-ended Queue could achieve O(N).
    [When insert pop the smaller element in window from tail, when move forward, pop first elements out of window from head]
    
7.  Studious Student, Facebook Hacker Cup Qualification Round.
    
    You’ve been given a list of words to study and memorize. Being a diligent student of language and the arts, you’ve decided to 
    not study them at all and instead make up pointless games based on them. One game you’ve come up with is to see how you can 
    concatenate the words to generate the lexicographically lowest possible string.
    
    *HINT: directly sort may not work, such as "jibw ji jp bw jibw", created lowest possible string is "bwjibwjibwjijp" not "bwjijibwjibwjp"
    If no word appears to be a prefix of any other words, then the simple sort + concatenate must yield the smallest dictionary order string.*
    
8.  Peg Game: Facebook Hacker Cup Qualification Round: Peg Game [Full Problem Statement](http://leetcode.com/2011/01/peg-game-problem-analysis.html)

    *This problem maybe too difficult for a tech interview*

9.  Double Square: Facebook Hacker Cup Qualification Round  

    A double-square number is an integer X which can be expressed as the sum of two perfect squares. 
    For example, 10 is a double-square because 10 = 3^2 + 1^2. Your task in this problem is, given X, determine the number of 
    ways in which it can be written as the sum of two squares. For example, 10 can only be written as 3^2 + 1^2 
    (we don’t count 1^2 + 3^2 as being different). On the other hand, 25 can be written as 5^2 + 0^2 or as 4^2 + 3^2.
    
    *HINT: searching first element i in [0-sqrt(X)], second element j is X - i^2, if j can be sqrt. have 1 solution.  

10. **Max Count of A [Google Interview Question]**

    Imagine you have a special keyboard with the following keys: A, Ctrl+A, Ctrl+C, Ctrl+V. 
    where CTRL+A, CTRL+C, CTRL+V each acts as one function key for “Select All”, “Copy”, and “Paste” operations respectively.
    If you can only press the keyboard for N times (with the above four keys), please write a program to produce maximum numbers of A. 
    If possible, please also print out the sequence of keys.   
    [LeetCode Discussion](http://leetcode.com/2011/01/ctrla-ctrlc-ctrlv.html)
    
        Note two things:
            1. When you copy something, the content is in clipboard, and you can Ctrl+V to paste the same content
            2. "A, Ctrl+A, Ctrl+C, Ctrl+V" sequence can get only 1 "A", since it will cover the content you "Select All""
    *HINT: It's a DP problem, analysis when continue Paste, when start to do Copy again to achieve O(N) time complexity*
    
11. Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
    where largest means subtree with largest number of nodes in it.    
        
        Note that: subtree means mid-node must include all of its descendants.
    *HINT: Bottom-up approach: based on post order traverse with tracking max in left subtree and min in right subtree
    
12. Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it. 
    The largest BST may or may not include all of its descendants.
    
    *HINT: Top-down approach: based on pre-order traverse(check if node.val in range of min and max given by it's parent).
           if yes, build subtree and return itself as child to parent, if no, treat itself as the root.
    
    **The different of 11 and 12, in 11 whether node i in or not depends on it's left&right subtree, so use post-order traverse,
    in 12, it's only depends on itself, so use in-order traverse. Both are tracking min and max bound.**
    

#Not in OJ

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

