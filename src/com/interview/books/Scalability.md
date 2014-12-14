#Question List

1.  Design a method to find the frequency of occurrences of any given word in a book.

        Answer based on one-time query or multi-time operation.
        one-time query: scan and count: O(N)
        multi-time query: create an index of words frequency, using HashMap or TrieTree. Time: O(1), 
            HashMap:  Space: O(M) M is the num of word
            TrieTree: Space: O(26^len) len is the largest length of word

2.  You have a large text file contains words. Given any two words, find the shortest distance between them in file. How to optimize it
    for multi-times operations.
        
        Answer:
            1. for once operation, just scan and keep lastPosWord1 and lastPosWord2, and tracking the min distance.
            2. for multi-operation, we could create a hash table with each word and the locations where it occurs.
               when the query, we just need to find the minimum different between a value in listA (n) and listB(m).
               Merge ListA and ListB into one ListC but tracking the element from which list (n + m).
               Scan the ListC one by one, tracking the min distance between to nodes not from same list. O(n + m).
        
3.  Describe an algorithm to find the smallest one million numbers in one billion numbers. Assume that the computer memory can hold all
    one billion numbers.
        
        Answer: generically have 3 methods: sort, min heap and selection rank (quick select).  N = 1 billion, M = 1 million
            sort: Time: O(NlgN) Space: based on different sort algorithm O(1) or O(N)
            min heap: Time: O(NlgM), Space: O(M)
            selection rank: Time: O(N) for average case. Space: O(1)
                N + N/2 + N/4 + N/8 + .... + 1 ~= 2N => O(N)
                selection rank will need to modify the original array to do the partition. 
            selection rank with median of median as pivot, could guarantee to do it in linear time.
        
            
            
    
        