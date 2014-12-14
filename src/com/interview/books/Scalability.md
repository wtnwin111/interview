#Question List

1. Design a method to find the frequency of occurrences of any given word in a book.

        Answer based on one-time query or multi-time operation.
        one-time query: scan and count: O(N)
        multi-time query: create an index of words frequency, using HashMap or TrieTree. Time: O(1), 
            HashMap:  Space: O(M) M is the num of word
            TrieTree: Space: O(26^len) len is the largest length of word