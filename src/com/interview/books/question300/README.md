#Technical Interview Question

1.  [Array] Given three sorted arrays (in ascending order), you are required to find a triplet (one element from each array) 
    such that distance is minimum. Please give a solution in O(n) time complexity 
    
        Distance is defined like this : If a[i], b[j] and c[k] are three elements then 
            distance = max(abs(a[i]-b[j]), abs(a[i]-c[k]) ,abs(b[j]-c[k]))
    *HINT: three point, and always move the smallest one to next. Tracking the min distance during visiting. O(N).*

2.  [Array/Graph] Given a un-directed graph with N vertex, and M edges, find the connected components on the graph.
 
    *HINT: Balanced Union Find, note that UnionFind only for un-directly graph or directed graph to find WCC.*
    
3.  [Digital Convert] Write a function (with helper functions if needed) called to Excel that takes an excel column value (A,B,C,D
    ,..Z,AA,AB,AC,..,ZZ,AAA..) and returns a corresponding integer value (A=1,B=2,..,AA=26..).
    
    *HINT: A-Z is 26-based digital system, but without 0, so add one after conversion if not the last bit.*
    
4.  [Interval] Given a set of ranges, find the two ranges with the greatest overlap.
    
    *HINT: sort the interval by start, and keep tracking the max end, and max overlap. Since i.start <= j.start when j > i, 
    and if j.end > i.end, and for any k, k > j > i, the max overlap should be j.end - k.start.* 
       
5.  [Math] Given a time, calculate the angle between the hour and minute hands.

    *HINT: pre-calculate degree per minute and per hour. degree_hour = (hour + minute/60F) * DEGREE_PRE_HOUR. Also remember to 
     do mod on hour and minutes, and normalize angle if it < 0 or > 180.*
     
6.  [Math] Write a method to get the greatest common divisor(GCD) of two given integer. And if you can't use division and mod.
    
    *HINT: while(i % j != 0) {int mod = i % j; i = j; j = mod; }, be careful the condition of i > j.
     Without division and mod, use Binary Bit Manipulation.*
     
         Avoid to use division and mode, instead using >> or & bit operation.
             if x, y both are even        f(x,y) = 2 * f(x/2, y/2)
             if x is even, y is not,      f(x,y) = f(x/2, y)
             if y is even, x is not,      f(x,y) = f(x, y/2)
             if x, y both are not even,   f(x,y) = f(x, y - x)

7.  [Combination] There are k exactly same boxes, and we have to put n exactly same items into them. Assume there is no limitation on box, 
    and the only requirement is that each item should be put into one box. Please write out the code to print out all the possible 
    possibilities, print error the input can not get any result. 
                   
    *HINT: standard combination problem, be careful is box could empty or not (add "index == k - 1" condition when print solution).*
       
8.  **[Math] In Lucky 7 sequence, we need remove all the number contains 7 from the integer, such as 7, 17, 71, etc, and define a method 
    to return corresponding number when giving a regular number, and decode the Lucky 7 number to the regular number.**

    *HINT: Consider this problem as convert this integer to base9 digit system, and if digit >= 7 increasing one.*
    
9.  [Math] Write a function to print out all the amicable numbers pair within 10000; amicable numbers pair is the numbers which the 
    sum of its real factor equals to the other. such as 220 and 284;
    
    *HINT: sum[i] to persist the sum of i's real factor, initialize sum[*] = 1, loop from 2 to N/2, calculate the sum.
    scan sum, if(sum[i] < N && sum[i] > i && i == sum[sum[i]]), i and sum[i] is a pair.*
    
10. [Array] N integer from 0 - N-1 form a cycle, start to delete number by visit M step. The process is started at 0.
    Given N and M, please write code to calculate which number will last at the final round.
    
    *HINT: The first round it will delete Mth number from 0. then the second round, it is N-1 number delete Mth start from M%N. 
    So f(N,M) = (f(N-1, M)+M) % N.*
    
11. **[Array/Application] There is N teams in a match. w[N][N] store the competition result between each two team, order[N] store 
    the order of team. At the first round, order[0] vs. order[1], and order[2] vs. order[3], etc. the winner comes to next round. 
    Finally comes the winner. Write code to compute the ranking of the match.**
    
    *HINT: use a rank[] to re-order the team, every time, team[i] compete team[i+1], the winter put in rank[group_start+i] and loser
    put in rank[group_start+group/2+i], every time, partition the group into 2 part, the group len loop from order.length to 1, and
    group_start loop from group_len * i. Remember to assign rank to order for next round competition.*
     
12. **[String/DFS] Having n string length is M + 1, here is a rule to conjoin 2 string together: if the prefix M character equals suffix M character.
    Write code to find the length of the conjoined string, and give a error when it could find a cycle.**
    
    *HINT: create a graph based on prefix-suffix matching, and find the longest path in the graph. Start from any nodes do DFS to
    find the longest path.*
    
13. **[Math/TwoPointer]Having N, find there exist how many continuous int sequence which sum is N.**
    Such as Given 15, 1+2+3+4+5 = 4+5+6 = 7+8 = 15, so output should be 3.
    
    *HINT: iteration over 1~(N+1)/2 using two pointer(start, end), keep tracking sum, when sum == N, found an answer. when sum >= N, 
     shrink start until sum < N.*
      
14. [Array] Write code to determine the 5 poker card is a straight or not. King can replaced to any card.

    *HINT: convert card to integer, sort and if missing number < count of King, it's a straight.*
    
15. [Math] Given N sieves, write code to calculate the possibility of each sum of all the sieves number.
    
    *HINT: it's a multinomial distribution problem, and also could be solve using DP.*
    
        p[s][k]: the how many times to get sum = s using k sieves
        initialize: p[i][1] = 1, p[i][i] = 1; p[6*i][i] = 1;
        function: p[s][k] = p[s-6][k-1] + p[s-5][k-1] + .. + p[s-1][k-1]
        result: p[s][k]/6^k
        since p[*][k] only depends on p[*][k-1] so can deduce space into 2*6*K = O(K)
        
16. [Math/Geometry] Given N points, every line go through 2 point, write code to find the line with largest slope.
    
    *HINT: enumerate every 2 points, calculate the slope and keep tracking the largest slope. Be careful when x is same.*
    
17. [Math] Given a integer, write code to check if it's a square of some integer, can't use sqrt()

    *HINT: only check if the number can be divided by prime * prime, (prime: 2,3,5,etc) until 1.*
    
18. [Math/Geometry] Given 4 points, write code to determine whether the 4 points is a rectangle or not.

    *HINT: don't assume the rectangle is align with x-axis. Need check slope, when vertical, the slope product is -1.
     The order of 4 points should be sorted based on x, if x equals sort based on y.*
     
        public static boolean isVertical(Point[] p, int i, int j, int k){    //(i-j) vertical to (i-k)
            return ((p[i].y - p[j].y) * (p[k].y - p[i].y))/((p[i].x - p[j].x) * p[k].x - p[i].x) == -1;
        }
        
19. [Math] Given a int number, write code to judge the number of all its factor is an even number or an odd number.

    *HINT: if the number is square of other number, its factor will be odd number, otherwise be even. Code refer to 17.*
    
20. [Math] Given a int N, write code to find the closest M < N which is power of 2.

    *HINT: only get the highest binary bit.*
    
21. [Math] Write code to get N prime numbers.

    *HINT: keep a prime[], loop on integer, check if it is dividable by any prime[i], if not, it's a new prime.*
    
22. **[Math/DP] Let A be a set of the first N positive integers :A={1,2,3,4.........N}.
    Write code to find such subset pair, (x,y), x and y are the subset of A; 
    Relation 1 pair: x not a subset of y, y is not a subset of x, and x,y have no intersection.
    Relation 2 pair: x not a subset of y, y is not a subset of x, and x,y have intersection.
    Given N, write code to calculate how many Relation 1 pair and Relation 2 pair.**
    
    *HINT:DP, Define the count of relation1 and relation2 when n element based on n-1 element case, try to think how to generate 
     those subset.*
    
        r1s[i] is the count of relation1 using element 1-i, r2s[i] is the count of relation2.
        1. r1s[i] = r1s[i - 1] + 2 * r1s[i - 1] + 2^(i - 1) - 1
            r1s[i-1] is the result set of 1~i-1, no i-th element in both x and y.
            2 * r1s[i - 1]: is created by add i-th element in x or y.
            2^(i - 1) - 1: is created by x = subset(1~i-1) y = i-th element
            combine together get r1s[i]
        2. r2s[i] = r2s[i - 1] + 3 * r2s[i - 1] + 3 * r1s[i - 1];
            r2s[i - 1] is the result set of 1~i-1, no i-th element in both x and y.
            3 * r2s[i - 1] is created by add i-th element in x or y, or both x and y.
            3 * r1s[i - 1] is created by add i-th element in the result of r1 in 1~i-1, each (x, y), 
            since (x,y) is the result of r1 so x and y have no intersection.
                (x+ith, y+ith) the intersection is i-th element
                (x+ith, x+y)   the intersection is x
                (x+y, y+ith)   the intersection is y.
            combine together get r2s[i]
        create a int array to hold r1s and r2s result, and calculate them in a loop
    
23. **[Math/BinarySearch] Given a integer N, find the minimal M to make N * M contains only 0 and 1. such as: N = 2, M = 5, N * M = 10.**

    *HINT: When N = 99, M = 1122334455667789L, can't search M by increasing 1 every step. So the N * M only contains 0 and 1, 
    so binary search N * M is much easier. 
    
        N*M should be composed only by 1 and 0, so let's make M = M*10 for each round. 
        How to handle 11 or 101 or 111, use mod[] saves different M % N, mod[i] save the 1 sequence which mod % N == i.
        Actually we don't need to apply 11, 101 and 111, 1001, 1101, etc, just add all mod[] to M.
        If (M + add)%N == 0, we found the number: (M+add)/N
        NOTE: need create a new _mod array for current round, and assign _mod to mod every round to 
              avoid mod[i] created in current round be used to add again.
              
Mark General 61