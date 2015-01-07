#A

1.  Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s.
    Eg: Array:  1,1,0,0,1,0,1,1,1,0,1,1,1, Output - index 9, Assuming array index starts from 0.
    
    *HINT: keep begin, last replaced index.*
   
        Scan the array, 
        When found an 0, calculate the longest len = cur - begin; and update begin = replaced + 1, replaced = cur;
        Keep tracking the max len and max replaced index.
        Be careful for the last case.
2.  Given an unsorted array, find the k smallest elements.
    
    *HINT: Selection Rank.*
    
3.  Find the minimum distance between any 2 given nodes in a tree.
 
    *HINT: use a HashMap record every node's depth, then find the common ancestor of the two given nodes.
    then calculate distance based on depth.*
    
4.  Given a char matrix, find the longest path of consecutive alphabets given a starting alphabet.
    You can move in all 8 directions. 
    
    *HINT: dfs on each cell.*
    
5.  Find Leader in Array (Leader means an element which is higher than all number which are indexed higher 
    than element) same problem as #O2_MaxContinuousSeq, only scan from backward.
 
6.  Matrix is given which is of 0 and 1, all connected 1 forms island.
    Find how many island and the largest size island in given Matrix.

    *HINT: DFS.
7.  Given a string, write a program to find longest length palindrome from that given string. 
    You can swap the characters of given string.
    
    *HINT: count the occurrence of char, add all even char and the largest odd char count.*
8.  Count how many inversion in a given array. inversion pair is the reversed pair which A[i] > A[j] and i < j

    *HINT: based on merge sort, when aux[j] > aux[i], count += mid - i + 1;* 
    
9.  **Design data structure that supports insert(), remove(), find-max(), delete-max() operations. 
    All operations should run in O(1) time.**
    
    *HINT: double-listed-list* 
    
10. In a party there are total n persons are there. every person is having one gift with him. 
    Every person will give his gift to another such that every person at the end has exactly one gift. 
    Any one can give his gift to anyone. say 5 people (A,B,C,D,E).
    A–>D    D–>C    C–>E    B–>A    E–>B
    Write a program to generate a random sequence. for every run, code should generate different sequence 
    with equal probability. O(n) time solution with O(1) space. 
    
    *HINT: random shuffle person array.*
    
11. find Kth minimum element in a row-wise and column-wise sorted 2-d array.
    
    *HINT: Heap, need make a Cell object to tracking the (row, col) of the number, when the number poll out, 
     put matrix[row + 1][col] and matrix[col + 1][row] in the heap if they are not exist.*

12. Given 2 txt files, 1.txt is the product view record(uid, pid) at day1, and 2.txt is the product purchase 
    record(uid, pid) at day2
    Write code to get all the products which user viewed at day1 and purchase at day2.
    Be aware there is millions of record in each file.
    
        Answer using PIG Script
        views = LOAD '1.txt' USING PigStorage() AS (uid, pid); 
        purchases = LOAD '2.txt' USING PigStorage() AS (uid, pid); 
        result = JOIN views BY (uid，pid), purchases BY (uid, pid); 
        result = FOREACH result GENERATE views.pid; 
        result = DISTINCT result; 
        STORE result INTO 'result.txt' USING PigStorage();

13. Design the most recently viewed item for amazon, say 15 most recently viewed item which are scrollable 
    for millions of products and users. scalable and extensible model. give apis, distributed systems, 
    caching , reduce latency : critical
    
        Answer:
            1. clarify function: 
                15 most recently viewed item by certain user.
            2. basic components:
                data structure: Products, User, UserView
                api: /recent/{user_id}, return in JSONObject
            3. scalable: cache
                {user_id, JSONList}
                for millions of users, use distributed cache to do, using consistent hashing method to 
                partition to multiple server based on user_id.             
         
14. Give an architecture diagram with all entities and relationships of a multi user wysiwyg editor. 
    basically a web interface to multiple authors who can edit and store their docs. 
    Multiple ppl should be able to save it at once. also ownership should be present for documents.
    
        Answer:
            Web interface: display(file), edit(file), 
                JS code with MVC model.
            Backend Service:
                User Management: user login/logout
                File Management: create(file), retrieve(file), save(file), delete(file), listFiles(user)
            Data Storage:
                persistent the files, user profile, etc
            Scalable:
                1. Backend Service:
                    1) Load Balancer + Multiple Servers
                    2) Cache of user file list and recent viewed documents.
                2. Data storage
                    1) Distributed noSQL database with sharding.
                    2) Data replication.
15. Given a dictionary of unknown language, you need to give the sorted sequence of characters in it.
    E.g.Dictionary looks like: ABCDE, CF, DG
    so the output may look like: ABCDEFG
    Hint: Topological sort   
                     
16. Given a string you need to print all possible strings that can be made by placing spaces (zero or one) 
    in between them. For example : ABC -> A BC, AB C, ABC, A B C
    
17. **Concatenated String** Given a string M, M is concatenated by a shorter string N, the length of N >= 2. 
    Given a string, write code to check if the string follow the rule.
    
    *HINT: find pattern based on two point scan, and check pattern length <= 2 case with prime number 
    verification, length > 2 with condition: begin >= midpoint and first equals last.*
    
        find pattern: scan from beginning with begin and i, if char equals both move forward, it not equals
        begin back to 0, pattern = str.substring(begin), length = str.length - begin;
            If pattern.length() == 1, all the char is same, only need check if str.length() is a prime number.
            If pattern.length() == 2, need check if str.length()/2 is a prime number.
                If YES, can't concatenated to create a longer pattern, which could divide str.length().
            If pattern.length() > 2, If M is concatenated by pattern more than once, begin >= midpoint, 
            and also first.equals(last).
        


#G

1.  **Counting Array** Having a int array A[], B[] is a generated array based on A[], which B[i] is the count 
    of elements in A[i+1] ~ A[n-1] which is smaller than A[i]. Given B[] find A[], assume elements in A is 1-N.
    For example: B is {3, 0, 1, 0}, A should be {4, 1, 3, 2}
    
    *HINT: create a increasing options list 1-N, select B[i]-th element in the options as A[i], and delete it from
     option.
    
        Solution 1: create a buffer [1,B.length], select B[i]-th element in buffer as A[i], and delete it. 
        If use array to do select O(1) and delete O(N), so the entire algorithm is O(N^2). 
        
        Optimize Solution: use BST, create a balanced BST, and implements topK and deleteNode method, 
        for each B[i], select(root, B[i]+1) node as A[i], and delete that node, each operation is O(lgN), 
        so the entire time complexity is O(NlgN).
    
2.  Counting Array: Having a int array A[], generate another int array B[], B[i] is the count of elements in 
    A[i+1] ~ A[n-1] which is smaller than A[i]. Time complexity: O(nlgn)
    
    *HINT: count the inversion pair of each node, using merge sort or BST. 
    
        Solution 1: use merge sort to count the inversion pair.
            create a Node(value, index) to avoid index change during sorting, and tracking B[node.index]. 
            when aux[j].value < aux[i].value, B[aux[i].index] += j - mid;
        Solution 2: use BST with size, insert value in BST in backward, and tracking how many node is smaller.
        Both solutions are O(NlgN)
    
3.  **Sort Array based on other array** Given a int array A and B, sort A based on B. If A[i], A[j] is all in B, 
    the relative relation of A[i] A[j] is same in B, if not just sort based on number value.
    
    *HINT: create a HashMap of (B[i], i) of B. implements a Comparator, if A[i], A[j] both contains in map, 
    return map.get(A[i]) - map.get(A[j]), else return A[i] - A[j].
    
4.  You can only use one operation on a given array: move(int i): which move i-th element to the end of array.
    Given an array, find out how many move operation needed to make the array sorted. 
    
    *HINT: the operation can move one element to the end of array, so every time select the non-sorted element
    to the end by increasing order, and the original increasing sequence doesn't need to move. The problem is 
    transform to find the longest non-decreasing sequence, operation count = num.length - LIS count.
    Longest non-decreasing sequence can calculate using One-Sequence DP.*

5.  Given a cycle (center and radius) and a square (4 points clockwise), write code to check if they have overlap.

    *HINT: solve based on PointPolygonRelation and LineLineIntersection.*
    
        Consider two cases:
        1. if center is in square, then must have overlap.
        2. if center is out of square, create a line L of cycle_center and square_center. L must have a 
           intersection point P with one of edge of square. Then if distance(P, cycle_center) > radius, cycle is 
           out of square, no overlap; otherwise have overlap.

6.  Given a int array steps[], steps[i] means you can jump from i-th position to i+steps[i] and i-steps[i] position, 
    avoid overflow case. Write code to find all position(offset) can jump to 0.
    For example: steps[] = {1,3,0,2,4,7}, output: {1,3,4}
    
    *HINT: DFS*

7.  Some number be rotated 180 degree still be itself, for example: 96196's rotation is 96196. 
    Write code to find all such length length within N.
    
    *HINT: rotated to be itself options: 1, 8, 69 and 96. do permutation based on length.
    
8.  Given 2 point S and T, and several walls, you want to walk from S to T, but can't walk through walls. 
    Write code to find the shortest distance from S to T.
     
    *HINT: solve by PointPointDistance and LineLineIntersection, and search process is find the shortest path 
    in a weighted graph, could use Dijsktra.*
    
        Search from point S, get the distance to point T, by check if Line(ST) have intersection with other lines,
        if not, distance(S,T) = GeoUtil.distance(S, T). If have intersection, find the closest intersection point
        and pick its two endpoint M, N as next hop, update distance(S, M) and distance(S,N), put in Queue. 
        while(queue.isEmpty), pick shortest distance point P, and calculate it distance to T, like S. 
       
        The process is Dijsktra, by searching to build the graph, and the weight is distance between two points.
        
    K points and several walls in a plate, the wall can't be walk through. Write code to find a point P, to get
    the smallest sum of distance to all K points.

9.  We call the number which factors only include 2,3,5 as "Ugly Number". Write code to compute 1500 ugly number.
    
    *HINT: Min Heap to hold all the options.*

10. Given an int array, numbers between 0-9, such as [0,1,3,8], write code to find the closest number built by 
    these numbers larger then K.
    For example, given numbers [0,1] and K = 21, should return 100.

11. Have M memory, given a set of task, each have need request R[i] memory for handling, and O[i] memory to store
    the result (O[i] < R[i]). 
    Write code to assign the task as a sequence to make sure all the task can be done, 
    return a empty assignment if whatever sequence can't be fulfill these requirement.
    There assume the task can only be done in sequence, not parallel.
    
12. Given two number A and B, find how many numbers between A and B follow this rule: 
    assume C = c1c2c3c4(between A and B), when (c1+c2+c3+c4)/4 > 7 count one, otherwise not.
    such as 8675, (8+6+7+5)/4 < 7 not count one, 8695, (8+6+9+7)/4 > 7 count one.
    Write code time complexity is O(logA + logB)

13. **Charging Robot**
    Given a N * N grid, there is K machine in the grid, their position are stored in positions[]. 
    A robot is used to charge the K machine, and every time robot charge one machine, it need find electrical 
    outlet to recharge itself. 
    Write code to find the position of electrical outlet to make the robot charge all the machine fastest.
    
    *HINT: so find the position p to get the minimum distance sum to all K machine. 
    Same problem as NineChapter_9, and the point shouldn't overlap in any of K points.*
    
        The distance is Manhattan distance:|x0-x1| + |y0-y1|. 
        Consider x and y separately. If in one dimension, point should be the median.
            so sort the points based on x-axis, and find the median as center.x
            then sort points based on y-axis, and find the median as center.y
        If center is overlap on one of K points, put surrounding in heap with distance to all machines, 
        until poll an un-overlap points.
         
13. **Charging Robot II**
    Given a N * N grid, there is K machine in the grid. if grid[i][j] == 1, means it's a machine, 
    if grid[i][j] == 2, means it's put some obstacles. Find the place to put the electrical outlet.
    Note that: robot can't go through obstacles.
    
    *HINT: since the robot can't go through obstacles, we can use |x0-x1| + |y0-y1| to find the distance.
    so use distance[i][j] to save the distance of position(i,j) to the K machines. for each machine, do
    level order traversal. Time complexity: O(KN^2), Space: O(N^2).*
    
14. Want to design a game like Tetris. In Tetris, each piece is built using 4 blocks. In the designed game, 
    each piece is built using N blocks. Write code to find out how many different pieces could built.

15. A box have a length and width. A box can be put in other box if both its length and width is smaller than 
    the other box, and a box can only have a child box, but the box can put in recursively.
    Given a list of box, calculate the min area needed to put all the box.
    
    *HINT: sort box by its area, and do greedy selection, scan backward, find the first empty box can put 
    current box in as it's parent. Total area is the all the parent box.*
    
        use two array: 
            placement[i]: boxes[i] put in boxes[placement[i]], if placement[i] = i, mean boxes[i]
        is the root box. 
            used[i]: used[i] == true, boxes[i] is not empty.
        greedy selection approve: if A, B, C, D, and A <- B,C, and C <- D,
            if select A <- B, so the solution is A(B), C(D), the total area is A + C
            if select A <- C, so the solution is A(C(D)), B, the total area is A + B
            the previous one this better.
16. Abbreviation: apple can be abbreviated to 5, a4, 4e, a3e, ...
    Given a target string (internationalization), and a set of strings, return the minimal length of abbreviation 
    of this target string so that it won’t conflict with abbrs of the strings in the set. 
    For example: “apple”, [“blade”] -> a4 (5 is conflicted with “blade”),
    and “apple”, [“plain”, “amber”, “blade”]  ->  ???
    
    *HINT: based on KCombination*
    
        1. select omit K chars from target: K from [target.length, 0], generate a abbr based on char selection
            target = "apple" K=5: "5", K=4: "a4","1p3","2p2","3l1","4e", etc
        2. when generate: check the abbr can different words in the dict, by calling isMatch(word, abbr).
        3. if have valid abbr, return the shortest one, if not K--;
        
        Optimization: 
            check the abbr can different words in the dict, by calling isMatch(word, abbr), is O(LN)
            could do pre-processing on words in dict, use Set<Integer>[] to make each char can differentiate
            which word. So during the abbr generation, create a Set<Integer> as which word this abbr can 
            differentiate, add differentiate set of every char in it, if the count of total differentiate set 
            = word count, it's a valid abbr. O(L), space O(LN)
    
17. Given an integer array, adjust each integers so that the difference of every adjcent integers are not 
    greater than a given number target. If the array before adjustment is A, the array after adjustment is B, 
    you should minimize the sum of |A[i]-B[i]| . Suppose A[i] >= 0. 
    
    For example: Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 
    and it's minimal. Return 2.
    
    *HINT: the range of option adjust value should be [0,max], so use DP.*
    
        state: cost[i][v] - the total cost of changing A[i] to v, where v belongs to [0, max]
               preValues[i][v] - the i-1 selected value to make cost[i][v] to be the min cost, using to backtrace B[]
        init: cost[0][v] = |A[0] - v|;
        function: cost[i][v] = min(cost[i-1][v - target ... v + target]) + |A[i] - v|
                  where v, v - target and v + target all belong to [0, max]
                  preValues[i][v] = v1 where finally cost[i][v] = cost[i-1][v1] + |A[i] - v|.
        result: find the min cost in cost[A.length - 1][v], B[A.length - 1] = v
                backtrace B, B[i] = preValues[i+1][B[i+1]] for i from A.length - 2 to 0.
                
18. Find count of a number in sorted array.
    *HINT: binary search, do searchLow and searchHigh.*
19. Design two player battleship game to be played over internet.
    *HINT: game design.*
    
        Answer:
            Move(row, col, playerID)
            Board(rows, cols, int[][] board, successCount): update, isSuccess
            Display: showFailMessage, showSuccessMessage, paint
            Player(conn, playerID, board, display): joinGame, receiveMessage, getUserMove, sendMessage
            ClientConnection(serverIP, serverPort, player, socket, out, in): start, sendMessage
            Server(serverIdentity, currentPlayer, board, players, conns): joinGame, startPlay, receiveMessage, sendMessage
            ServerConnection(portNumber, server, serverSocket, socket, out, in): start, sendMessage
            
20. Given a class Quack, have 3 method: pop() random pop one element from head or tail; peek() random peek the 
    element in head or tail, if you call peek() before pop(), it will pop the same element you get from peek();
    push() insert one element in the tail. 
    Given a sorted Quack, how to export the data into a array. 
    Please consider without duplication and with duplication both cases.
    
    *HINT: Two pointer front and back.*
    
        consider without duplication case: when you pop() on element A, then peek() next element B. 
            If A is pop from head, B is A's next or last, and A < B, and A should put in the front.
            If A is pop from tail, B is A's previous or first, and A > B, and A should put in the end.
        So keep two pointer: front and back, when A > B, array[front++] = A, if A < B, array[back--] = A.
        If with duplication, have the case B == A, so use a counter to count how many equal element, until
        find a B != A, when put A, also put the equal elements.
     
            

#F

1.  Return the index of the max element in a vector, if there are several results, 
    return them in the same probability.
     
    *HINT: find the max, and do random pick like shuffle, better solution will achieve O(1) space complexity
    by do random pick during the scan.*
    
2.  Given a dict of words, find pair of words can concatenate to create a palindrome.
 
    *HINT: find all the palindrome suffix and prefix of a word, and check if there exist a word could create 
    a palindrome. In this case, the length of word can be think as constant time. so time complexity is O(N).
    
3.  Given an array of integers, move all non-zero elements to the left of all zero elements.

    *HINT: two pointer do swap, if order doesn't matters, use two pointer: front and back.
    If order matters, use two pointer: fast and slow.
    
4.  Given a int array, both positive and negative numbers, write code to check if there is a contiguous sequence
    (sub array) which sums to total.
     
5.  Simplify Expression: given a expression contains some variable, combine the variable to make the expression
    as simple as possible. For example: 1 + b + 2 = b + 3, (x ＋ 1) * 3 + 2 * (2x + 5) = 7x + 13
     
6.  Given an int array A[], define distance as A[i]+A[j]+(j-i), for any j >= i. Find max distance in A[].

    *HINT: DP, distance[i] can be retrieve from distance[i+1] and 2 * A[i].*
    
        state: distance[i], the max distance could get of A[i] and A[k] k >= i
        initialize: distance[A.length-1] = 2 * A[A.length - 1];
        function: distance[i] = Math.max(2 * A[i], distance[i+1] + A[i] - A[i+1] + 1)
            distance[i+1] = A[i+1] + A[k] + k - (i + 1)
            distance[i] = A[i] + A[k] + k - i = distance[i+1] + A[i] - A[i+1] + 1;
        result: max(distance[i])
        
7.  Given a binary tree which node is a int (positive and negative), write code to find a sub-tree which node 
    sum is maximal.
    
    *HINT: bottom up approach based on post-order traversal.*
    
       
    
#L

16. [Math] Given N packaging line, each package have p possibility to package items into box, and (1-p) possibility to package
    into cans. Write code to print out the all possibility to get i box after 1 round of the N packaging line.

    Solve the previous problem using Binomial distribution probability equation. P(i,n) = C(i,n) * p^i * (1-p)^(n-i)
    
    *HINT: n = 6 * K, and i in (K, 6*K), p = 1/6, the most interesting part is calculate C(i,n) = (i! * (n-i)!)/n!. Be careful factorial
    can be very large to use int or long present, can use BigInteger.*
    
1.  [Array] Given a sens of words, find the min distance of two given words. 

#Other

1.  Given a sorted array, find two elements i and j, num[i] - num[j] = target. Space:O(1), Time: O(N)
    
    *HINT: consider like two sum, i scan num[i] from largest, j scan -num[j] from smallest, move like TwoSum.*
    
2.  Given a time series data T[], calculate a array peak[], peak[i] is the how many days T[i] is the max value 
    in the series from beginning.
    
        T:    3 5 6 4 5 6 1 1 1  9 8 7
        peek: 1 2 3 1 2 6 1 2 3 10 1 1    
    *HINT: scan T[] tracking the index of max element. if T[i] < T[i-1], peak[i] = 1; if T[i] >= T[maxIdx], 
    peak[i] = peak[maxIdx] + i - maxIdx and update maxIdx, otherwise T[i] > T[i-1] and T[i] < T[maxIdx], 
    peak[i] = peak[i - 1] + 1;*
    
3.  **Max Distance** 
    Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
    
    *HINT: achieve O(N) based on find decreasing sequence to avoid duplicate calculation.*
    
        The basic solution is for each i, j, if(A[i] < A[j]) max = Math.max(max, j-i);
        if there is a sequence k...i..j, if A[k] < A[i] < A[j], then (j - i) < (j - k);
        so k should be the element whose left is all larger than it, so find the decreasing sequence.
        scan by i = end of decreasing sequence, j = end of A:
            if A[i] < A[j], update max and do (i--) until i in decreasing sequence;
            if A[i] >= A[j], j--;
        Note: i only scan the element in decreasing sequence.
          
4.  Given a number, can you remove k digits from the number so that the new formatted number is smallest possible. 
    input: n = 1432219, k = 3 output: 1219
    
    *HIT: Greedy, move the last number in increasing sequence from left.*
        
5.  **Tree traversal: only allow O(1) space without stack, each node has left, right, parent pointers**
    *HIT: like populate next pointer.*
        
6.  **Next Palindrome Number** Given a number, find the next smallest palindrome larger than this number. 
    For example, if the input number is “23545″, the output should be “23632″. 
    And if the input number is “999″, the output should be “1001″.
    
    *HINT: two pointer front and back scan and adjust to palindrome, checking adjustment is bigger as
     next number, if not, need increasing it.*
    
        Use front and back pointer to scan number to adjust it to palindrome, and tracking if the adjust number
        is bigger than number using flag isBigger.
        After adjustment:
            If isBigger == true, return adjust number.
            If isBigger != true, need increase this number from center and keep it is a palindrome.
                the changeable number is smaller than 9, increasing one. and return adjust number.
                If no changeable number, such as 999, need create 1001 for this case and return.


    
    
#TopCoder
    http://www.hiredintech.com/app#learn-algorithms
    http://www.hiredintech.com/app#blitz-rounds

#Design and System Question
    1). 一台机器向1000台机器上拷贝文件。
    2). 迷宫，这个问题留下的时间不多，说是探讨要求生成的路尽量有趣，在入口和出口不确定的情况下，如何让生成的路尽量弯曲有趣。

