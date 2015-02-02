#Non Leetcode Interview Question from http://www.fgdsb.com/

1.  [L] Factor Combinations: Print all unique combination of factors (except 1) of a given number. 

    *HINT: do combination of all the elements in [2 ~ N/2] which make M divisible.* 
    
2.  [G] Implement a PeekIterator, with three method: hasNext(), next(), peek(). peek() only get the element not 
    moving cursor forward. 
    
    *HINT: when call peek(), call next() and use a refer to peekedElement. when call next(), if peekedElement is null, 
    return next(), if not null, return peekedElement and set it to null.*

3.  [F] PrettyBSTPrinter, Print a BST such that it looks like a tree (with new lines and indentation, the way 
    we see it in algorithms books). 
    
    
                 4                or      3         
           2           6               1     4   
        1     3     5     7               2     5      
                             8

    *HINT: get max height of the tree, and calculate spacing based on complete tree, for node even null print.*

4.  Meeting Rooms: Given a array of pairs where each pair contains the start and end time of a meeting (as in int),
    Determine if a single person can attend all the meetings
    For example: Input array { pair(1,4), pair(4, 5), pair(3,4), pair(2,3) }, Output: false;
    Follow up: determine the minimum number of meeting rooms needed to hold all the meetings.
    Input array { pair(1, 4), pair(2,3), pair(3,4), pair(4,5) }; Output: 2
    
    *HINT: create a int[] array put start and end(use negative number to mark) to the array, sort it using abs value, 
    check if the array is interleaving for question1. 
    For question2, check how many consecutive start together, tracking the max count.*
    
7.  [G] ZigZag Iterator: Implements a ZigZagIterator, init with two iterators, and visit them alternantly. Omit the empty one. 
    For example: A: 1234, B: abcd, the output is：1a2b3c4d，
    
    *HINT: keep a index of which iterator is visiting, and do cyclic update of the index: index = (index+1)%N;
    when getNext(), update index until found a iterator hasNext() return true within one round, hasNext() just return 
    currentIterator.hasNext().* 
    
8.  [G] Intersection of Two Quadtrees.
    Given a quadtree structure:
        
        class QuadNode {
            int ones = 0;
            QuadNode[] children = new QuadNode[4];
        };
        
    Please build a quadtree to represent a 0-1 matrix, assume the matrix is a square and the dimension is power of 2.
    Given two such quadtrees with same depth, please write a function to calculate how many 1s are overlapped.
    
    *HINT: keep a length, if length == 1, return a QuadNode(value), if length > 1, split the matrix into 4.
    The intersection can be calculate using divide and concur, if either nodes.ones == 0, return 0, if is leaf, return 1, if
    not leaf, recursively call its children.*
    
9.  [F] **Valid Tree**. There are n nodes numbered from 0 to n-1 and a set of edges (undirected). Please determine if it is 
    a valid tree. For example: n = 5, edge set = {{0,1}, {0,2}, {2,3}, {2,4}}, Result: true
    n = 5, edge set = {{0,1}, {1,2}, {0,2}, {2,3}, {2,4}}, Result: false
    
    *HINT: sort the edge set by start, do BFS and check if the edges is connected in layer. another solution is using
    UnionFind, each node can only have one parent defined by one edge. Remember to check all the nodes is visited or 
    all nodes have one parent after scan the edges.*
    
10. [F] Group Contacts. Having a class Contact, define as following
        
        class Contact{
            String name;
            List<String> emails;
        }
    Given a list of Contact, please write code to group the contacts by person. You can determine the two contact if same person
    if they have one or more same email.
    
    *HINT: Find communities in a un-directed group, so use UnionFind.*
    
11. [Airbnb] **Get Similar Words**: Given a word list and a target word, write code to find words in list which edit distance to 
    target word is not larger than K.
      
    *HINT: Trie can used to find words which edit distance is not larger than a given K, using getFuzzyWords in DZ22_Tries, it can 
    find all words in Trie with K missingLetters.* 
    
12. [G] **WiggleSort** sort the array following a1 <= a2 >= a3 <= a4 >=...

    *HINT: simple solution could use swap(i, i+1) when is not follow the rule. Better solution is use a current to tracking the 
    current non-placed value.*
    
13. [G] Timer Callback Register. Given a system function to register a callback method at given time:
        
        register_system_timer_callback(long time, Callback callback)
    When given time is now or past, system will immediate call the callback. And only one callback method can register, the new 
    registration will override the previous one if not called yet.
     
    Use the interface, to implement a Register take multiple system timer callback registration.
    
    *HINT: use a TreeMap to hold all the registered callback use time as key, tracking current registered callback using currentTimer, 
    create a Wrapper of Callback to register next callback when this one is executed.*
    
14. [G] Maximum Length of the Loop: Given two arrays: Indexes 0 1 2 3 4 and Values 3 2 1 4 0. 
    Values are the next index of the jump 0 -> 3 -> 4 -> 0... 1 -> 2 -> 1...
    Write a function to detect if there are loops. If yes, get the max length of the loop possible, otherwise just return zero.
    
    *HINT: the problem is find the longest cycle in directed graph, do DFS and marking visited and tracking the length.*
    
15. [G] Sums of All Subtrees: Given a TreeNode array, each one have a id, a parent_id, and a value.
    Find out the sum value of all subtrees.
    
    *HINT: do DFS(bottom-up) on the (id,parent_id) to calculate the level of each nodes, then calculate subtree sum from bottom-up.*
    
16. Nested Iterator: Program an iterator for a List which may include nodes or List. 
    For example: {0, {1, 2}, 3, {4, {5, 6}}}, Iterator returns 0 1 2 3 4 5 6
    
    *HINT: use Stack like do pre-order-traversal for trees.*
    
17. [G] **Merge Two BST**: You are given two balanced binary search trees. Write a function that merges the two given balanced 
    BSTs into a balanced binary search tree. Your merge function should take O(M+N) time and O(1) space.
    
    *HINT: first flatten BST into linkedlist, then merge the two sorted linkedlist, then build the new BST.*
    
        Flatten: use DummyNode and do in-order traversal and keep tracking last visited.
        Build BST: divide by length, if length == 0 return null, else length == 1, reset right and return the node, 
            else build left using length/2, and build node, build right using length - length/2 - 1;
            
18. [G] Smallest Range: You have k lists of sorted integers. Find the smallest range that includes at least one number from each 
    of the k lists. 
    For example, List 1: [4, 10, 15, 24, 26]; List 2: [0, 9, 12, 20]; List 3: [5, 18, 22, 30]
    The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
    
    *HINT: like K-merge, use a PriorityQueue of K list, pop() the min and update the range.*
    
19. [G] Array Combination: Given A,B,C 3 list of Strings, find out all combination built by select one from each, if empty 
    just go over it. Don't need consider duplications.
    
    *HINT: be careful about empty list case, it may break inner loops. so delete empty list first.*
    
20. [G] All Factors of the Product of a List of Distinct Primes: 
    Print all factors of the product of a given list of distinct primes.
    Example: Input: 2 3 7, Output: 1 2 3 6 7 14 21 42
    
    *HINT: same as subset combination, don't forget 1.*
    
21. [G] Count the Number of 1s in 32-bit Integer. 

    *HINT: loop and non_loop version.*
        
        loop version:
            int count = 0;
            while(x != 0) {
                count += x & 1;
                x >>= 1;
            }
            return count;
        un_loop version: do add by 2 bits unit, 4 bits unit, 8 bit unit and 16 bit unit.
            x = ((x & 0xAAAA) >> 1) + (x & 0x5555);
            x = ((x & 0xCCCC) >> 2) + (x & 0x3333);
            x = ((x & 0xF0F0) >> 4) + (x & 0x0F0F);
            x = ((x & 0xFF00) >> 8) + (x & 0x00FF);
            return x;
            
22. [G] Valid Rolling String: Given a String s, check if s contains all presentation of K digits base A numbers, and no invalid number. 
    For example: s = "00110", A=2, K=2 => true (s contains 00，01，10，11)
    
    *HINT: use rolling hash, base = base * A + current, if idx >= K, need do base -= charAt(idx - K) * Math.pow(A, K-1);
    use a boolean[] to mark and count.*
    
23. [G] Given a String only contains A, B and C, and the three characters can be put in 3 consecutive char.
    Find out how many valid string of length N.
    
    *HINT: a DP problem, state can define as two cases.*
    
        same[i] = the count of strings char(i) == char(i-1), diff[i] = the count of strings char(i) != char(i-1).
        initial: same[0] = 3, diff[0] = 0;
        function: same[i] = same[i-1] + diff[i-1], diff[i] = same[i-1] * 2 + diff[i-1].
        result: same[N-1] + diff[N-1];
        since same and diff only related to previous state, can only O(1) space.
        
24. [L] Isomorphic Strings: Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic if 
    the letters in one word can be remapped to get the second word. Remapping a letter means replacing all occurrences of it with another 
    letter while the ordering of the letters remains unchanged. No two letters may map to the same letter, but a letter may map to itself.
    For example: given "foo", "app"; returns true, we can map 'f' -> 'a' and 'o' -> 'p'; given "bar", "foo"; returns false, we can’t map 
    both 'a' and 'r' to 'o'.
    
    *HINT: check length, scan the two words to build the mapping rules, and check if have conflict.*
    
25. [G] **Drawing the Skyline** a building is identified by (left, height, right), given a list of buildings, they may have overlap. Write
    code to draw the skyline of given list of building. A skyline is the max border of all the buildings.
    Detail diagram refer to: http://www.fgdsb.com/2015/01/13/drawing-the-skyline/
    
    *HINT: It's like merge interview in 2D.*
    
        Using sweep line:
            1. sort building by their left coordinate.
            2. scan the building using a sweep line, keep current height, use a PriorityQueue to hold the right of building.
                pop building in heap which end before building[i].left, and also update height.
                if(building[i].height > height) update height and add points in skyline.
                add building.right to the heap.
        Time complexity is: O(NlgN).

26. 
                                
        
    
        
        
    
    

    
    




        
                            