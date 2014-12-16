#Question List
**Bold Problem** is **IMPORTANT and HARD/MEDIAN**
    
        Array: Two Pointer, DP, Traversal, Stack/Heap, Permutation/Combination[Back-tracing]
        LinkedList: Two Pointer, DummyHead
        Tree: Traversal(pre, in, post, level), Stack/Queue
        String: DP, Hashing, Stack/Queue/Heap

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
       
24. Given a building with N floor, assume you can move 2^k floor every time and can only go up, k is arbitrary integer. 
    Find out the min time you need move to get to the top floor.
    
    *HINT: 2^k is like binary expression of N. So the problem will change to how many 1 in N's binary expression.*
    
25. Implement a Iterator for a Complex Data Structure. At least have hasNext() and next() method.

    *HINT: flattenElement when create Iterator.*

##Book: Cracking Code Interview

1.  [String] Given a char array, replace ' ' with "%20" in place, assume char[] have enough space.

    *HINT: scan backward with two pointer*
    
2.  [String] Implement a method to perform basic string compression using the counts of repeated characters. For example, the string
    "aabcccccaaa" would become "a2b1c5a3". If the compressed string would not become smaller, just return the original string. 
    
    *HINT: count and use StringBuffer to generate compressed string, check if it smaller when return.*

3.  [String] Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code
    to check if s2 is a rotation of s1 using only one call of isSubstring(). 
    
    *HINT: concatenate s1 with s1, and check if s2 is substring of it.
    
4.  [List] Implement a function to check if a linked list is a palindrome.

    *HINT: Stack and fast/slow pointer, careful about odd/even elements
    
5.  [Design/Stack] Describe how you could use a single array to implement three Stacks.
    
    *HINT: fix capacity is simple to implement for interview. Flexible capacity: When one stack exceeds its initial capacity, we grow
    the allowable capacity and shift elements as necessary.*
    
6.  [Design/Stack] SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
    Implements SetOfStacks with pop(), push(), popAt(int index).
    
    *HINT: List<Stack>, push(): create a new Stack when last is full, pop(): delete last Stack when it's empty*
    
7.  [Design/Stack] Implement Hanoi Game
    
    *HINT: Divide and Conquer. simplify the game when only 2 disk, move 1 to tower[1], move 2 to tower[2], then move 1 to tower[2]. 
    So the generic solution is: move n-1 dish to tower[1] using tower[2] as buffer, move n to tower[2], move back n-1 dish to tower[2] using tower[0] as buffer.
    
8.  [Stack]Sort the elements in the stack in ascending order.
    
    *HINT: use an additional stack keep pushing element in decreasing order.*
    
9.  [Tree] Given a binary tree, design an algorithm which create a linked list of all the nodes at each depth.

    *HINT: Level-order traversal, Queue or Level Array.*
    
10. [Tree] Given a binary tree, design an algorithm to find the common lowest ancestor of two given nodes.

    *HINT: based on post-order traversal.*
    
11. [Tree] You have two very large binary trees: T1 with millions of nodes, and T2 with hundreds of nodes. Create an algorithm to decide 
    if T2 is a subtree in T1. T2 is subtree of T1 if there exists of a node n in T1, if you cut off the tree at node n, the two trees
    would be identical.
    
    *HINT: Different approach for T1 T2 balanced or un-balanced. Do some math.*
     
        In small amount of data or balanced case, we could get pre-order and in-order traverse of T1 and T2, and check if the 
        traverse string of T2 is substring of T1. 
        But in this un-balanced case, we could directly do treeMath on every node of T1 if node.val = T2 root.val. 
        Assume the node is selected from 1000 value, so 1000,000 nodes in T1, have 1000 node same as T2's root.
        1000,000(T1) + 1000(same node) * 100(T2) = 1,100,000, it's very near linear time. And no additional space complexity.

12. [Tree] Given a binary tree which each node contains a value, Design an algorithm to print all paths which sum to a given value. The
    path doesn't need to be start from root or leaf.
    
    *HINT: Keep path during traverse, and enumerate all the possible path ended with current node.*
    
13. [Design/BitMap] Implements BitMap, have get(idx), set(idx) and clear(idx) 3 method.
    
    *HINT: BitMap use int[]/long[] buffer to store bits(32bit/64bit).* 
    
        The range of BitMap, the max range of a BitMap: 2^31(1-Integer.MAX_VALUE) * 2^6(long[]) = 2^37 bit
            could mark 2^37 elements = 2^7G elements = 128G elements
            storage: 2^37 bit = 2^34 byte = 2^4 G = 16G
        If use int[] 2^31 * 2^5 = 2^36 bit = 64G elements, storage: 8G

14. **[Bit] Given a positive integer, print the next smallest and previous largest number that have the same number of 1 bits in their binary 
    representation.**
    
    *HINT: use bit operation, count 0 and 1 backwards.*
    
        For next smallest number: flip rightmost non-tailing zero to one, and move rest 1 to rightmost
            scan backwards: count 0, count 1. 
                int p = c0 + c1;
                n |= 1 << p;              //| 00000100000    rightmost zero to one
                n &= ~((1 << p) - 1);     //& 11111100000    clear left of rightmost to zero
                n |= (1 << (c1 - 1)) - 1; //| 00000000011    put rest 1 to the end
            simplify way is: n + (1 << c0) + (1 << (c1 - 1)) - 1;
        For previous largest number: flip rightmost non-tailing one to zero, and put rest 1 to leftmost
           scan backwards, count 1, count 0.
                int p = c0 + c1;
                n &= ((~0) << (p + 1));        //clear from bit p onwards
                int mask = (1 << (c1 + 1)) - 1;//sequence of (c1 + 1) ones
                n |= mask << (c0 - 1);
            simplify way is: n - (1 << c1) - (1 << (c0 - 1)) + 1;
            
15. [Bit] Write a function to determine the number of bits required to convert integer A to integer B.

    *HINT: count how many 1 in (A xor B). Count could use A & (A-1) to flip rightmost 1.*
    
16. [Bit] Write a program to swap odd and even bits in an integer with as few instructions as possibility.

    *HINT: ((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1)
    
17. **[Bit] An array A contains all integer from 0 through n expect for one number which is missing. You can only access jth bit of 
    one element in A. Write code to find the missing integer. Can you do it in O(N)?**
    
    *HINT: if n % 2 == 1, count(0s) == count(1s), if n % 2 == 0, count(0s) = count(1s) + 1, we could do same check on each bit.
    
18. [DP] A child is running up a staircase with n steps, and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method
    to count how many possible ways the child can run up the stairs.
    
    *HINT: ways[1] = 1, ways[2] = 2; ways[3] = 4; ways[i] = ways[i - 3] + ways[i - 2] + ways[i - 1]. 
     Be careful about initial way[3] not 3 but 4.*
      
19. [BinarySearch]A magic index in an array[0...n-1] is defined to be an index such that A[i] = i. Given a sorted array of distinct integers. 
    Write a method to find a magic index, if one exist in array. And if the values are no distinct.
    
    *HINT: binary search, find element value = index. When have duplication, need search both left and right, but can use array[mid]
     to adjust the range: left: (low, min(mid - 1, array[mid])) and right: (max(mid + 1, array[mid]), high)*
     
20. [DFS] Implement the "paint fill" function: given a picture (2-dimensional matrix) and a point, and a new color, fill in the surrounding
    area until the color changes from the original color.
    
    *HINT: standardized DFS, careful about range check.*
    
21. [DP] Given an infinite number of quarter(25 cents), dimes(10 cents), nickels(5 cents) and pennies(1 cents). Write code to calculate
    the number of ways of representing n cents.
    
    *HINT: standardized DP, case i % 5 == 0, i % 10 == 0 and i % 25 == 0, not minus >= 0.*
    
        Like decode ways, ways[i] = ways[i - 1] when valid, and for special case i % 5/10/25 == 0, add ways[i-5/10/25]
        Be careful about when is mod and when is minus.
        
22. [DP] You have a stack of n boxes, with widths wi, height hi and depth di. The boxes can't be rotated and can only be stacked on top of 
    one another if each box in the stack is strictly larger than the box above it in width, height and depth. Implement a method to 
    build the tallest stack possible, where the height of a stack is the sum of the heights of each box.
    
    *HINT: height[i]: the max height is box i as the last box in the stack, and height[i] = boxes[i].height for initialize.
     height[i] = boxes[i].height + max(height[j]) for every j < i and canPutOnTop(boxes[j], boxes[i]) 
        
23. **[DP] Given a boolean expression consisting of the symbol 0,1,&,| and ^, and a desired boolean result value result. implement a function
    to count the number of ways of parenthesizing the expression such that it evaluates to result.**
    For example: expression: 1^0|0|1, and desired result is 0. 2 ways: 1^((0|0)|1) and 1^(0|(0|1)).
    
    *HINT: Top-down DP using a memo (HashMap<String, Integer>).*
    
        The total solution of adding parenthesize in a n operator expression if a Catalan Sequence. 
        So put result == true in the memo, and result == false is total - memo.get(). 
        Analysis every operator in the expression base different operator & and | and ^. (different left and right)
             op == &: true & true
                ways(whole, true) = ways(left, true) * ways(right, true).
             op == |: true | true, true | false, false | true, so ^(false | false)
                ways(whole, true) = total(left) + total(left) - (ways(left, false) * ways(right, false))
             op == ^: true ^ false and false ^ true 
                ways(whole, true) = ways(left, true) * ways(right, false) + ways(left, false) * ways(right, true).
        When only one character(start == end) when char == 1, ways = 1 and when char == 0, ways = 0;
        
24. [Math] Write an algorithm which computes the number of trailing zeros in n factorial.

    *HINT: n factorial have trailing zero by 2 * 5, so count how many number dividable by 5 from 1 - N.*
    
25. [Math] Write a method which finds the maximum of two integers without using if-else or any other comparison operator.

    *HINT: Look the sign of a - b by multiplication. Be careful about overflow.* 
    
26. [String] The game of Master Mind

        The computer has 4 slots, and each slot will contain a ball that RED, YELLOW, GREEN, BLUE. The user try to guess the solution. 
        When you guess the correct color for the correct slot, you got a hit. 
        When you guess a color exist but not in the correct slot, you got a pseudo-hit. 
        Note that a slot that is a hit can never count as a pseudo-hit.
        Example: the solution is RGBY, you guess GGRR, you got one hit and one pseudo-hit.
        Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
        
    *HINT: Careful about the edge case: calculate HITs before Pseudo HITs, and decrease counter when found a HIT to avoid double count.*

27. **[Array] Given an array of integer, write a method to find indices m and n such that if you sorted element m through n, the entire
    array would be sorted. Minimize n - m.(that is find the smallest such sequence.)**
    
    *HINT: m is the leftmost element that its right have an element < array[m], and n is the rightmost element that its left have 
    an element > array[n].*
    
        The problem can be solve scan 4 times:   Space: O(N)
            1. scan right-left to find min[]
            2. scan left-right to find leftmost element i that min[i] != array[i]
            3. scan left-right to find max[]
            4. scan right-left to find rightmost element j that max[j] != array[j]
            (i, j) is the range
        Or we can reduce the scan to 2 times:   Space: O(1)
            1. scan right-left to find the longest increasing sequence.  
            2. scan left-right to find the longest decreasing sequence.
            after 2 scan, array can be divide into (left in increasing) (mid) (right in decreasing)
            3. find the min and max of mid, min = leftEnd + 1, max = rightBegin - 1; scan mid if have. (if left and right no overlap have mid)
            4. shrink leftEnd to element[i] < min, shrink rightBegin to element[j] > max, find the range of mid.
            return the range of mid. 
            Since right-left is increasing and left-right is decreasing order, 1&2 1 times, 3&4 1 times = 2 times.
      
28. [String] Given any integer, print an English phrase that describes the integer (e.g. "One Thousand, Two Hundred Thirty Four").
    
    *HINT: recursion on thousand/million/billion, different method of number < 1000. Careful about teens and tens.*
    
        digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        tens = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        bigs = {"", "Thousand", "Million", "Billion"};
        
29. **[DP] Given a dictionary, design an algorithm to find the optimal way of unconcatenating a sequence of words.** 
    In this case, the optimal is defined to be the parsing which minimizes the number of unrecognized sequences of characters.
    For example "jesslookedjustliketimherbrother", parsed as "JESS looked just like TIM her brother", JESS and TIM is 
    unrecognized sequences marked as CAPITAL.
    
    *HINT: TrieTree and Memo DP.*
        
        memo[start]: record the tokenized result of substring(start). 
        during the tokenize, consider three case: 
            1. substring(start, end) is a word, so it can break, and continue to (end, end + 1) and extend (start, end + 1)
                return a better solution with min unrecognized characters.
            2. substring(start, end) is not a word, but it's a suffix of other word, need extend (start, end + 1)
            3. substring(start, end) is not a word and not a suffix, mark current word to UPPERCASE.
        Need extend TrieTree to support partialMatch to check suffix.
    
30. [Math] Write function to add two numbers without using + or any arithmetic operators.

    *HINT: use bit manipulation, calculate sum and carry separately.*
    
31. [Math] Write a method to shuffle a deck of cards[1-52] perfectly. 

    *HINT: generate from right-left, for i-th element, generate random int r [0-i], swap(r, i).*
     
        for i-th element, if could have 
            1/i+1 (i-position swap) + i+1/i+2 (i+1 position swap) + i+2/i+3 ... + n-1/n (n-position) = 1/n
        It's a perfect shuffle.
        
32. [Math] Write a method to randomly generate a set of m integers from an array of size n. Each element  must have equal probability.
            
    *HINT: put array[i] in the set when i < m, for each j >= m, generate r [0,j], if r < m, swap(j,r), else discard it.
    
33. **[Math] Write a method to count the number of 2s that appear in all the numbers between 0 and n (inclusive).  More generic question is
    write function to calculate how many M(1~9) appear in 0 and n (inclusive).**
 
    *HINT: analysis one bit by one bit by calculate: full_count, times, low_number.*
        
        initialize: count = 0; times = 1; low_number = 0; full_count = 0;
        function:   while(n > 0) 
                    int mod = n % 10; get the rightmost bit
                    if mod > M:  count += times + mod * full_count;
                    if mod == M: count += low_number + 1 + M * full_count;
                    if M != 1 and mod == 1: count += mod * full_count;
                    n = n/10; low_number += mod * times; full_count = 10 * full_count + times; times *= 10; 
                    
34. **[String/DP] Given a list of words, write a program to find the longest word made of other words in the list.**

    *HINT: sort the words by its length. check if the word can be break to several parts from the lists.
     Use a memo to avoid duplicate calculation, and be careful about to handle the original word case.*
     
35. **[String/TrieTree] Given a string S and an array of smaller string T, design a method to search s for each small string in T.** 
    For example: S = "abcbdefcd", T = {"ab", "abc", "def", "cd"}.
    
    *HINT: Trie Tree and Suffix Tree.*
    
        SuffixTreeNode is a TrieNode, char value, Map<Character, SuffixTreeNode> children, List<Integer> indexes.
        2 method: 
            insert word: recursively insert word from this node.
                if word == null || word.length == 0 return;
                char first = word.charAt(0);
                SuffixTreeNode child = children.get(first); //create new if doesn't exist and put in children.
                child.indexes.add(index);
                child.insert(word.substring(1), index);
            search word: recursively search word in the subtree of this node.
                if word == null || word.length == 0 return this.indexes;
                char first = word.charAt(0);
                if(children.containsKey(first))
                    return children.get(first).search(word.substring(1));
                else return new ArrayList();
    
36. [Heap] Numbers are randomly generated and passed into a method. Write a program to find and maintain the median value as new value
    are generated.
    
    *HINT: Using Heap, have a median, and keep maxHeap in the left and minHeap in the right, and keep two heap size different <= 1.
     This problem also could be solved using BST, but need rotate BST, much complicated than Heap.*
    
37. **[Matrix] Imagine you have a square matrix, where each cell is either black or white. Design an algorithm to find the maximum subsquare such
    that all four borders are filled with black pixels.**
    
    *HINT: Loop on the square size K (matrix.length ~ 1), for start left-top point row, col, to find if could get a square size K with
     black border. O(N^4). The process could be optimized by make find square into O(1). By pre-processing to calculate the continuous
     black border from right-left and down-up.*
    
38. **[String] Given a list of millions of words, design an algorithm to create the largest possible rectangle of letters such that every row 
    forms a word (reading from left to right) and every column forms a word (reading top to bottom). The words need not be chosen consecutively
    from the list, but all rows must be the same length and all columns must be the same height.**
    
    *HINT: This problem is very complicated, include Trie, Back-tracing, etc.*
    
        Many problems involving a dictionary can be solved by doing some pre-processing.
        1. Group the words by it's length.
        2. Max rectangle should be size as longestWord * longestWord
            for z = maxRectangle to 1 {
                for each pair of numbers(i, j) where i*j = z{
                    attempt to make rectangle, return if successful.
                }
            }
        3. To makeRectangle(i, j), select j words from words length is i, to make each column is also a word length j.
           This operation could be optimize by build a Trie to easily lookup if a substring is a prefix of a word in the dictionary.
           If YES, continue to build, if NO, backtrace to previous word selection.

39. [Math] There are three ants on different vertices of a triangle. What is the probability of collision (between any two or all of them)
    if they start walking on the sides of the triangle? assume each ant randomly pick a direction.
    
        Answer: 
            clockwise: (1/2)^n, counter clockwise: (1/2)^n, so the same direction: (1/2)^n-1
            so collision: 1 - same direction = 1 - (1/2)^n-1
            when n = 3, collision probability: 3/4
            
40. [Math] Given two squares on a two-dimensional plane, find a line that would cut these two squares in half. Assume that the top and 
    bottom are parallel to the x-axis.
    
        Answer:
            the line can partition two squares in half is the line connect the two middles.
                     
41. [Array]A circus is designing a tower routine consisting of people standing atop one another’s shoulders for practical and 
    aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
    Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people 
    in such a tower. 
    
        EXAMPLE:
              Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 105) (68, 110)
              Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (65,100) (68,110) (70,150) (75,190) 
   
    *HINT: sort people by ht, and find the longest sub-sequence which person[i].ht < person[j].ht && person[i].wt < person[j].wt, 
     using DP method.* 