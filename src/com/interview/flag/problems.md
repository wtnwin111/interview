#G
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
#F
    1). Return the index of the max element in a vector, if there are several results, return them in the same probability.
    2). given a dict of words, find pair of words can concatenate to create a palindrome. 
    3). Given an array of integers, move all non-zero elements to the left of all zero elements.
    4-N). 给个数组seq， 和一个total，找 if there is a contiguous sequence in seq which sums to total.

#A
    1). Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s.
        Eg: Array- 1,1,0,0,1,0,1,1,1,0,1,1,1
        Output - index 9
        Assuming array index starts from 0. 
    2). Given an unsorted array, find the k smallest elements
        Array {9, 5, 1, 4, 13, 6}
        k = 3
        Output: 1, 4, 5 
    3). Find the minimum distance between any 2 given nodes in a tree.
    4). Find whether given LinkedList is Palindrome or not.
    5). Find Leader in Array (Leader means an element which is higher than all number which are indexed higher than element)
        same problem as #O2_MaxContinuousSeq, only scan from backward.
    6). Matrix is given which is of 0 and 1, all connected 1 forms island.    DFS
        Find how many island and the largest size island in given Matrix.
    7). Given a string, write a program to find longest length palindrome from that given string. 
        You can swap the characters of given string.
    8). Count how many inversion in a given array.
    9-N). In a party there are total n persons are there. every person is having one gift with him. 
        Every person will give his gift to another such that every person at the end has exactly one gift. 
        Any one can give his gift to anyone. say 5 people (A,B,C,D,E).
        A–>D    D–>C    C–>E    B–>A    E–>B
        Write a program to generate a random sequence. for every run, code should generate different sequence with equal probability. 
        O(n) time solution with O(1) space. Hint: selection sort
    10-N).Given a file having many words. Given K, find the words appearing >=K times.
    11-N).Design data structure that supports insert(), remove(), find-max(), delete-max() operations. 
        All operations should run in O(1) time. 
    12).Write program to find max size BST from given binary tree. 
        Algorithm and full working code was required for all the problems. 
        Discussed space and time complexity of every problem.
    13-N).Check if tree T1 is a subset of tree T2. 
        http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
    14-N).find Kth minimum element in a row-wise and column-wise sorted 2-d array.
        http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/
    
#L

#Other
    1). 给一个amount和一堆denomination，然后把所有的可能组成amount的denomination的组合输出出来 combination
    2). 给一个time series，要求计算这个值是最大的连续的天数
        input:  3 5 6 4 5 6 1 1 1  9 8 7
        output: 1 2 3 1 2 6 1 2 3 10 1 1
    3). Given an array A of integers, find the maximum of j-i subjected to the constraint of A[i] < A[j].
        C4_73
    4). Given an array of integers, write a method to find indices m and n such that if you sorted elements m through n, 
        the entire array would be sorted. Minimize n - m (that is find the smallest such sequence).
        Example: 1,2,4,7,10,11,7,12,6,7,16,18,19, return (3,9)
        C4_70

#Design and System Question
    1). 一台机器向1000台机器上拷贝文件。
    2). 迷宫，这个问题留下的时间不多，说是探讨要求生成的路尽量有趣，在入口和出口不确定的情况下，如何让生成的路尽量弯曲有趣。

