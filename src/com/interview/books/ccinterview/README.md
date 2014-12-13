#Interview Question in Cracking Code Interview

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
