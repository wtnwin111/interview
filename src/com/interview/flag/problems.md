#G
    1). 将interval中的某个区间的父区间删除，正确的思路应该是先将区间按interval的开始值排序，然后从后往前扫描。(将区间按照interval的结束值排序，然后从前往后扫描应该是一样的）
    2). 一个数组，只能对其进行一种操作：将某个数移到数组的末尾，请问最少需要对其进行多少次这样的操作才能对其排序？
        正确的解法是，看数组中LIS的序列有多长，需要进行的操作次数为数组长度减去序列长度。
    3). 有一个圆和一个正方形，如何判断其是否相交。
    4-K). 一个数组 A: 1 3 0 2 4 7   input: dest-node: A0  output: all the source nodes: (A1, A3, A4)
        数组中每个元素表示他能走的步数，技能向左走 又能向右走，能到A[0]的点有A[1]和A[4]，A[1]可以走3步到A[4] A[4]能走4步道A[0]。
        输出所有能到A[0]的index。
    5). 数字反转180度，逆向反转，输出长度小于N的所有数字。如96196，数字反转180度是69169，然后逆转是96196，是他自己。
    6). 一个平面上有随机的k个目标点，还有一些墙，不能穿过，求一个点使得该点到所有目标点的距离和最小。
    7). 一个UTF-8字符串的问题。
    8). 迷宫，这个问题留下的时间不多，说是探讨要求生成的路尽量有趣，在入口和出口不确定的情况下，如何让生成的路尽量弯曲有趣。没太搞明白是要问什么。
#F
    1). Return the index of the max element in a vector, if there are several results, return them in the same probability.
    2). given a dict of words, find pair of words can concatenate to create a palindrome. 

#A

#L

#E

#System Question
    1). 一台机器向1000台机器上拷贝文件。

