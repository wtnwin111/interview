#Question List

   General Approach:

    Hash table: Key in memory, searching in O(1)
        1. find the most frequent IP visit some website.
        2. find un-duplicate phone number in 1 billion records
    Heap: insert and popMin/popMax in O(lgN), getMin/getMax in O(1).
        1. get topK integer in massive integers.
        2. get median of massive integers.
        3. tracking median in a stream of integer.
    SelectionRank: find the TopK or K-th element in massive data.
    BitMap: mark integer/long occurrences, used in searching, find duplication, delete duplication.
        1. find un-duplicate phone number in 1 billion records
        2. find un-duplicate integer in 2500 billion integers
    Partition: partition data based on some rules, and use multiple machine to process or process multi-times.
    Inverted Index: create word-docs list, attr-entity index, find co-occurrence searching
        1. keyword searching
        2. search keyword suggestion
    OuterSort: use disk to sort massive data. K-merge sort
    Trie: compress suffix of words for better searching performance. O(L), L is the average word length.
        1. search a word in dictionary or not, memory limit can't load all word one by one in memory. 
        2. top 10 hot query keywords
    MapReduce: distributed computer framework, Map(Input -> <K1, V1>), Reduce(<K1, [V1, V2..]> -> <K2, V1>)
        massive log analytics, data mining and machine learning algorithm on massive data.
        
1.  Design a method to find the frequency of occurrences of any given word in a book. *[HashMap / Trie]*

        Answer based on one-time query or multi-time operation.
        one-time query: scan and count: O(N)
        multi-time query: create an index of words frequency, using HashMap or TrieTree. Time: O(1), 
            HashMap:  Space: O(M) M is the num of word
            TrieTree: Space: O(26^len) len is the largest length of word
            
    If the book is 1G, and we need find out top 100 frequent words. Memory Limit is 1MB. *[HashMap, Partition]*
    
        Answer: 1. count the word occurrences. 2. use a 100 word min heap.
            1. count: to partition the words into different machine by on hash(word) % n (n is machine number).
               each machine, have a hash table <word, count>
               assume have M un-duplicated words in 1G file, the average length of word is L.
               total size of M * L byte (string) and M * 4 byte (count) = (L+4)M byte.
            2. use 100 word min heap, scan M un-duplicated words, and keep the top 100 in heap.

2.  You have a large text file contains words. Given any two words, find the shortest distance between them in file. How to optimize it
    for multi-times operations. *[InvertedIndex]*
        
        Answer:
            1. for once operation, just scan and keep lastPosWord1 and lastPosWord2, and tracking the min distance.
            2. for multi-operation, we could create a hash table with each word and the locations where it occurs.
               when the query, we just need to find the minimum different between a value in listA (n) and listB(m).
               Merge ListA and ListB into one ListC but tracking the element from which list (n + m).
               Scan the ListC one by one, tracking the min distance between to nodes not from same list. O(n + m).
        
3.  Describe an algorithm to find the smallest one million numbers in one billion numbers. Assume that the computer memory can hold all
    one billion numbers. *[Heap / SelectionRank]*
        
        Answer: generically have 3 methods: sort, min heap and selection rank (quick select).  N = 1 billion, M = 1 million
            sort: Time: O(NlgN) Space: based on different sort algorithm O(1) or O(N)
            min heap: Time: O(NlgM), Space: O(M)
            selection rank: Time: O(N) for average case. Space: O(1)
                N + N/2 + N/4 + N/8 + .... + 1 ~= 2N => O(N)
                selection rank will need to modify the original array to do the partition. 
            selection rank with median of median as pivot, could guarantee to do it in linear time.

4.  Given you 1 billion phone number, find out the un-duplicated phone number. *[BitMap]*

        Answer: BitMap, Bi-BitMap, Range calculation. 
            Data Range: phone number 10 digit number, 1,000,000,000 - 9,000,000,000. 10^10 data range ~= 2^34 phone numbers.
                        10^10 is bigger than integer range, so need to use long to present a phone number.
                            int range:   -2^31 ~ 2^31-1
                            long range:  -2^63 ~ 2^63-1
            BitMap: to find out the un-duplicated phone number, could use 2 BitMap.
                make i-th bit in Map1 when meet a phone number(i) first time, make i-th bit in Map2 when meet more than once.
                the un-duplicated phone number is i Map1.get(i) == true && Map2.get(i) == false;
            BitMap present range:
                int[]  as store: 2^31(0-Integer.MAX_VALUE) * 2^5 = 2^36 bit; storage 2^33 byte = 8G
                long[] as store: 2^31(0-Integer.MAX_VALUE) * 2^6 = 2^37 bit; storage 2^34 byte = 16G
                so to mark phone number int[] BitMap is enough.
            To store 10^10 phone number ~= 2^34 phone numbers, need 2^34 bit ~= 2^31 byte = 2G, total 2*2G = 4G memory.
            
            If we can have 4G memory, we could partition the 1 billion phone number into different partition based on their first
            digit number, so only need 4G/10 = 0.4G ~ 512M memory. If still can't put in memory could partition using first-two
            digit numbers, memory need will be 4G/100 = 0.04G = 51M memory.
 
5.  Find the median of integers placed in N machines. *[Partition, SelectionRank]*
            
        Answer: Selection Rank: find the K-th number (K = total/2). 
            1. Find a machine as coordinator, send command to other N-1 machines, firstly find total integer number.
            2. The coordinator, 
                2.1 random pick one of its number as pivot(if itself doesn't have, send command to other machine to random
            pick one), 
                2.2 send command to other N-1 machine to partition numbers based on pivot, return how many number smaller or equal
            to pivot, 
                2.3 assume returned value sum is M. if M == K, pivot is median; if M < K, let machine remove all the number smaller 
                or equals pivot and K = K - M; if M > K, let machine remove all the number larger than pivot.
                2.4 repeat 2.1 ~ 2.3 until K == M
            The time complexity: assume every machine have (total/N) numbers, i-th round, compare O(total/(N*2^i)), the coordinator 
            need sum the result O(N), total O(lg(total/N) round. Total: O(total/N + N * log(total/N)), since N << log(total/N), so 
            Time complexity is O(total/N), so it's a linear based on number stored on each machine.

6.  Given an input file with 4 billion non-negative integers, provide an algorithm to generate an integer which is not contains in
    the file. Assume you have 1G of memory available. *[BitMap]* 
            
        Answer: integer range 2^32 or 4 billion distinct integer, use BitMap to mark the integer in files, need 0.5G
            
    If we only have 10MB memory? *[Partition]*
        
        Answer: partition integer into 50 partition (500M/10M), every partition could contains 2^26 ~ 2^27 integer, could partition
        based on it's value range.
        If have multiple machine, could pass in parallel, if not need pass 50 times to get all integer marked.
    
    Given a file of 4 billion 32-bit integers, how to find one that appears at least twice?
            
        Answer: use 2 BitMap, scan to number i, 
            if(map1.get(i) == false) map1.set(i);
            else map2.set(i);
        The number appear twice should be map1.get(i) == true && map2.get(i) == true
        BitMap for 4 billion 32bit-integers need 2^32 bit = 2^29 byte = 0.5G
        So only need 1G to hold 2 BitMap.
            
7.  You have an array with all the numbers from 1 to N, where N is at most 32,000. The array may have duplicate entries and do not
    know what N is. With only 4K memory available, how would you print all duplicate element in the array. *[BitMap]*
    
        Answer: 4KM = 2^(2+10+3) = 2^15 bit using BitMap. 32000 ~= 32 * 2^10 = 2^15 number. so could use a BitMap in memory.
    
8.  You have 10 billion of URLs, how to detected the duplicate URLs.[HashMap/Partition]

        Answer: 10^10 URL, each URL have 100 char in average, so 10^12 chars. each char have 4 byte, ~= 4000GB. (10^9 ~= 1G)
            1. Disk storage: partition into 4000 files, hashing by hash(URL)%4000;
            2. Partition Multiple machines: 4000 files could partition to N machine. 
               How to handle machine failure, need a global coordinator, and if task failed or timeout, re-assign to other machine.[Map/Reduce]   

9.  Find or determine non existence of a number in a sorted list of N numbers where the numbers range over M, M >> N and N large enough
    to span multiple disks. Algorithm to beat O(log n) bonus points for constant time algorithm.   
            
        Answer:
            1. If it's once operation, just do binary search on the N numbers, O(lgN). 
               Since the N numbers is sorted, so could find a partition maybe contains this number based on (start, end) pair of 
               each partition, than do binary search on the partition.
            2. If it's multiple operation, could do pre-process of N numbers. 
               Since M << N, so create a BitMap to mark the occurrences of numbers, a BitMap contains all integer need 0.5G.
               M << N, so BitMap should be able to put on one machine.
               After the pre-process, query will be done in O(1)   

10. 
                                                  
##System Design

1.  How would you design the data structure for large social network like Facebook or Linkedin? Describe how you would design an 
    algorithm to show the connection, or path, between two people (e.g. Me -> Bob -> Susan -> Jason -> You.)
            
        Answer
            1. Basic simple case: construct a graph by treating each person as a node and letting an edge between two nodes 
                indicate that the two users are friends. Each user have a list of friends reference. If we want to find the shortest 
                connection between two person, just do BFS from one user to the target user. 
            2. Handle millions of users: 
                Data Storage: users data may placed in hundreds of machine, for each user, generate a unique id, and
                put it on a particular machine based on hashing algorithms (consistent hashing), and could allocate to the machine
                when we need retrieve user's info by its id.
                Find path algorithm: also do BSF, but for every user, fetch friends info maybe from other machine.
            3. Optimize:
                1. Reduce Machine Jump: instead of randomly jumping among machines for each friends, we could use batch jumps.
                2. Smart Division of People and Machines: people live in the same country be more likely to be friends, so could
                   put them on one machine, it also could reduce the number of jumps.
                3. Make a hashset of visited nodes instead of marking on node.
                4. Real-world problem:
                    1. Severs fails: put users data in multiple server with replication. a leader of all the replication is in charge 
                       of data modification, and replicate data into other replications.[Hadoop]
                    2. Caching?
                    3. Do you search until the end of the graph? How do you decide when to give up?
                    4. In real life, some people have more friends of friends than others, and are therefore more likely to make a 
                       path between you and someone else. Could use user out-degree as heuristic method to do heuristic searching.
                       
2.  If you were designing a web crawler, how would you avoid getting into infinite loops?
    
        Answer: infinite loop occurs when the linkage is cyclic, so determine a page is visited or not before crawl.
        How to identify if the page is visited, based on URL or content? URL and content can't determine this problem perfectly.
        We could create a priority-based crawling system, a page is deemed to be sufficiently similar to other page we de-prioritize 
        crawling its children, but still add it back with a low priority.
        In this case, the crawler will never complete, if you definitely need stop crawler, you can make a threshold of priority.
                    
3. How to design a cache system of web searching system? 
            
        Answer:
        1. First at all, we need make some assumptions:
            a. Other than calling out to processSearch as necessary, all query processing happens on the initial machine that was called.
            b. The number of queries we wish to cache is large. (millions).
            c. Calling between machines is relatively quick.
            d. The result for a given query is an ordered list of URLs, each of which has an associated 50 character title and 200 description.
            e. The most popular queries are extremely popular, such that they would always appear in the cache.
        2. Understand primary functions:
            a. Efficient lookup give a key.
            b. Expiration of old data so that it can be replaced with new data. We need handle updating or clearing the cache when the query
               result updated. Because some query may very very hot, and it always in cache. 
        3. Design:
            a. Single Machine Case:
                a double linked list to store data(easy purging of old data, and move "fresh" items to the front.)
                a hash table allows efficient lookup of data
                Cache expire could base on time, and Cache replace policy would be LRU(Least Recent Used) or LFU(Least Frequent Used). 
                LFU is more complexity than LRU, need a counter of usage, and sort linked list based on frequency.
            b. Multiple Machine Case: 
                a. Each machine has it's own cache, and no share. It's not good since query is round-robin dispatch to different machine.
                b. Each machine has a copy of the cache, if the total size of cache is M, current only can cache M/machine_count data.
                c. Each machine store a segment of the cache, and have a partition rule, such as hash(query)%machine_count or consistent hashing
                   When a machine get a query, it can allocate where to find the cache of that query.
            c. Update result when query result change: page content changes or query result list changes.
                define a "automatic timeout" on the cache, and make a key-mutex lock when update data to avoid too much query calling backend 
                service concurrently.
            d. Further Optimize:
                a. for very very popular query, could hold result in every machine to avoid jump to other machine.
                b. could re-architect the load balance policy to route the query also based on cache policy to avoid machine jump.
                c. "automatic timeout" threshold could defined based on the type of query or content update frequency.

        
            
            
    
        