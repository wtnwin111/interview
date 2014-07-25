#Useful Interview Question Links:
    http://www.careercup.com/page
    www.codechef.com
    www.topcoder.com
    http://www.leetcode.com
    http://www.hackerrank.com/
    http://codekata.pragprog.com/2007/01/code_kata_backg.html#more
    http://geeksforgeeks.org/forum/forum/interview-questions
    http://www.impactinterview.com/2009/10/140-google-interview-questions/#software_engineer
    Dynamic Programming: http://hawstein.com/posts/dp-novice-to-advanced.html

#Categorized Interview Questions:

##C1: General
    1) Given a function which produces a random integer in the range 1 to 5, write a function which produces a random integer in the range 1 to 7.
    2) Write a regular expression which matches a email address. (Ramp up Regular Expression)
    3) Implement Union Find, which is used for connectivity detection: http://algs4.cs.princeton.edu/15uf/
    4) Write a function (with helper functions if needed) called to Excel that takes an excel column value (A,B,C,D,..Z,AA,AB,AC,..,ZZ,AAA..) and returns a corresponding integer value (A=1,B=2,..,AA=26..).
    5-N) You have a stream of infinite queries (ie: real time Google search queries that people are entering). Describe how you would go about finding a good estimate of 1000 samples from this never ending set of data and then write code for it.*
    6-N) What method would you use to look up a word in a dictionary?
    7-N) Find or determine non existence of a number in a sorted list of N numbers where the numbers range over M, M>> N and N large enough to span multiple disks. Algorithm to beat O(log n) bonus points for constant time algorithm.
    8-N) Given a file of 4 billion 32-bit integers, how to find one that appears at least twice?
    9) Given a set of coin denominators, find the minimum number of coins to give a certain amount of change. Same Problem with C12_2
    10) Given a set of ranges, find the two ranges with the greatest overlap.
    11) Given a time, calculate the angle between the hour and minute hands
    12) Design a algorithm to point all permutation of a string, assume all the character are unique  same as C11_4
    13) Numbers are randomly generated and stored in an array. How would you keep track of the median.
    14) Write a method to get the greatest common divisor(GCD) of two given integer.
    15) Write a method to transfrom a string to int.
    23) Given an arithmatic expression, evaluate the value of the expression, suppose the expression only contains "+", "-", "*", "/", "(", ")" and numbers are integers.
    24) Verify whether an arithmatic expression is valid, suppose the expression only contains "+", "-", "*", "/", "(", ")" and numbers are integers.
    25) The bet problem
    26) Count the amount of '1's in an integer's binary form
    27) There are k exactly same boxes, and we have to put n exactly same items into them. Assume there is no limitation on box, and the only requirement is that each item should be put into one box. Please write out the code to print out all the possible possibilities, print error the input can not get any result.
    28) Get the amount of ending zeros of N! without calculating N!
    29) Find un-duplicate integer number in 250 million integer.
    30) Remove all the number contains 7 from the integer, and define a method to return corresponding number when giving a regular number
    31) Given a string, rearrange the string to a palindrome and return the palindrome if present or -1
    32) Given a capacity value N, and a set of different Item types with values v1, v2, ...,vn
         1) Existence Check: check whether N can be filled with a certain combination of items
         2) All Combinations: get all the combinations of items that fills N
         3) Minimum Combination: get the minimum number of items that fills N    Same Problem with C12_2
    33) Given a timer time() with nanosecond accuracy and given the interface
        interface RealTimeCounter:
        void increment()
        int getCountInLastSecond()
        int getCountInLastMinute()
        int getCountInLastHour()
        int getCountInLastDay()
        implement the interface. The getCountInLastX functions should return the number of times increment was called in the last X.
    34）Implement BitSet
    35) Write a function to print out all the amicable numbers pair within 10000;
            amicable numbers pair is the numbers which the sum of its real factor equals to the other. such as 220 and 284;
    36) N integer from 0 - N-1 form a cycle, start to delete number by visit M step. The process is started at 0.
        Given N and M, please write code to calculate which number will last at the final round.
    37) Given a N, write function to calculate how many 1 appear in 1-N.
        Such as 12, it should have 1, 10, 11, 12, and it should return 5.

##C2: CS Theory
    1) What is the difference between a mutex and a semaphore? Which one would you use to protect access to an increment operation?
    2) How are cookies passed in the HTTP protocol?
    3) Design the SQL database tables for a car rental database.
    4) What is multithreaded programming? What is a deadlock?
    5) Implement division (without using the divide operator, obviously).
    6) Suppose you have given N companies, and we want to eventually merge them into one big company. How many ways are theres to merge?
    7) How long it would take to sort 1 trillion numbers? Come up with a good estimate.
    8) What's the difference between a hashtable and a hashmap?

##C3: List
    1) Merge two sorted lists
    2) Given two linked lists A and B, return a list C containing the intersection elements of A and B. The nodes of C should appear in the order as in B.
    3) Given a single list, find the "Mth to the last" element.
    4) Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
    5）Write a routine to reverse every k nodes in a given linked list without using additional memory.
    6) [LeetCode] LRU Cache
    7) We have a linked list as a1,a2,a3...an,b1,b2,b3...bn, we need a rearrange method to rearrange the linked list into
       a1,b1,a2,b2...an,bn
    8) Write code to remove duplicate from an unsorted linked list. How would you solve this problem if a temporary buffer is not allowed? same as C11_9
    9) Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
    10) Write code to partition a linked list around a value x, such that all nodes less then x come to before, all nodes greater than or equal to x.
    11) You have two numbers represented by a linked list, where each node contains a single digit, The digit are stored in reverse order
        617 == 7->1->6
        Write a function to adds the two numbers and returns the sum as a linked list.
    12) Implement a function to check if a linked list is a palindrome.
    13) Write code to check if two linked list have intersection.
    14) Write code to check if a linked list contains cycle.
    15) Write code to reverse a linked list. Try to not using any extra space.

##C4: Array
    1) Given an image represented by an N\*N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
    2) Given an array, find the longest continuous increasing subsequence.
    3) You are given with three sorted arrays ( in ascending order), you are required to find a triplet ( one element from each array) such that distance is minimum. Distance is defined like this : If a[i], b[j] and c[k] are three elements then distance=max(abs(a[i]-b[j]),abs(a[i]-c[k]),abs(b[j]-c[k]))��Please give a solution in O(n) time complexity
    4) Given an array whose elements are sorted, return the index of a the first occurrence of a specific integer. Do this in sub-linear time. I.e. do not just go through each element searching for that element.
    5) Given an array, print the array elements cyclicly from outside to center.
    6) Given an array, use Binary Search to find a given element
    7) Given a sorted array, there is only one value K has multiple occurrence, find the repeating element and its first occurrence.
    8) Find the Kth small element in an array.
    9) Given an array, there is an element whose occurence is greater than the half of the array's length, find this element.
    10) Given an m\*n grid, how many paths are there from the left bottom corner to the up right corner.
    11) Randomly shuffle an array.
    12) Given an array, find all sub-arrays whose elements' sum is equal to a given K.
    13) Given an array containing both positive and negative numbers, find the sub array whose elements' sum is maximum.
    14) Given a set S, find all the maximal subsets whose sum <= k.
    15) Find the uniq amount of absolute values in a given sorted array
    16) Write code to reverse a array of int
    17) There is an array A[N] of N numbers. You have to compose an array Output[N] such that Output[i] will be equal to multiplication of all the elements of A[N] except A[i].
       For example Output[0] will be multiplication of A[1] to A[N-1] and Output[1] will be multiplication of A[0] and from A[2] to A[N-1]. Solve it without division operator and in O(n).
    18) Given two sequences of items, find the items whose absolute number increases or decreases the most when comparing one sequence with the other by reading the sequence only once.
    19) Merge two sorted arrays
    20) How to find the median among the given numbers whose values are unknown but falls into a narrow range.
    21) Array Element Finder
       A) Given a sorted array, write an algorithm to determine whether a given value target exists in the array
       B) For an array whose values first increase and then decrease,
          write an algorithm to determine whether a given value target exists in the array
       C) There are two arrays A1 and A2 sorted in ascending order. The largest value of A2 is smaller than the smallest value of A1.
          Array A3 is formed by appending A2 after A1. Write an algorithm to check whether a given value target exists in array A3.
    22) Closest Pair. Given an int array a[], find the closest two numbers A and B so that the absolute value |A-B| is the smallest. The time complexity should be O(NlogN).
    23) Farthest Pair. Given an int array a[], find the farthest two numbers A and B so that the absolute value |A-B| is the biggest. The time complexity should be O(N).
    24) Given a list of number 0,1; find the start of runs (the length contiguous sequence of 1 is larger than a given number)
    25) You are given an unsorted array of integers that contain duplicate numbers. Only one number is duplicated odd number of duplications, other numbers are repeated even number of duplications. Find this number.
    26) Define a function that takes an array of integer numbers and returns an array of numbers of the same length. Each element of the output array out[i] should
       be equal to the product of all of the elements of the input array except for in[i]. Example: input {1,2,3,4} output {24,12,8,6}
    27) Given a rotated sorted array, the element might appears in the order 3,4,5,6,7,1,2. How would you find the minimum element
    28) Write a algorithm such that if an element in an element in a M*N matrix is 0, it's entire row and column is set to 0.
    29) A int array contains positive and negative number, find the max of sum of continous sub array.
    30）A int array contains 1-N number, only 1 number appear twice, please find the number.
    31) Given two integer N and M, please find all the combination of numbers within[1,N] which sum is M.
    32) Given a array contains all integer, write a code to find a pair integer which sum is a specific number K
    33) Given two int array, one is the push sequence, write function to check if the second one is a pop sequence.
    34) Given two int array, find a switch of the items in the two array to make the SUM of two array closest.
    35) Given two int array, find switches of the items in the two array to make the SUM of two array closest.
    36) Given matrix, find the sub 2 \* 2 array with max sum.


##C5: Tree
    1) Create a binary-tree datastructure, having pre-order, in-order, and post-order traverse.
    2) Tree search algorithms. Write BFS and DFS code, explain run time and space requirements. in C5_1
       Modify the code to handle trees with weighted edges and loops with BFS and DFS, make the code print out path to goal state.
    3) How do you put a Binary Search Tree in an array in a efficient manner.
       Hint :: If the node is stored at the ith position and its children are at 2i and 2i+1(I mean level order wise)Its not the most efficient way.
    4) How do you find out the fifth maximum element in an Binary Search Tree in efficient manner. in BinarySearchTree.select()
       Note: You should not use use any extra space. i.e sorting Binary Search Tree and storing the results in an array and listing out the fifth element.
    5) Given a binary tree, programmatically you need to prove it is a binary search tree.
    6) Given two binary trees, write a compare function to check if they are equal or not.
       Being equal means that they have the same value and same structure.
    7) Given a BinarySearchTree and value K, find all value pairs whose sum is K in O(n).
    8）
    9) Given a list of pairs (a,b) where a is the number of a node and b is its parent, construct a tree and return the root.
    10) Implement a function to check if a tree is balanced. For the purposes of this question,
        a balanced tree is defined to be a tree such that no two leaf nodes differ in distance
        from the root by more than one.
    11) Given a sorted (increasing order) array, write an algorithm to create a binary tree with
        minimal height.
    12) Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in
        a binary search tree where each node has a link to its parent. in BinarySearchTree.successor();
    13) Given a binary search tree, design an algorithm which creates a linked list of all the
        nodes at each depth (i.e., if you have a tree with depth D, you’ll have D linked lists)
    14) Design an algorithm and write code to find the first common ancestor of two nodes
        in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
        necessarily a binary search tree
    15-N) You have two very large binary trees: T1, with millions of nodes, and T2, with hun-
        dreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
    16) You are given a binary tree in which each node contains a value. Design an algorithm
        to print all paths which sum up to that value. Note that it can be any path in the tree
        - it does not have to start at the root.
    17) Write a method to transfer a BinarySearchTree to a sorted LinkedList without using extra space.
    18) Given a sequence of int, write code to check if this the post-order traverse of a binary search tree.
    19) Find the max distance of two node in a binary tree.
    20) Write code to create a mirroring of a binary tree

##C6: Graph
    1) What's the maximum number of edges in a Directed Asynclic Graph with N node.
            1+2+3+...+N-1 = N(N-1)/2
    2) Print all the cycles in a directed graph
    3) Print the minimum spanning tree of a graph
       Find a MST(min-weight spanning tree).
            A spanning tree of G is a subgraph T that is connected and acyclic.
            Algorithm(Greedy): Prim and Kruskal
    4) Implement the DFS and BFS traverse algorithms
    5) Calculate Shortest Path between two given vertexes for weighted graph
       Find the shorted path (smallest weight) from one node to other
            Algorithm:
               *Dijkstra: when all the weight is positive number
               Bellman-Ford: support negative weight and rewrite weight
    6) DAG Graph topological sorting/ordering
    7) Connected Component: Given a directed graph, design an algorithm to find out whether there is a route be-
       tween two nodes.
    8) Is a graph bipartite?
    9) Find a cycle.
    10-N) Eulerian tour. Find a (general) cycle that uses every edge exactly once.
        Is there a (general) cycle that uses each edge exactly once?
        Yes iff connected and all vertices have even degree.
    11-N) Hamiltonian cycle: Find a cycle that visits every vertex exactly once.
    12-N) Are two graphs identical except for vertex names?
    13-N) Lay out a graph in the plane without crossing edges?
    14-N) Find the strongly connected component in directed graph.
       	    Kosaraju-Sharir algorithm
       	    Simple (but mysterious) algorithm for computing strong components.
       	        Phase 1: run DFS on GR to compute reverse postorder.
       	        Phase 2: run DFS on G, considering vertices in order given by first DFS.
    15) Find the shortest path from one node to other.
    16) Write a code to check if there is cycle in a graph

##C7: Stack
    1) How would you design a stack which, in addition to push and pop, also has a function
       min which returns the minimum element? Push, pop and min should all operate in
       O(1) time.
    2) Implement a Queue with Stacks.
    3-N) Implement a Queue with constant stacks, and each queue operation could be done in O(1).
    4-N) Describe how you could use a single array to implement three stacks
    5) Imagine a (literal) stack of plates. If the stack gets too high, it might topple. There-
       fore, in real life, we would likely start a new stack when the previous stack exceeds
       some threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
       Stacks should be composed of several stacks, and should create a new stack once
       the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
       behave identically to a single stack (that is, pop() should return the same values as it
       would if there were just a single stack).
       FOLLOW UP
       Implement a function popAt(int index) which performs a pop operation on a specific
       sub-stack.
    6) In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different
       sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending
       order of size from top to bottom (e.g., each disk sits on top of an even larger one). You
       have the following constraints:
            (A) Only one disk can be moved at a time.
            (B) A disk is slid off the top of one rod onto the next rod.
            (C) A disk can only be placed on top of a larger disk.
       Write a program to move the disks from the first rod to the last using Stacks
    7) Write a program to sort a stack in ascending order. You should not make any assump-
       tions about how the stack is implemented. The following are the only functions that
       should be used to write this program: push | pop | peek | isEmpty

##C8: Sorting
    1) If you have 1 million integers, how would you sort them efficiently?
    2) You are given a small sorted list of numbers, and a very very long sorted list of numbers. so long that it had to be put on a disk in different blocks.
       How would you find those short list numbers in the bigger one?
    3) What sort would you use if you had a large data set on disk and a small amount of ram to work with?
    4) What sort would you use if you required tight max time bounds and wanted highly regular performance.
    5) How to sort integer in O(N)

##C9: Design Patterns and OOP
    1) Design a class library for writing card games.

##C10: System Design
    1) Design and describe a system/application that will most efficiently produce a report of the top 1 million Google search requests. These are the particulars: a) You are given 12 servers to work with. They are all dual-processor machines with 4Gb of RAM, 4x400GB hard drives and networked together.(Basically, nothing more than high-end PC��); b) The log data has already been cleaned for you. It consists of 100 Billion log lines, broken down into 12 320 GB files of 40-byte search terms per line. c) You can use only custom written applications or available free open-source software.
    2) Write a program for displaying the ten most frequent words in a file such that your program should be efficient in all complexity measures.
    3) Create a fast cached storage mechanism that, given a limitation on the amount of cache memory, will ensure that only the least recently used items are discarded when the cache memory is reached when inserting a new item. It supports 2 functions: String get(T t) and void put(String k, T t).
    4) Remove duplicated lines in a very large block of text.
    5) Write a multi-thread program to handle Producer-Consumer Problem.

##C11: String
    1) Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structure.
    2) Write a function f(a, b) which takes two character string arguments and returns a string containing only the characters found in both strings in the order of a. Write a version which is order N-squared and one which is order N.
    3) Given two strings, write a method to decide if one is a permutation of the other
    4) Write some code to find all permutations of the letters in a particular string.
    5) Given that you have one string of length N and M small strings of length L. How do you efficiently find the occurrence of each small string in the larger one?
    6) Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings s1 and s2, write code to check
	   if s2 is a rotation of s1 using only one call to isSubstring (e.g. "waterbottle" is a rotation of "erbottlewat".
    7) Implement a function to reverse a string
    8) Given a string array, find the max common part of all string elements. E.g. the max common string of ["abcde", "abccd", "abc", abcef"] is "abc"
    9) Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
    10) Write a method to replace all spaces in a string with "%20"
    11) Write a method to find the longest common sub sequence (no need to be continuous) of characters of two given string.
    12) Write a method to find the longest common sub string (need to be continuous) of characters of two given string.
    13) Write a method to rotate a given string by K offset.
    14) Write a more effective sort method of strings, need be O(N)
    15) Implement a method to perform basic string compression using the counts of repeated characters.
        For example: aabcccccaaa would become a2b1c5a3
        And if the compressed string is longer then the original one, just return the original.
    16) Write a function effective to sort large set of string
        1. key-indexed counting
        Key-indexed counting is a sub-sort problem, which sort N element have lots of duplication in key,
        which indicate key is much smaller than N.
        Sample application: Sort string by first letter. only have 26 key.
        The solution is
        	use array to counting the number of each key, and calculate the excursion of each key,
        	then directly copy the element to the right location.
        	It's also a stable sort.
        2. LSD radix sort
        LSD radix sort is Least-significant-digit-first string sort, consider characters from right to left.
        Stably sort using dth character as the key (using key-indexed counting).
        Time: 2*W*N (W is a fix length of keys)
        Sample application: Sort one million 32-bit integers.
        	sort the integer by bit, have 0 / 1 two keys, 32*2*2*1M ~= 1M
        3. MSD radix sort
        MSD string (radix) sort is Most-significant-digit-first string sort.
        Partition array into R pieces according to first character (use key-indexed counting).
        Recursively sort all strings that start with each character (key-indexed counts delineate sub arrays to sort).
    17) Write basic functions of String: reverse, suffixes and longest common prefix.
    18) Write code to implement the string match using patten. In patten, could use * as wildcard character, it could match 1-n any character.
    19) Write code to reserve the word sequence. input as I am Stefanie output is Stefanie am I
    20) Substring match: give string A and B, find the first occurence of B in A.

##C12: Dynamic Programming
    1) Boolean Knapsack, Complete Knapsack
    2) Given a list of N coins, their values (V1, V2, ... , VN), and the total sum S.
        2.1) Find the minimum number of coins the sum of which is S
        2.2) Find the required number of each coin, which is the minimum number of coins required to get the sum S.
    3) [top coder] Given a sequence of N numbers - A[1] , A[2] , ..., A[N] .
        Find the length of the longest non-decreasing sequence.
        For example, "5, 3, 4, 8, 6, 7" yields 4 with the sequence "3, 4, 6, 7"
    4) [top coder] Given an undirected graph G having N (1<N<=1000) vertices and positive weights.
    Find the shortest path from vertex 1 to vertex N, or state that such path doesn't exist.          Same Problem with C6_5
    5) [top coder] ZigZag problem: http://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
    6) [top coder] Bad Neighbors: http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
    7) [top coder] Flower Garden : http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
    8) [top coder] Apple Collection: A table composed of N x M cells, each having a certain quantity of apples, is given.
        You start from the upper-left corner. At each step you can go down or right one cell.
        Find the maximum number of apples you can collect.
    9) [top coder] AvoidRoads: http://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
    10) [top coder] ChessMetric: http://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482
    11) Given an undirected graph G having positive weights and N vertices.
        You start with having a sum of M money. For passing through a vertex i, you must pay S[i] money.
        If you don't have enough money - you can't pass through that vertex. Find the shortest path from vertex 1 to vertex N,
        respecting the above conditions; or state that such path doesn't exist. If there exist more than one path having the same length,
        then output the cheapest one. Restrictions: 1<N<=100 ; 0<=M<=100 ; for each i, 0<=S[i]<=100.
    12-N) [top coder] Jewelry: http://community.topcoder.com/stat?c=problem_statement&pm=1166&rd=4705
    13-N) [top coder] StripePainter: http://community.topcoder.com/stat?c=problem_statement&pm=1215&rd=4555
    14) [top coder] QuickSums: http://community.topcoder.com/stat?c=problem_statement&pm=2829&rd=5072
    15-N) [top coder] ShortPalindromes: http://community.topcoder.com/stat?c=problem_statement&pm=1861&rd=4630
    16-N) [top coder] StarAdventure: http://community.topcoder.com/stat?c=problem_statement&pm=2940&rd=5854
    17-N) [top coder] MiniPaint: http://community.topcoder.com/stat?c=problem_statement&pm=1996&rd=4710
    18) [Introduction to Algorithm Chp.15] The assembly line problem
    19) Longest Common Subsequence and Longest Common Substring, see C11_11_LongestCommonSubsequence and C11_12_LongestCommonSubstring

##C13: Path Finding
    To solve a problem when there is no clear algorithm for computing a valid solution, we turn to path finding. In this chapter we will
    cover two related path-finding approaches, one for game trees and the other for search trees. These approaches rely on a common structure,
    namely a state tree where the root node represents the initial state and edges represent potential moves that transform the state into a new state.

    1) Game Tree
        Two players take alternating turns in making moves that modify the game state from its initial state. There are potentially many states in
        which either player can win the game. There also may be some states that are “draws,” in which case no one wins. A path-finding algorithm
        maximizes the chances that a player will win the game (or force a draw).
    2) Search Tree
        A single agent is given a task to accomplish, starting from an initial board state, with a series of allowed move types. In most cases,
        there is exactly one goal state that is desired. A path-finding algorithm identifies the exact sequence of moves that will transform the
        initial state into the goal state.
        
##C14: Network Flow
    Numerous problems that can be viewed as a network of vertices and edges, with a capacity associated with each edge over which commodities flow.
    1) Assignment
        Given a set of tasks to be carried out by a set of employees, find an assignment that minimizes the overall expense when different employees
        may cost different amounts based upon the task to which they are assigned.
    2) Bipartite Matching
        Given a set of applicants who have been interviewed for a set of job openings, find a matching that maximizes the number of applicants
        selected for jobs for which they are qualified.
    3) Transportation
        Determine the most cost-effective way to ship goods from a set of supplying factories to a set of retail stores selling these goods.
    4) Transshipment
        Determine the most cost-effective way to ship goods from a set of supplying factories to a set of retail stores selling these goods,
        while potentially using a set of warehouses as intermediate stations.
    5) Maximum Flow
        Given a network that shows the potential capacity over which goods can be shipped between two locations, compute the maximum flow supported
        by the network.






