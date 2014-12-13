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
    
