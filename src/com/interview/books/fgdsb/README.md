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
    

    
    




        
                            