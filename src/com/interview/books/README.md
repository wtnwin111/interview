#Question List
**Bold Problem** is **IMPORTANT and HARD/MEDIAN**

##Leetcode Blogs
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

5. **Fair Painter** Could you find a solution without extra Space. Non DP solution
    
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
    
11. **Largest BST Subtree** Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
    where largest means subtree with largest number of nodes in it.    
        
        Note that: subtree means mid-node must include all of its descendants.
    *HINT: Bottom-up approach: based on post order traverse with tracking max in left subtree and min in right subtree
    
12. **Largest BST** Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it. 
    The largest BST may or may not include all of its descendants.
    
    *HINT: Top-down approach: based on pre-order traverse(check if node.val in range of min and max given by it's parent).
           if yes, build subtree and return itself as child to parent, if no, treat itself as the root.
    
    **The different of 11 and 12, in 11 whether node i in or not depends on it's left&right subtree, so use post-order traverse,
    in 12, it's only depends on itself, so use in-order traverse. Both are tracking min and max bound.**
    
13. Random generation. Given a function which generates a random integer in the range 1 to 7, write a function which generates 
    a random integer in the range 1 to 10 uniformly.
    
        A more generic problem is: Given a function generates a random integer in range 1 to M, write a function to generate random
        integer  1 to N uniformly.
    *HINT: use randM generate (randM() - 1) * M + randM(), and normalize it to (1 - ((M*M)/N)*N) and mod N*

14. **KMP Problem** Replace all occurrence of the given pattern to ‘X’.For example, given that the pattern=”abc”, replace “abcdeffdfegabcabc” 
    with “XdeffdfegX”. Note that multiple occurrences of abc’s that are contiguous will be replaced with only one ‘X’.
    
    *HINT: Using KMP to find the first match offset, replace if previous is not X*

15. **Print all edge nodes of a complete binary tree anti-clockwise.**
    That is all the left most nodes starting at root, then the leaves left to right and finally all the rightmost nodes.
    In other words, print the boundary of the tree. Variant: Print the same for a tree that is not complete.
    
    *HINT: Top-down approach by identify boolean flag print?. On the left edge, if node have no left child, need print right; 
    On the right edge, if node have no right child, need print left. And left is pre-order, and right is post-order.
    
16. Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a String is called ‘serialization’ 
    and reading back from the String to reconstruct the exact same binary tree is ‘deserialization’.
    
    *HINT: do level order traverse, save the null child as "#" but no save null's child.* 
    
17. Describe an algorithm to save a Binary Search Tree (BST) to a file in terms of run-time and disk space complexity. 
    You must be able to restore to the exact original BST using the saved format.
    
    *HINT: BST in-order is sorted, so just need to persistent pre-order or post-order, than can restore BST(Using binary search to achieve O(NlgN)).*
    
18. A very interesting Math problem: Given a list of positive integers: t1, t2, …, tn, and ti ? tj for some i, j. Find the smallest integer y >= 0 
    such that each ti + y is divisible by an integer T. T must be the largest of all possible divisors. 
    [Solution at LeetCode](http://leetcode.com/2010/05/problem-b-fair-warning-solution.html)
    
    *HINT: t1 + y = k1 * T and t2 + y = k2 * T, can got T = t1 - t2 and y = t1 - 2*t2*
    
19. Given a string of lowercase characters, reorder them such that the same characters are at least distance d from each other.
    Input: { a, b, b }, distance = 2; Output: { b, a, b }
    
    *HINT: Greedy Strategy: The character that has the most duplicates has the highest priority of being chosen to put in the new list. 
    If that character cannot be chosen (due to the distance constraint), we go for the character that has the next highest priority.*
    
##NineChapter Blogs

1.  Given two int array A[] and B[], each have K elements, select 1 element from A and B and do sum, we could get K * K pair sum. 
    Find the Top K pair sum value.
    
    *HINT: imagine to build a pair sum matrix (Yang Matrix), so same problem as TopK in Yang Matrix (PriorityQueue storing offsets)*
    
2.  As question 1, if give you N arrays, and pick N element from array, and find the Top K sum.

    *HINT: Divide and Conqur using Answer of 1, like merge K sorted list.

3.  Random generation problem: Given a rand(2) generate 1 in possibility p, and 0 in possibility 1-p. 
    Now try to use rand(2) create a new function generate 0 and 1 in the sample possibility. 
    
    **Enhanced Random generation**: create a new function to generate 1 - N with sample possibility.

    *HINT: Binary version of a integer*
    
4.  **Two Pointer to O(N):** Given a article of N words, and M pair of words, find the min distance of the word pair(sequence matters) in the article 
    if they both appears. For example: article is "ABBCABC" and for word pair (A, C) the min distance is 1 ("ABC")
    
    *HINT: for multiple action build index of all appearance of words, and compare the two list.(binary search O(NlgN) and two pointer O(N))
    
5.  When you throw a ball from floor P and above in a N-layer building, it will break, and throw ball under floor P will be OK. 
    Given you K ball, write program to find out the min times of attempt you need to throw to know P. 
    
    *HINT: a DP Problem*
    
6.  Given a range [a,b], for every integer i in the range, if i is dividable by 3 output a 'Fizz', if i is dividable by 5 output a 'Buzz', 
    if i is dividable by 5 and 3, output a 'FizzBuzz'.
    
    If have multiple divider, put divider and words in a HashMap, like {3: “Fizz”, 5:”Buzz”}, any way to optimize the process.
    
    *HINT: placeholder array*
    
7.  Given an N * M matrix as positive integer, start from (1,1) to (n.m), find the max path.
    
    If you could go K times, and each time if the ceil is already used, it's value will be set to 0. find the max value could get after K round.
    [Question Detail](http://www.ninechapter.com/problem/26/)
    
    *HINT: Problem 1 is standard DP problem, and Problem 2 should build a Flow Network and run Max Flow algorithm (not used in interview usually). 

8.  **Given N element array, need query the GCD of arbitrary sub-array. Find a way to pre-process and accelerate the query.** 
    Additional space complexity within O(N)
    
    IF N array change to N * N matrix, and need query GCD of arbitrary sub-matrix.
    
    *HINT: Interval Tree, Interval Tree can used to save the result of sub-interval [i,k], [k+1,j], and GCD(i,j) = GCD(gcd[i,k], gcd[k+1,j])
     So the space is O(N), and query is O(lgN)*
    
9.  **Given a N * M matrix and K point in it. Find a point in matrix make the minimize sum distance to all K points.**
    The distance is Manhattan distance:|x0-x1| + |y0-y1|. 
    
    If the point shouldn't overlap in any of K points.
    
    *HINT: consider x and y separately. If in one dimension, point should be the median. Non-overlap: if exist in K points, put it's surrounding in heap, until poll an un-overlap point.*

10. Given a string only contains 0 and 1, find the longest substring which contains the same number of 0 and 1.

    *HINT: Prefix sum array for all the sub-array problem, change 0 into -1, so find the sub-array which sum is 0. Time: O(N) using HashMap.*
    
11. **Given a array without duplicate integer, create a MaxTree based on the array. The root of MaxTree is the max element in the array, 
    and left subtree build by the left part of the max element in the array, and right subtree is build by the right part.**
     
    *HINT: find the parent of each node, it should be the closest element in left/right which larger than current node. Using Stack to optimize the whole process to O(N).
     Always keep an decrease sequence in the Stack, pop element out if smaller than current, and set left/right during the push and pop.*

12. Given an array contains positive and negative integer, reorder the array to make it in ZigZag pattern(one positive and one negative), put needless number at the end of array.
    Require O(1) space.  For example: [1, 2, 3, -4]->[-4, 1, 2, 3]，[1,-3,2,-4,-5]->[-3,1,-4,2,-5]
    
    If need retain the original sequence in the array, how to achieve. 
    
    *HINT: order-matter-less use swap O(N), and order-matter use rotate: 1 2 3 -4 -> rotate 1 step right from 2 to -4 to get 1 -4 2 3, O(N^2).
     Remember check sequence should start with positive or negative, can use flag(-1,1) to check if number is expected (number * flag > 0).*
     
13. Implement a Queue have 4 interface: offer(), poll(), peek() and min();

    *HINT: Stack is good data structure to keep min/max, 2 stack can implement Queue.*
    
##Book: Silicon Valley Interview

1.  Searching in a special matrix, each row in the matrix is sorted and the first element of each row is larger than
    the last element in previous row. 
    
    *HINT: BinarySearch, convert searching offset into row and col in the matrix*

2.  Given several interval, find how many interval have overlap.

    *HINT: sort the interval by start, and scan*
    
3.  Given N integer, N is even number, write code to check if could find N/2 pair in the array, the sum of each pair
    could be divided by K. Each element can only use once.
    
    *HINT: count mod*
    
4.  Given two int array A and B with same length, each one indicate a number, such A=[1,2,3,4] = 1234, B=[2,4,1,0] = 2410.
    Write code to find the closest number C larger than B, C is re-arranged from A
    In the previous case C = [2,4,1,3].
    
    *HINT: sort A and generate C based on B*
    
5.  Given N points in a canvas, write code to find the K points closest to (0,0).  
    
    *HINT: Max Heap*

6.  Given a int array numbers[], and a int K, find the least subset(smallest subset) which sum > K.
    
    *HINT: Greedy, select bigger number, QuickFind with tracking sum*
    
7.  Find the Lowest Common Ancestor of two nodes in a BST.
    
    *HINT: check the range*

8.  **Find the Lowest Common Ancestor of two nodes in a Generic Tree.**
    Here generic tree is a tree which node may have more than 2 nodes.
    
    *HINT: BSF find the two nodes, and compare the path.* 
    
9.  Given a BST, find K nodes closest to given M.
    
    *HINT: Max Heap + In Order Traverse*

10. **Implement a Iterator for BST, space complexity O(lgN).**
    
    *HINT: the iteratively implementation of in-order traverse.*

11. **Given two string S and T, print out all the string interleaving of S and T.**
    
    *HINT: Recursive like Combination*

12. Given a int array num[], find all offset i which i's left elements <= num[i], and i's right elements >= num[i]
    Assume num[-1] = Integer.MIN_VALUE and num[num.length] = Integer.MAX_VALUE;
    
    *HINT: scan forward and backward.*

13. **Given two array A and B, the length is m and n, m < n.** 
    Insert (n-m) numbers of 0 in A to make get the smallest A * B, return the product value.
    
    Example: A = {1, -1} B = {1,2,3,4}, insert A'={1, 0, 0, -1}  A' * B = -3 return -3
    
    *HINT:DP problem, State Definition is product[i][j] is the min product of A[0]...A[i-1] * B[0]...B[j-1]*
         
    *when i == j; product[i][j] = A[i] * B[j] + product[i-1][j-1];*
         
    *when 0 < i < j <= i + n - m; product[i][j] = min(A[i] * B[j] + product[i-1][j-1], product[i][j-1])*

14. Have a task to paint the house in a street, and the color of house can't be the same as it's neighbors. 
    Each color have different price. Find out the min cost to paint the whole street.
    
    *HINT: Greedy, select two cheapest, and paint one by one*

15. Given a input string, and several character transform rules, print out all the string can be transformed.
    For example: input "face", rules are 'a'->'@','e'->'3','e'->'E', and the output: fac3,facE,f@ce,f@c3,f@cE
    
    *HINT: Combination with Reuse*
    
16. Given a directly graph, find how many ways to travel from node A to node B with N steps. 
    Node can visited multiple times.
    
    *HINT: BST with N steps without tracking visited*
    
17. **Given a BST, search all nodes between to two given elements.**
    
    *HINT: In order traverse*

18. **Print the path from root to each leaf node non-recursively.**

    *HINT: based on iteratively post order traverse*
    
19. **Given a BST and int K, find two nodes in the BST which sum is K, space complexity O(lgN)**
    
    *HINT: using two stack, like iteratively in order traverse*
    
20. Given a Yang Matrix, find K-th smallest element
    
    Yang Matrix is a 2-dimensional matrix, which row and col are sorted, but the first element in current row 
    may not be larger than last element in previous row, like Question 1.
    
    *HINT: MaxHeap, scan from left-up conner to right-down conner*

21. A integer array [1-N]'s signature can be calculate like following:
    
        'D' means current number is in decreasing order, that num[i] > num[i + 1], 
        'I' means current number is in increasing order, that num[i] < num[i + 1].
        For example: "DDIIDI" is the signature of [3,2,1,4,6,5], [4,2,1,3,6,5], etc
    
    Write code to find the smallest array of a given signature.
    
    *HINT: count the generate*
    
22. Write code to check if a given number is an aggregated number.
    A aggregated number is a number can be partitioned into several part, and part[i] = part[i - 2] + part[i - 1]
    For example: 112358 is aggregated number [1,1,2,3,5,8]; 122436 is aggregated number as well, [12,24,36]
    
    *HINT: try different partition, until find a partition all follow the rule part[i] = part[i - 2] + part[i - 1]*
     
23. **Given a integer array as probability density function of a random number generator.** 
    For example: given int array P, which length is L, return random number r in range [0-L), possibility of i is P[i]/sum(P)
    
    *HINT: convert the int array to range array (0-sum[P]), generate int in that range, and map to [0-L) using BinarySearch* 

