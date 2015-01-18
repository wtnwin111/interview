#Interview Question
The interview question are gathered from geeksforgeeks, careercup and some bbs. 

#A

1.  [Array] Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest 
    continuous sequence of 1s.
    Eg: Array:  1,1,0,0,1,0,1,1,1,0,1,1,1, Output - index 9, Assuming array index starts from 0.
    
    *HINT: keep begin, last replaced index.*
   
        Scan the array, 
        When found an 0, calculate the longest len = cur - begin; and update begin = replaced + 1, replaced = cur;
        Keep tracking the max len and max replaced index.
        Be careful for the last case.
2.  [Array] Given an unsorted array, find the k smallest elements.
    
    *HINT: Selection Rank.*
    
3.  [Tree] Find the minimum distance between any 2 given nodes in a tree.
 
    *HINT: use a HashMap record every node's depth, then find the common ancestor of the two given nodes.
    then calculate distance based on depth.*
    
4.  [Matrix] Given a char matrix, find the longest path of consecutive alphabets given a starting alphabet.
    You can move in all 8 directions. 
    
    *HINT: dfs on each cell.*
    
5.  [Array] Find Leader in Array (Leader means an element which is higher than all number which are indexed higher 
    than element) same problem as #O2_MaxContinuousSeq, only scan from backward.
 
6.  [Matrix] Matrix is given which is of 0 and 1, all connected 1 forms island.
    Find how many island and the largest size island in given Matrix.

    *HINT: DFS.
7.  [String] Given a string, write a program to find longest length palindrome from that given string. 
    You can swap the characters of given string.
    
    *HINT: count the occurrence of char, add all even char and the largest odd char count.*
8.  [Array] Count how many inversion in a given array. inversion pair is the reversed pair which 
    A[i] > A[j] and i < j

    *HINT: based on merge sort, when aux[j] > aux[i], count += mid - i + 1;* 
    
9.  **Design data structure that supports insert(), remove(), find-max(), delete-max() operations. 
    All operations should run in O(1) time.**
    
    *HINT: double-listed-list* 
    
10. [Math] In a party there are total n persons are there. every person is having one gift with him. 
    Every person will give his gift to another such that every person at the end has exactly one gift. 
    Any one can give his gift to anyone. say 5 people (A,B,C,D,E).
    A–>D    D–>C    C–>E    B–>A    E–>B
    Write a program to generate a random sequence. for every run, code should generate different sequence 
    with equal probability. O(n) time solution with O(1) space. 
    
    *HINT: random shuffle person array.*
    
11. [Matrix] find Kth minimum element in a row-wise and column-wise sorted 2-d array.
    
    *HINT: Heap, need make a Cell object to tracking the (row, col) of the number, when the number poll out, 
     put matrix[row + 1][col] and matrix[col + 1][row] in the heap if they are not exist.*

12. [LargeScale] Given 2 txt files, 1.txt is the product view record(uid, pid) at day1, and 2.txt is the 
    product purchase record(uid, pid) at day2
    Write code to get all the products which user viewed at day1 and purchase at day2.
    Be aware there is millions of record in each file.
    
        Answer using PIG Script
        views = LOAD '1.txt' USING PigStorage() AS (uid, pid); 
        purchases = LOAD '2.txt' USING PigStorage() AS (uid, pid); 
        result = JOIN views BY (uid，pid), purchases BY (uid, pid); 
        result = FOREACH result GENERATE views.pid; 
        result = DISTINCT result; 
        STORE result INTO 'result.txt' USING PigStorage();

13. [Design] Design the most recently viewed item for amazon, say 15 most recently viewed item which are 
    scrollable for millions of products and users. scalable and extensible model. give apis, distributed systems, 
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
         
14. [Design] Give an architecture diagram with all entities and relationships of a multi user wysiwyg editor. 
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
    
17. [String] **Concatenated String** Given a string M, M is concatenated by a shorter string N, the length of N >= 2. 
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
        
18. Given a grid which represents all location points, there are some Amazon lockers in the grid, given a 
    customer's location in the grid, find the closest locker.
    
    *HINT: do BFS search start from customer's location until find the locker.*
     
19. Given a list of player, each of them can choose not playing the game, playing with a specific player 
    (preference) or playing but does not care about the preference. find a team with five players that meet all 
    constraint.
    
    *HINT: this could be consider as a connected component graph problem.*
    
        If a player choose not playing the game, mark its group as invalid in state table.
        If a player want to play with a specific player, union the two players.
        If a player doesn't have preference, just leave him alone.
        After one scan, find suitable group can meet 5 players.
        
20. Validate BST using three different methods. 
    
    *HINT: Refer the answer below.*
    
        1. inorder traversal using recursion, checking if current visited node >= previous node.
        2. use max and min range using recursion, checking if current visited node in the range, and revise 
        the range during recursion.
        3. other way is tricky, do inorder traversal as solution 1, but using Stack iteratively not recursively.
        

#G

1.  [Array] **Counting Array** 
    Having a int array A[], B[] is a generated array based on A[], which B[i] is the count 
    of elements in A[i+1] ~ A[n-1] which is smaller than A[i]. Given B[] find A[], assume elements in A is 1-N.
    For example: B is {3, 0, 1, 0}, A should be {4, 1, 3, 2}
    
    *HINT: create a increasing options list 1-N, select B[i]-th element in the options as A[i], and delete it from
     option.
    
        Solution 1: create a buffer [1,B.length], select B[i]-th element in buffer as A[i], and delete it. 
        If use array to do select O(1) and delete O(N), so the entire algorithm is O(N^2). 
        
        Optimize Solution: use BST, create a balanced BST, and implements topK and deleteNode method, 
        for each B[i], select(root, B[i]+1) node as A[i], and delete that node, each operation is O(lgN), 
        so the entire time complexity is O(NlgN).
    
2.  [Array] Counting Array: 
    Having a int array A[], generate another int array B[], B[i] is the count of elements in 
    A[i+1] ~ A[n-1] which is smaller than A[i]. Time complexity: O(nlgn)
    
    *HINT: count the inversion pair of each node, using merge sort or BST. 
    
        Solution 1: use merge sort to count the inversion pair.
            create a Node(value, index) to avoid index change during sorting, and tracking B[node.index]. 
            when aux[j].value < aux[i].value, B[aux[i].index] += j - mid;
        Solution 2: use BST with size, insert value in BST in backward, and tracking how many node is smaller.
        Both solutions are O(NlgN)
    
3.  [Array] **Sort Array based on other array** Given a int array A and B, sort A based on B. If A[i], 
    A[j] is all in B, the relative relation of A[i] A[j] is same in B, if not just sort based on number value.
    
    *HINT: create a HashMap of (B[i], i) of B. implements a Comparator, if A[i], A[j] both contains in map, 
    return map.get(A[i]) - map.get(A[j]), else return A[i] - A[j].
    
4.  [Array] You can only use one operation on a given array: move(int i): which move i-th element to the end of array.
    Given an array, find out how many move operation needed to make the array sorted. 
    
    *HINT: the operation can move one element to the end of array, so every time select the non-sorted element
    to the end by increasing order, and the original increasing sequence doesn't need to move. The problem is 
    transform to find the longest non-decreasing sequence, operation count = num.length - LIS count.
    Longest non-decreasing sequence can calculate using One-Sequence DP.*

5.  [Geometry] Given a cycle (center and radius) and a square (4 points clockwise), write code to check if 
    they have overlap.

    *HINT: solve based on PointPolygonRelation and LineLineIntersection.*
    
        Consider two cases:
        1. if center is in square, then must have overlap.
        2. if center is out of square, create a line L of cycle_center and square_center. L must have a 
           intersection point P with one of edge of square. Then if distance(P, cycle_center) > radius, cycle is 
           out of square, no overlap; otherwise have overlap.

6.  [Array] Given a int array steps[], steps[i] means you can jump from i-th position to i+steps[i] and 
    i-steps[i] position, avoid overflow case. Write code to find all position(offset) can jump to 0.
    For example: steps[] = {1,3,0,2,4,7}, output: {1,3,4}
    
    *HINT: DFS*

7.  [Math] Some number be rotated 180 degree still be itself, for example: 96196's rotation is 96196. 
    Write code to find all such number whose length within N.
    
    *HINT: rotated to be itself options: 1, 8, 69 and 96. do permutation based on length.
    
8.  [Geometry] Given 2 point S and T, and several walls, you want to walk from S to T, but can't walk through walls. 
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

9.  [Math] We call the number which factors only include 2,3,5 as "Ugly Number". Write code to compute 1500 ugly number.
    
    *HINT: Min Heap to hold all the options.*

10. Given an int array, numbers between 0-9, such as [0,1,3,8], write code to find the closest number built by 
    these numbers larger then K.
    For example, given numbers [0,1] and K = 21, should return 100.
    
    *HINT: array scan and backtracking, be careful about overflow cases.*
    
        scan K from high digits to low (transfer K to string, scan from 0 - length-1), put option idx in a offset[].
            use option idx instead of option value is better to do backtrace increasing.
        for each digits, find the option in options[] using binary search:
            if exist return idx, if not return next larger one's index, if no larger one, return -1.
        the option follow to three cases:
            1. found option == cur digits, put in offsets, continue;
            2. found option > cur digits, put in offsets, mark isBigger = true and break
            3. no option available, break.
        after the loop, if(isBigger), just transfer offsets to number, if not, need backtrace to find the next bigger number.
            find the first option could increase, do { idx-- } while(idx >= 0 && offsets.get(idx) == options.length - 1);
            if idx == -1, need grow one bit to increase, so mark grow = true, otherwise just update with increasing number.
        after increasing the lower digits should set to the smallest option. 
        if(growth), add one more digits in the beginning, if option[0] != 0, add option[0] otherwise add option[1];
        at last, convert offsets into number.

11. Have M memory, given a set of task, each have need request R[i] memory for handling, and O[i] memory to store
    the result (O[i] < R[i]). 
    Write code to assign the task as a sequence to make sure all the task can be done, 
    return a empty assignment if whatever sequence can't be fulfill these requirement.
    There assume the task can only be done in sequence, not parallel.
    
12. Given two number A and B, find how many numbers between A and B follow this rule: 
    assume C = c1c2c3c4(between A and B), when (c1+c2+c3+c4)/4 > 7 count one, otherwise not.
    such as 8675, (8+6+7+5)/4 < 7 not count one, 8695, (8+6+9+7)/4 > 7 count one.
    Write code time complexity is O(logA + logB)

13. [Geometry] **Charging Robot**
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
         
13. [Matrix] **Charging Robot II**
    Given a N * N grid, there is K machine in the grid. if grid[i][j] == 1, means it's a machine, 
    if grid[i][j] == 2, means it's put some obstacles. Find the place to put the electrical outlet.
    Note that: robot can't go through obstacles.
    
    *HINT: since the robot can't go through obstacles, we can use |x0-x1| + |y0-y1| to find the distance.
    so use distance[i][j] to save the distance of position(i,j) to the K machines. for each machine, do
    level order traversal. Time complexity: O(KN^2), Space: O(N^2).*
    
14. Want to design a game like Tetris. In Tetris, each piece is built using 4 blocks. In the designed game, 
    each piece is built using N blocks. Write code to find out how many different pieces could built.

15. [Greedy] A box have a length and width. A box can be put in other box if both its length and width is 
    smaller than the other box, and a box can only have a child box, but the box can put in recursively.
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
            
16. [String] Abbreviation: apple can be abbreviated to 5, a4, 4e, a3e, ...
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
    
17. [Array] Given an integer array, adjust each integers so that the difference of every adjcent integers are 
    not greater than a given number target. If the array before adjustment is A, the array after adjustment is B, 
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
                
18. [Array] Find count of a number in sorted array.
    *HINT: binary search, do searchLow and searchHigh.*
19. [Design] Design two player battleship game to be played over internet.
    *HINT: game design.*
    
        Answer:
            Move(row, col, playerID)
            Board(rows, cols, int[][] board, successCount): update, isSuccess
            Display: showFailMessage, showSuccessMessage, paint
            Player(conn, playerID, board, display): joinGame, receiveMessage, getUserMove, sendMessage
            ClientConnection(serverIP, serverPort, player, socket, out, in): start, sendMessage
            Server(serverIdentity, currentPlayer, board, players, conns): joinGame, startPlay, receiveMessage, sendMessage
            ServerConnection(portNumber, server, serverSocket, socket, out, in): start, sendMessage
            
20. [Array] Given a class Quack, have 3 method: pop() random pop one element from head or tail; peek() random peek the 
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
        
21. Given millions of lines of strings, each of which have a length of 1000 characters without spaces. Among of 
    these strings, only one of them is real English consisting of valid English words. All others and just random 
    letter combinations that is not real English.  Also, bear in mind that the English may contains several 
    mismatches. Your task is to identify the only string that is English.
    
    *HINT: there is generally two approach, one is accurate solution based on word break, one is a approximate 
    solution based on statistical analysis. 
    
        Approximate solution based on statistical analysis:
            calculate the distribution of 26 characters in each line, if random generated, the distribution
            should be likely uniformed, if English sentence, it will have larger bias.
        Accurate solution based on word break:
            like the leetcode problem, if a dic is given, can get the min max distance of word, scan the 
            line with a window of min distance, if found the word, move window to next start, if not found,
            extend the window, if the window is already max distance, move forward.
            mark how many words matched and unmatched during the scan, if matched >> unmatched, is a valid 
            English sens.
            This method will very slow in large dataset as millions of lines, partition workload to multiple 
            machines.

22. Implement a encoding system as following: Abckkkkkkkkkkk55p => Abc11xk55p.
    Encoding rules: encoded them as: [n]x[c], where n is the repetition count and c is the actual character, 
    X is the special character.
    Decoder side: Any time above pattern is detected, it will output n number of c. If x is the last character, 
    output x.
    
    *HINT: String encode and decode.*
    
        Be careful for the following cases:
            1. How do you handle x in the original input? 
            2. How to ensure the decode string is the shortest one?
        To solve, 
            1. always encode 'x' in the original input as [n]xx unless it's the last char to avoid ambiguity.
            2. count the occurrences, if occurrences < 3, no need to encode to [n]x[c] pattern, since no shorter.
            
23. Having a function of hit(), write a function getHitsInLastSecond(), getCountInLastMinute() and 
    getHitsInLastFiveMinute() to return how many times of hit() be called in last 1 second, in last 1 minutes 
    and in last 5 minutes.
    
    *HINT: create a CyclicBuffer with capacity of 5 * 60 seconds and precision at 500 million seconds, it provide
    an append() method to add a hit record in and get(secondBeforeNow) to get previous secondBeforeNow hit count.
    so in hit() call append(1), and getHitsInLastSecond() call append(0) and get(0) - get(1).*
     
        In the implementation of CyclicBuffer, in order to make count = get(0) - get(second before now), need fill
        the gap between last call and current call with the count number. So create a Timer, record lastTime, and 
        provide diff() method to get the gap in second, append(0), will get a new value based on end, and fill the
        gap between end to now with the new count value.
        When call getHitsInLast***(), need call append(0) before get(0) - get(*) to shift end to current now. 

24. Given a function f() generate 0 and 1 both in 0.5 probabilities. Write a function g(n) using f(), generate 0
    in (0.5)^n probabilities, and 1 in 1-(0.5)^n probabilities.
    
    *HINT: a simple combination of f(), call f() n times and count it return m times 0, if m == n return 0, else 
    return 1.*
    
25. **Resolve Mapping from Confused Dictionary** Given a dict, but words in dict is confused with some mapping rules, 
    but the order is kept. Write code to find the mapping and restore the dict.
    For example: the original dict is "cat, coffee, common", the confused one is "dkc, dbhhzz, dbllbp", the 
    mapping is: c->d, a->k, t->c, o->b, f->h, e->z, m->l, n->p.
    
    *HINT: sort confused char based on their original order, then could get the mapping rules by 1-1 mapping. 
    create a graph of the confused char based on order of dict, then do topology sort on graph.*
    
        Based on the order between words in dictionary, we could get the original order of the confused characters. 
            For example: wrt before wrf, assume c1 mapping to t, and c2 mapping to f, and we could know that
            c1 < c2, so we could build a order graph, which have a directed edge from c1 to c2.
        After get the graph, we could do topology sort on it to get a valid order sequence of original chars, 
        so we could build a mapping from the original sorted chars to the confused sorted chars.
        For topology sort, first we need to calculate the in degree of each nodes, then we create a Queue, and init
        the queue by adding nodes whose in degree is zero in it, then do while loop until the queue isEmpty(), poll
        one node from queue and add to sorted list, and decreasing the in degree of its neighbors, if the in degree 
        of its neighbor decreased to zero, put in the queue. After the loop, we could get a topology sorted list.

26. **Longest Repeated Suffix** find the longest repeated suffix in a given string. 
    For example, given string is banana, the suffix will be: a, na, ana, nana, anana, banana, the longest repeated
    suffix is ana. 
    
    *HINT: a backward version of KMP.*
    
        In KMP, the next[i] is the length matched prefix of suffix from i-th char, S.substring(0,next[i]) equals
        to S.substring(i-next[i], i). in traditional KMP, next[i] describes the prefix and suffix matches for 
        substring ending at i-1th char, so could use to do backtracing in string match.
        the key differences is:
            1. do scan backward since we need find suffix, not prefix
            2. matches[] is a int array with N + 1 elements, and the init value is N for matches[N] and matches[N+1]
            3. matches[i] is store the max suffix for substring start from i-th, not (i+1)th, so update j = matches[j+1]
            4. check if suffix longer than maintained one, suffix is str.substring(matches[i], N)
    
27. Given a N*N matrix, each integer in matrix is the elevation of point (row, col). If rain, water will flow to the
    lower position, assume the upside and left-side of the matrix is the Pacific Ocean, and downside and right-side
    is the Atlantic Ocean. Find out the positions whose rain can both flow into the two ocean.

    *HINT: BSF based graph searching from edges.*

#F

1.  [Array] Return the index of the max element in a vector, if there are several results, 
    return them in the same probability.
     
    *HINT: find the max, and do random pick like shuffle, better solution will achieve O(1) space complexity
    by do random pick during the scan.*
    
2.  [String] Given a dict of words, find pair of words can concatenate to create a palindrome.
 
    *HINT: find all the palindrome suffix and prefix of a word, and check if there exist a word could create 
    a palindrome. In this case, the length of word can be think as constant time. so time complexity is O(N).
    
3.  [Array] Given an array of integers, move all non-zero elements to the left of all zero elements.

    *HINT: two pointer do swap, if order doesn't matters, use two pointer: front and back.
    If order matters, use two pointer: fast and slow.
    
4.  Given a int array, both positive and negative numbers, write code to check if there is a contiguous sequence
    (sub array) which sums to total.
     
5.  [Stack] Simplify Expression: given a expression contains some variable, combine the variable to make the expression
    as simple as possible. For example: 1 + b + 2 = b + 3, (x ＋ 1) * 3 + 2 * (2x + 5) = 7x + 13
     
6.  [Array] Given an int array A[], define distance as A[i]+A[j]+(j-i), for any j >= i. Find max distance in A[].

    *HINT: DP, distance[i] can be retrieve from distance[i+1] and 2 * A[i].*
    
        state: distance[i], the max distance could get of A[i] and A[k] k >= i
        initialize: distance[A.length-1] = 2 * A[A.length - 1];
        function: distance[i] = Math.max(2 * A[i], distance[i+1] + A[i] - A[i+1] + 1)
            distance[i+1] = A[i+1] + A[k] + k - (i + 1)
            distance[i] = A[i] + A[k] + k - i = distance[i+1] + A[i] - A[i+1] + 1;
        result: max(distance[i])
        
7.  [Tree] Given a binary tree which node is a int (positive and negative), write code to find a sub-tree which node 
    sum is maximal.
    
    *HINT: bottom up approach based on post-order traversal.*
    
8.  [Graph] Jump over the river. Given a int array R with 0/1 as river, 0 as water and 1 as stone.
    You start from offset 0, with speed 1, in every step, you can choose to use current speed or speed + 1.
    Find the min jumps you need to jump over the river, return -1 if you can't jump over the river.
    For example: R=[1,1,1,0,1,1,0,0], you can jump 0(2) -> 2(3) -> 5(3) -> over
    
    *HINT: DP but difficult to get the range of steps. Solution based on BFS is more easy.*
    
9.  Given the current salary and salary base(min salary) of employees in two array. Current, company want to 
    balance the salary to as even as possible. Write code to give the balanced salary of every employee. 
      
    *HINT: first change everyone's salary to base, and calculate how much money have to do balance. Sort
    the salary based on base, then scan once to increasing one stage to next stage. If available money is
    not enough, just break.* 
     
10. Assume you found a configuration file been changed by mistake in code repo, you can use getConfig(int version)
    to get the configuration of any version. Please find from which version the configure is changed.
    
    *HINT: BinarySearch, like searchLow().*
    
11. Given 1 trillion messages on FB and each message has at max 10 words, how do you build the index table 
    and how many machines do you need on the cluster to store the index table.
    
        We have 2^40 messages, 
        We need make some assumption here:
            1. each message has a uniqueID, which is a 8B long(1-2^63-1).
            2. each message has 8 words in average.
            3. totally 2^14 unique words, so each word appears in roughly 2^40*8/2^14 = 2^29 messages.
        For the index, each word has roughly 2^29 corresponding records and each record is a messge ID, 
        so the index of each word is totally 2^32B, so 4GB. The total size of the index table should be 
        2^14*2^32B = 2^46B = 64T.
        Suppose our machine is 2TB, so we need 32 machines. If we add redundancy for system failure, such
        we have 2 replication, we need 32*3 = 96 machines.
    
#L
    
1.  [Array] Given a sens of words in array, find the min distance of two given words.
    For example: the sens is: {“the”, “quick”, “brown”, “fox”, “quick”}, 
    distance(“fox”,”the”) == 3 and distance(“quick”, “fox”) == 1
    
    *HINT: use a HashMap<String, List<Integer>> as index, every distance query is find the min distance in two 
    List<Integer>. Make idx1 and idx2, while both not out of range, distance = min(list1[idx1], list2[idx2]), 
    move the smaller one forward.*

2.  [String] Given a stream API, read() to get a char, return -1 when reach to the end of stream. 
    Write code to find and print repeated sequences of 10 characters.
    
3.  [Math] Given a int array edges, write code to check if there is edges[i], edges[j], edges[k] in the array, 
    could build a triangle.The edge of triangle follow the rules: A + B > C, A + C > B, and B + C > A;
    
    *HINT: sort edges then scan every 3 edge sequence.
    
        edges sorted: get i > j > k, then edges[i] > edges[j] > edges[k], 
            so edges[j] + edges[k] > edges[i] and edges[i] + edges[k] > edges[j] 
            only need to check edges[j] + edges[i] > edges[k]
        assume edges[j'] + edges[i'] > edges[k], edges[j+1] + edges[i+1] > edges[k], 
        so we can move i to k-1, and j to k-2, if edges[k-1] + edges[k-2] > edges[k], there is a triangle.
        so only need to scan edges once, check every i, i+1, i+2 if edges[i] + edges[i+1] > edges[i+2].
        
4.  [DP] Given a mapping between numbers and alphabets . Find the number of ways to decode a sequence of numbers.
    For example: mapping: a - 21 b - 2 c - 54 d - 5 e -4 f-1. Given: 2154. 4 ways to decode: ac, ade, bfc, bfde.
    
    *HINT: standard DP problem, optimize using maxLen.*
    
        ways[0] = 1;
        for(int i = 1; i <= number.length(); i++)
            for(int j = i - maxLen < 0? 0 : i - maxLen; j < i; j++){
                String substring = numbers.substring(j,i);
                if(memo.containsKey(substring) ways[i] = ways[j] * memo.get(substring);
            }
        return ways[number.length()]
        memo is reversed index of mapping, HashMap<String, Integer>, such as 21:1, 2:1
        if no duplicate mapping to same number, could use a HashSet instead.
        
5.  Implement int getIntComplement(int N) function , that will give complement (bitwise complement.) of b a given integer. 
    Start unsetting from the left most set bit of the number. 0 <= N <= 50000
    Example: Input: 10 (1010)   Output: 5 (0101)
    
    *HINT: Bit operation &, >> and <<.
    
6.  There are "n" ticket windows in the railway station. ith window has ai tickets available. Price of a ticket is equal to 
    the number of tickets remaining in that window at that time. Given the init tickets available array, When "m" tickets 
    have been sold, what's the maximum amount of money the railway station can earn?
    
    *HINT: put price in all window in a max heap, every time poll() the max, and if max - 1 > 0, push (max - 1) back.
    until buy M tickets.*
        
4.  Given a string find the number of distinct substrings (should optimise time and space complexity)
5.  Given a string find the number of distinct palindromic substrings(should optimise time complexity)

#Other

1.  [Array] Given a sorted array, find two elements i and j, num[i] - num[j] = target. Space:O(1), Time: O(N)
    
    *HINT: consider like two sum, i scan num[i] from largest, j scan -num[j] from smallest, move like TwoSum.*
    
2.  [Array] Given a time series data T[], calculate a array peak[], peak[i] is the how many days T[i] 
    is the max value in the series from beginning.
    
        T:    3 5 6 4 5 6 1 1 1  9 8 7
        peek: 1 2 3 1 2 6 1 2 3 10 1 1    
    *HINT: scan T[] tracking the index of max element. if T[i] < T[i-1], peak[i] = 1; if T[i] >= T[maxIdx], 
    peak[i] = peak[maxIdx] + i - maxIdx and update maxIdx, otherwise T[i] > T[i-1] and T[i] < T[maxIdx], 
    peak[i] = peak[i - 1] + 1;*
    
3.  [Array] **Max Distance** 
    Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
    
    *HINT: achieve O(N) based on find decreasing sequence to avoid duplicate calculation.*
    
        The basic solution is for each i, j, if(A[i] < A[j]) max = Math.max(max, j-i);
        if there is a sequence k...i..j, if A[k] < A[i] < A[j], then (j - i) < (j - k);
        so k should be the element whose left is all larger than it, so find the decreasing sequence.
        scan by i = end of decreasing sequence, j = end of A:
            if A[i] < A[j], update max and do (i--) until i in decreasing sequence;
            if A[i] >= A[j], j--;
        Note: i only scan the element in decreasing sequence.
          
4.  [Array] Given a number, can you remove k digits from the number so that the new formatted number is smallest possible. 
    input: n = 1432219, k = 3 output: 1219
    
    *HIT: Greedy, move the last number in increasing sequence from left.*
        
5.  [Tree] **Tree traversal: only allow O(1) space without stack, each node has left, right, parent pointers**
    *HIT: like populate next pointer.*
        
6.  [String] **Next Palindrome Number** Given a number, find the next smallest palindrome larger than this number. 
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
                
7.  [Math] Given N packaging line, each package have p possibility to package items into box, and (1-p) possibility to package
    into cans. Write code to print out the all possibility to get i box after 1 round of the N packaging line.

    Solve the previous problem using Binomial distribution probability equation. P(i,n) = C(i,n) * p^i * (1-p)^(n-i)
    
    *HINT: n = 6 * K, and i in (K, 6*K), p = 1/6, the most interesting part is calculate C(i,n) = (i! * (n-i)!)/n!. 
    Be careful factorial can be very large to use int or long present, can use BigInteger.*
    
8.  Given a directory, write code to change the name of all files and sub directory (files included) in lowercase.
    If could enable to change it back to original ones. Be careful if the file name is already existed.
    
    *HINT: basic DFS traversal on the FileTree (rename child before parent) to rename and use a HashMap to record the renamed 
    pair to redo (rename parent before child).
    If it's a OO design problem, you could use Command pattern, it's designed to support UNDO and REDO.*
    
9.  Write a function to return all numbers between 0 and N contains 5.

    *HINT: scan N from lowest digit to highest digit, build the number set based on previous one.*  
    
        scan N from lowest digit to highest digit, assume we have number set S[i-1] as all numbers contains 5 smaller than 
        the lower i-1 digits in N(N % 10^i), and the number set S[i] can be built based on S[i-1] in the following cases:
            1. all the number in S[i-1] should be in S[i].
            2. if i-th digit not the highest digit, so we could add 1-9 as the highest digit in every number S[i-1], and
               when the adding i-th digit is 5, the lower digits should be all permutation of i-1 digits.
            3. if i-th digit is the highest digit, we could get the number of lower i-1 digits of N (N % 10^i), we could 
               get i-th digit in N is n, so do the previous process for [1,n-1], for n, when adding please check number 
               in S[i-1] is smaller than i-1th N.
        if N > 5, init S = {5}, and loop on each digits from lowest to highest to get the final S.
               
10. Sorting with 3 stacks, all numbers are initially in stack one. no other space allowed.

11. Given a string S, find the min length of prefix added to S to make S become a palindrome. 

    *HINT: create prefix when backward scan from the end of S.*
    
12. Given two generic trees T1 and T2, find the identical node in the two tree. Identical node
    should have the same path from root.
    If we enhance the condition of identical node: the relative relation between nodes should 
    be the same.
    
    *HINT: first one is recursive call, the second one is adding more check to find the longest
    increasing sequence if multiple possible node sets in the same layer.*

    
#TopCoder
    http://www.hiredintech.com/app#learn-algorithms
    http://www.hiredintech.com/app#blitz-rounds

#Design and System Question
    1). 一台机器向1000台机器上拷贝文件。
    2). 迷宫，这个问题留下的时间不多，说是探讨要求生成的路尽量有趣，在入口和出口不确定的情况下，如何让生成的路尽量弯曲有趣。

