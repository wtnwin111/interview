#Problem Lists and HINTs

**Bold Problem** is **IMPORTANT and HARD/MEDIAN**

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

8.  Given N element array, need query the GCD of arbitrary sub-array. Find a way to pre-process and accelerate the query. 
    Additional space complexity within O(N)
    
    IF N array change to N * N matrix, and need query GCD of arbitrary sub-matrix.
    
    *HINT: Interval Tree*
    


#Problem List
1. http://www.ninechapter.com/problem/53/
2. http://www.ninechapter.com/problem/50/
3. http://www.ninechapter.com/problem/46/
4. http://www.ninechapter.com/problem/42/
5. http://www.ninechapter.com/problem/41
6. http://www.ninechapter.com/problem/35/
7. http://www.ninechapter.com/problem/34
8. http://www.ninechapter.com/problem/30
9. http://www.ninechapter.com/problem/29
      