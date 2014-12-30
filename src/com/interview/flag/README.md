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

14. Give Object oriented design for the snake game (that was in old nokia phones) . 
    Only class and diagram was needed, no code/implementation. 
    it should have extensibility to accomodate different types of fruits, 
    (eg one gives + 5 len + 10 pts) it should be scalable to diff platforms.
    
        Answer: 
        Basic Objects: 
            Fruit(score, image), 
            Cell(x, y), Matrix(length, wide, isFruit(x, y)), 
            Snake(length, Cell[], eat(), move(direction), isDead())
            Display(draw(matrix), draw(snake), draw(fruit))
            Game(Fruit[], Matrix, Snake, Display)  
         
15. Give an architecture diagram with all entities and relationships of a multi user wysiwyg editor. 
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
16. Given a dictionary of unknown language, you need to give the sorted sequence of characters in it.
    E.g.Dictionary looks like: ABCDE, CF, DG
    so the output may look like: ABCDEFG
    Hint: Topological sort   
                     
17. Given a string you need to print all possible strings that can be made by placing spaces (zero or one) 
    in between them. For example : ABC -> A BC, AB C, ABC, A B C


#G

1.  **Counting Array** Having a int array A[], B[] is a generated array based on A[], which B[i] is the count of elements 
    in A[i+1] ~ A[n-1] which is smaller than A[i]. Given B[] find A[], assume elements in A is 1-N.
    For example: B is {3, 0, 1, 0}, A should be {4, 1, 3, 2}
    
    *HINT: create a increasing options list 1-N, select B[i]-th element in the options as A[i], and delete it from
     option.
    
        Solution 1: create a buffer [1,B.length], select B[i]-th element in buffer as A[i], and delete it. 
        If use array to do select O(1) and delete O(N), so the entire algorithm is O(N^2). 
        
        Optimize Solution: use BST, create a balanced BST, and implements topK and deleteNode method, 
        for each B[i], topK(root, B[i]+1) node as A[i], and delete that node, each operation is O(lgN), 
        so the entire time complexity is O(NlgN).
    
2.  Having a int array A[], generate another int array B[], B[i] is the count of elements in A[i+1] ~ A[n-1] which
    is smaller than A[i]. Time complexity: O(nlgn)
    
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
    
4. 

    1-N). 将interval中的某个区间的父区间删除，正确的思路应该是先将区间按interval的开始值排序，然后从后往前扫描。(将区间按照interval的结束值排序，然后从前往后扫描应该是一样的）
    2-N). 一个数组，只能对其进行一种操作：将某个数移到数组的末尾，请问最少需要对其进行多少次这样的操作才能对其排序？
        正确的解法是，看数组中LIS的序列有多长，需要进行的操作次数为数组长度减去序列长度。
    3-N). 有一个圆和一个正方形，如何判断其是否相交。
    4). 一个数组 A: 1 3 0 2 4 7   input: dest-node: A0  output: all the source nodes: (A1, A3, A4)
        数组中每个元素表示他能走的步数，技能向左走 又能向右走，能到A[0]的点有A[1]和A[4]，A[1]可以走3步到A[4] A[4]能走4步道A[0]。
        输出所有能到A[0]的index。
    5). 数字反转180度，逆向反转，输出长度小于N的所有数字。如96196，数字反转180度是69169，然后逆转是96196，是他自己。
    6-N). 一个平面上有随机的k个目标点，还有一些墙，不能穿过，求一个点使得该点到所有目标点的距离和最小。
    7). Given a N, write function to calculate how many M appear in 1-N. M is 1~9
    8). 给定两个array，要求按照第二个array的顺序排列第一个array，如果第一个array里面有不包含第二个array的元素，则按照顺序排列
    9-N). Given an array of integers, write a method to find indices m and n such that if you sorted elements m through n, 
        the entire array would be sorted. Minimize n - m (that is find the smallest such sequence).
        Example: 1,2,4,7,10,11,7,12,6,7,16,18,19, return (3,9)
    10. We call the number which factors only include 2,3,5 as "Ugly Number". Write code to compute 1500 ugly number.
    11. Given an int array, numbers between 0-9, such as [0,1,3,8], write code to find the closest number built by these numbers larger then K.  [Google]
        Such as [0,1] and K = 21, should return 100.
    12. Have M memory, given a set of task, each have need request R[i] memory for handling, and O[i] memory to store the result (O[i] < R[i]). 
                Write code to assign the task as a sequence to make sure all the task can be done, 
                return a empty assignment if whatever sequence can't be fulfill these requirement. [Google]
                There assume the task can only be done in sequence, not parallel.
    13. Given two number A and B, find how many numbers between A and B follow this rule: 
                assume C = c1c2c3c4(between A and B), when (c1+c2+c3+c4)/4 > 7 count one, otherwise not.
                such as 8675, (8+6+7+5)/4 < 7 not count one, 8695, (8+6+9+7)/4 > 7 count one.
                Write code time complexity is O(logA + logB)  [Google]
    14. 充电机器人
    15. 俄罗斯方块
    16. 放盒子
#F
    1). Return the index of the max element in a vector, if there are several results, return them in the same probability.
    2). given a dict of words, find pair of words can concatenate to create a palindrome. 
    3). Given an array of integers, move all non-zero elements to the left of all zero elements.
    4-N). 给个数组seq， 和一个total，找 if there is a contiguous sequence in seq which sums to total.
    5). 化简表达式：如果表达式里有variable，比如有个x，要怎么做？
        例如：1 + b + 2 = b + 3 或者 （x ＋ 1）＊ 3 ＋ 2 *（2x + 5） 化简成7x + 13 
    6). Given an int array A[], define: distance=A[i]+A[j]+(j-i), j>=i. Find max distance in A[]
    Given a binary tree which node is a int (positive and negitive), write code to find a sub-tree which node sum is maximal. [Facebook]
       
    
#L

16. [Math] Given N packaging line, each package have p possibility to package items into box, and (1-p) possibility to package
    into cans. Write code to print out the all possibility to get i box after 1 round of the N packaging line.

    Solve the previous problem using Binomial distribution probability equation. P(i,n) = C(i,n) * p^i * (1-p)^(n-i)
    
    *HINT: n = 6 * K, and i in (K, 6*K), p = 1/6, the most interesting part is calculate C(i,n) = (i! * (n-i)!)/n!. Be careful factorial
    can be very large to use int or long present, can use BigInteger.*
    
1.  [Array] Given a sens of words, find the min distance of two given words. 

#Other

1.  给一个amount和一堆denomination，然后把所有的可能组成amount的denomination的组合输出出来 combination
2.  Given a time series data T[], calculate a array peek[], 
    peek[i] is the how many days T[i] is the max value in the series from beginning.
        T:    3 5 6 4 5 6 1 1 1  9 8 7
        peek: 1 2 3 1 2 6 1 2 3 10 1 1
3.  Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
        http://leetcode.com/2011/05/a-distance-maximizing-problem.html
4.  Given a number, can you remove k digits from the number so that the new formatted number is smallest possible. 
    input: n = 1432219, k = 3 output: 1219
    *HIT: Greedy, move the last number in increasing sequence from left*
        
5.  **Tree traversal: only allow O(1) space without stack, each node has left, right, parent pointers**
    *HIT: like populate next pointer*
        
    8-N). Given a number, find the next smallest palindrome larger than this number. 
        For example, if the input number is “2 3 5 4 5″, the output should be “2 3 6 3 2″. 
        And if the input number is “9 9 9″, the output should be “1 0 0 1″.
    30-N).A palindrome is a String that is spelled the same forward and backwards. 
        Given a String base that may or may not be a palindrome, we can always force base to be a palindrome by adding letters to it. 
        For example, given the word "RACE", we could add the letters "CAR" to its back to get "RACECAR" (quotes for clarity only). 
        However, we are not restricted to adding letters at the back. 
        For example, we could also add the letters "ECA" to the front to get "ECARACE". In fact, we can add letters anywhere in the word, 
        so we could also get "ERCACRE" by adding an 'E' at the beginning, a 'C' after the 'R', and another 'R' before the final 'E'. 
        Your task is to make base into a palindrome by adding as few letters as possible and return the resulting String. 
        When there is more than one palindrome of minimal length that can be made, return the lexicographically earliest 
        (that is, the one that occurs first in alphabetical order).
        http://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm197
    31-N).QuickSum http://community.topcoder.com/stat?c=problem_statement&pm=2829&rd=5072
        http://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm165
    
#TopCoder
    http://www.hiredintech.com/app#learn-algorithms
    http://www.hiredintech.com/app#blitz-rounds

#Design and System Question
    1). 一台机器向1000台机器上拷贝文件。
    2). 迷宫，这个问题留下的时间不多，说是探讨要求生成的路尽量有趣，在入口和出口不确定的情况下，如何让生成的路尽量弯曲有趣。

