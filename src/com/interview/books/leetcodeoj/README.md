#Question and Answer of LeetCode Online Judge

1.  Two Sum. *HashMap*
    - index start from 1
    - new int[0] and new int[]{.....}
    - map.containsKey(key); 
2.  **Median Of Two Sorted Array.**
   *find the k-th elements in A+B. do binary search on shorter array to find the first element not in topK.*
    - do binary search on shorter array
    - K is started from 1, so findKthElement(A, B, median + 1);
    - binary search: int high = A.length; and if(bIdx >= B.length || A[mid] < B[bIdx]) low = mid + 1;
    - check index out of range when get prevA and prevB
3.  Longest Substring without Duplicate Chars. *Index Array[256], update start with find duplication.*
    - fill indexes with -1, Arrays.fill(indexes, -1);
    - no dup when indexes[s.charAt(i)] < start
    - update maxLen every time if no dup: maxLen = Math.max(maxLen, i - start + 1);
4.  Add Two Number (List) *Dummy node, Carry*
    - move prev, l1, l2 one step forward
5.  **Longest Palindrome Substring** *Scan by center for both even and odd case.*
    - for each position: find the palindrome which center is this char(odd) or this char and it's next char.(even)
    - position loop 0 ~ length - 1;
    - do while loop when charAt(i - len) == charAt(i + len), and calculate len when break using (len - 1);
    - remember to check index out of range before call charAt(i);
6.  ZigZag Conversion *StringBuffer*
    - use n StringBuffer to store data in each row.
    - init StringBuffer array
    - careful about row increase and decrease, and when to set down
7.  Reverse Integer
    - UPPER_BOUND = Integer.MAX_VALUE/10;
    - handle negative case using flag and x = Math.abs(x);
    - clarify return what when the number overflow.
8.  **String to Integer.** *try to parse the str and build an integer*
    - remember to handle negative case: parse sign
    - use method in Character to make clean code: Character.isWhitespace(), Character.isDigit(),Character.getNumericValue();
    - remember to check overflow, num == max && digit >= 8. (INT_MAX (2147483647) or INT_MIN (-2147483648))
    - return MAX_VALUE or MIN_VALUE based on sign: sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE; 
9.  Palindrome Number. *reverse and check equals.*
    - check overflow when reverse
    - clarify return what for negative: just false;
10. **RegularExpressionMatching.** *Two Sequence DP*
    - '.' can matching any char in matchChar(i, j)
    
        state: match[i][j]: if s.substring(0,i) can matchChar p.substring(0,j);
        init: match[0][0] = true, if(p.charAt(j - 1) == '*') match[0][j] = match[0][j-2]
        function: match[i][j] = true if
              1. match[i-1][j-1] && matchChar(i, j)
              2. if(p.charAt(j - 1) == '*'
                2.1 match[i][j-2]    //""  matching "a*"
                2.2 matchChar(i, j - 1) && (match[i-1][j] || match[i][j-1])
                              match[i][j-1]    //"aa" matching "a*"
                              match[i-1][j]    //"a"  matching "a*"
        result: match[s.length()][p.length()]
        matchChar(i, j): means (p.charAt(j - 1) == '.' or s.charAt(i - 1) == p.charAt(j - 1)
11. Container with Most Water. *Two Pointer: Left and Right*
    - area = Math.min(height[i], height[j]) * (j - i);
    - width = (j-i) not (j-i+1)
12. Integer to Rome. *From High to Low.*
13. Rome to Integer. *The relation with next bit.*
14. Longest Common Prefix. 
    - use strs[0] as pivot and remember to check offset >= strs[i].length() for other str.
15. Three Sum. *Sort and Two Pointer.*
    - i, j, k is the offset not element;
    - inner while
    - de dup using while
16. Three Sum Closest. *Sort and Two Pointer.*
    - tracking closest and return closest + target
    - i, j, k is offset, not elements.
17. Letter Combinations of a Phone Number. *Permutation*
    - use String to hold all the options
    - init global class variable carefully
    - for recursive permutation generation, be carefully about when to return, if(offset >= digits.length())
18. Four Sum. *Sort and Two Pointer*
    - i, j, k is all offset, not element
    - de dup;
19. Remove N-th Node from End of the List. *Two Pointer: Slow and Fast*
    - use slow and fast pointer to scan the list, fast is n + 1 steps forward, 
    - delete the next node of slow
    - be careful about n > len(list). if(fast == null && n > 0) return dummy.next;
    - use sample to verify the condition
20. Valid Parentheses. *Stack and HashMap*
    - return stack.isEmpty() when parse over the string.
21. Merge Two Sorted Lists *DummyNode*
22. Generate Parentheses. *Permutation, tracing retain left and right, right > left when add right.*
23. Merge K Sorted List. *Merge every two list*
    
        Time Complexity: O(NM * lgN)
        assume N list, each have M number, 
        1st round, merge every 2 list: 2 * M,  N/2 operation = N * M
        2nd round, merge every 2 list: 2 * 2M, N/4 operation = N * M
        total lgN round, so time complexity is O(NM * lgN), same as using Min Heap, 
        Space complexity: O(1)
24. Swap Nodes in Pair. *DummyHead*
    - be careful on the pointer assignment
25. Reverse Nodes in K Group. *DummyHead, Reverse List with three pointer.*
    - remember to set dummy.next = head, when create a dummyHead
    - count start from 1 and count < k
    - when tail != null do the reverse, and pre = cur, tail = pre.next, count = 1;
26. Remove Duplicates from Sorted Array *Two Pointer*
27. Remove Element *Two Pointer*
28. **Substring Matcher**
    - Naive solution: for every position of str, try to check if it can match pattern. O(N^2).
    - KMP: optimize by minimize the backtracing in str, str only go forward, and pattern backtracing to least.
    - if not matched, if(j == 0) i++; else j = next[j];
    - if(j == pattern.length()) return i - j;
    - callNext() as the same process of strStr(); and next[0] = -1;
29. Divide Two Integer. *Minus*
    - use minus to do division, check how many divisor, given dividend can minus.
    - optimized solution is: try to minus most 2^i divisor (can be calculated by left shift).
    - clarify the edge case handling
    - carefully about negative dividend and divisor
    - use long to do the shift calculation to avoid overflow.
    - while condition a >= b
    - shift start from 0
    - update: a -= b << (shift - 1); and answer += (1 << (shift - 1)); 
30. Substring with Concatenation of All Words
    - expected and found using HashMap.
31. Next Permutation. *find the first element not in decreasing order, then find the min element in left larger than current.*
    - check decreasing order: while(offset >= 0 && num[offset] >= num[offset + 1]) offset--;
    - find min element as the replaced num: while(replaceIdx >= 0 && num[replaceIdx] <= num[offset]) replaceIdx--;
32. Longest Valid Parentheses *DP*
    - len[i] is the longest valid parentheses end with (i-1)-th char, so s.charAt(i-1)
    
        State: len[i] the longest valid parentheses end with (i-1)-th char
        Init: len[0] = 0
        Transfer: if s.charAt(i-1) == '('   len[i] = 0
                  if s.charAt(i-1) == ')' && i - len[i-1] - 2 >= 0 && S.charAt(i-len[i-1] - 2) == ‘('
                         len[i] = len[i-1] + 2 + len[i-len[i-1] - 2]
        Answer: max of len[*]
33. Search in Rotated Array. *Binary Search*
    - low, mid, high is offset, not elements
    - if(A[low] <= A[mid] && target < A[low])
    - if(A[high] >= A[mid] && target > A[high])
34. Search for A Range. *Binary Search*
    - search first and last, high = mid and low = mid + 1;
    - first: return A[low] == target? low : -1; 
    - last:  return A[high] == target? high : high - 1;
35. Search Insertion Position. *Binary Search*
    - low < high
    - if(A[mid] >= target) high = mid; else low = mid + 1;
    - return (A[low] >= target)? low : low + 1;
36. Valid Sudoku. 
    - check each row, col, and cube
    - be careful about the index, row/col/i/j
37. Sodoku Solver *Backtracing*
    - backtracing: find a placable char ['0' - '9'], if find, call solve() for next position, if can find, return false.
    - char k is between '1' to '9'
    - do loop on each position (i,j) to find a position is '.'
38. Count And Say
    - try to generate the sequence one step by one step
    - n--;
    - char curr = base.charAt(0), not int
39. Combination Sum I and Combination Sum II *Backtracing Combination*
    - find all combination, and tracking the sum of combination.
    - sort num to de-dup
    - when sum + num[offset] == K, also need remove new-added element in cur.
    - when could reuse, do(offset, cur, sum + num[offset]) and remove new-added element then (offset + 1, cur, sum).
    - when not reuse, do (offset + 1, cur, sum + num[offset]) and remove new-added element then (offset + 1, cur, sum)
    - de dup by while(offset + 1 < num.length && num[offset + 1] == num[offset]) offset++;
40. Combination Sum II *same as 39* 
41. First Missing Positive
    - put element in position it should be, 1 to A[0], 2 to A[1], then find the first element doesn't exist.
    - during scan, if swap, need i--;
    - position != i && A[position] != A[i], then swap
42. Trapping Rain Water *Forward/Backward, Max Index*
    - find the max index, and scan from left and right to center, tracking blocks and increasing total
    - when A[i] < A[left] or A[i] < A[right], blocks += A[i];
    - when find another boundry, total += A[left] * (i - left - 1) - blocks; remember to set blocks = 0;
43. **MultiplyString**
    - loop for the lowest digit in num1 and num2, and tracking carry
    - int[] num3 = new int[num1.length() + num2.length()];
    - init carry = 0 in every loop of i
    - after loop of j put carry to num3[i]; // num3[i + j + 1] where j is -1;
    - num3 is stored from lowest to highest digit, so need visit reversely when put in StringBuffer.
    - offset from 0 and offset < num1.length() + num2.length() - 1, omit highest 0
44. **Wildcard Matching** *Backtracing with last position of star*
    - keeping the last position of star and matched position in str for backtracing
    - remember to check p < pattern.length()
    - when pattern.charAt(p) == '*', starIdx = p, matched = s, p++;
    - when not match and not '*', and starIdx != -1, p = starIdx + 1, s = ++matched;
    - remember to go through the end '*' and return p == pattern.length();
45. **Jump Game II** *DP*
    - scan from begin to last, find the min step from the first element to i-th element
    - only scan the point is reachable from the first element
    - if(A[0] >= i) steps[i] = 1;
    - find a jump point from 1 ~ i - 1; steps[j] != Integer.MAX_VALUE && j + A[j] >= i(could reach)
    - return steps[A.length - 1]
46. Permutation *Backtracing*
    - try to put every element in List and use a boolean[] to avoid duplication
    - to de dup: check if previous element with same value all used, if not have duplication
47. Permutation II *Backtracing as 46*
48. Rotate Image 
    - use layer to visit matrix layer by layer
    - for(int i = 0; i < last - layer; i++), rotate copy 
        matrix[layer][layer + i] <- matrix[last - i][layer] <- matrix[last][last - i] <- matrix[layer + i][last];
        
        matrix is 
            (layer, layer) .....    (layer, last)
                   ...                  ...
            (last, layer)  .....    (last, last)
49. Anagrams *HashMap*
50. Pow(X, N) *double everytime*
    - basic method to do n times multiply x, a better way to do in 2's exponent, every time double the result.
    - consider n to be positive or negative, the base case will be n == 0/1/-1
    - consider n to be even or odd, do p1 = pow(x, n/2) and p2 = pow(x, n - 2*(n/2));
    - if n is even, p2 == 1, n is odd, p2 = -1/1 based on n's flag.
    - return p1 * p1 * p2
51. N-Queens *Backtracing / Permutation*
    - check if current position can place: two queens can't put in diagonal line：(Math.abs(queens[i] - position) == offset - i)
    - fill queens with -1 for initialize
52. **N-Queens II** *Backtracing using loop*
    - scan from offset 0, and queens[offset] = -1;
    - while(offset >= 0 && offset < n) do searching by queens[offset]++;
    - try next position when can't fit: while(queens[offset] < n && !canPlace(offset, queens)) queens[offset]++;
    - if(queens[offset] == n) can't find a solution, offset--; backtrace
    - else if already in last queens, mark the solution, if not find the next queens by offset++, queens[offset] = -1;   
53. Maximum Subarray *DP*
    - scan and tracking sum and max, if sum < 0, reset to 0.
    - if max == 0, return the largest elements in A.
54. **Spiral Matrix**
    - visit by layer: top, right, bottom and left.
    - int board = Math.min(rows, cols) + 1;
    - if rows != cols, layer should loop from [0 to board/2 - 1]
    - when layer == board/2 - 1 and Math.min(rows, cols) % 2 == 1, do loop the last two round on bottom and left.
55. Jump Game
    - scan from A.length - 1 to 0, and tracking the lowest place can jump to the end
    - if A[i] + i >= lowest, position i can jump to end, otherwise can't. lowest should update when find a lower position.     
56. Merge Interval *Sort by start*
57. Insert Interval *Iterator*
    - mark overlapped interval to newInterval, and remove overlapped one in intervals.
    - use Iterator to enable remove during scan
    - check index == intervals.size(), in this case intervals.add(newInterval), other case intervals.add(index, newInterval);
58. Length of Last Word. *String parsing*
    - string.length()
    - be careful of index begin and end.
59. Spiral Matrix II. 
    - use layer, loop from [0 ~ (n + 1)/2];
    - when n is odd, omit the bottom and left loop on last round
60. **Permutation Sequence** *Math/Factor*
    - permutation with n digits will have n! elements, based on this rule find K-th element
    - calculate factors from [0, n], factors[0] = 1;
    - for initialize: k-- and k = k % factors[n];
    - for every offset: k -= cur * factors[n - 1] and n--;
61. Rotate List *Fast/Slow Pointer*
    - get length and normalize n = n % length;
    - when(n > 0) n-- and fast = fast.next;
    - then fast and slow go together when fast.next != null;
62. Unique Path I *Matrix DP*
63. Unique Path II *Matrix DP*
64. Minimum Path Sum *Matrix DP*
65. **Valid Number** *String Parsing, Clean Code*
    - clarify what is valid and what is invalid.
        - the whitespace at begin and end is valid, such as "  34   "
        - positive and negative flag is valid, such as "-1" or "+1"
        - number could be double, such as "1.234"
        - number could contains E exponent, such as "1e30" or "1e-30", but can't be "1e3.2"
    - parse the string by rules, and check if can parse to the end and contains a valid number
        - parse begin ' '
        - parse positive or negative flag
        - parse digit numbers  (isNumber = true)
        - parse '.' than parse digit numbers (isNumber = true)
        - parse 'e' (isNumber = false)
        - parse positive or negative flag
        - parse digit numbers  (isNumber = true)
        - parse end ' '
        - check if isNumber == true && offset == n
66. Plus One *carry*
67. Add Binary *Bit Manipulation*
68. **Text Justification** *String, Clean Code*
    - trick is do clear calculation on spaceNeeded, spaceCount, spaceSlot, spaceEach, spaceExtra
        - spaceNeeded = curLen + words[i].length() + (i - begin)
        - spaceCount = L - curLen
        - spaceSlot = i - begin - 1; 
        - spaceEach = spaceCount/spaceSlot, 
        - spaceExtra = spaceCount%spaceSlot
            - (spaceEach + (j - begin < spaceExtra? 1 : 0))
    - also be careful about the edge case of i and j
        - i == words.length: last line
        - j != i - 1: not last word
    - scan word one by one, and tracking begin and curLen of words
    - if last line or space_needed > L, create a string, else curLen += words[i].length();
    - when create line, if spaceSlot == 0 or it's last line, 
        - put 1 space between the words
        - L - buffer.length() space at the end
    - else put (spaceEach + (j - begin < spaceExtra? 1 : 0)) space between each word.
    - set begin = i and curLen = i < words.length? words[i].length() : 0;
69. Sqrt *Math, BinarySearch*
    - do binary search on range[0, x], using long to avoid overflow of mid * mid
    - if can't find a sqrt, check the low * low <= x? return low otherwise return low - 1;
    - be careful of the change of int and long
70. Climbing Stairs *DP*
    - optimize space complexity to constant space by mod. ways[i%3] = ways[(i - 2)%3] + ways[(i - 1)%3];
71. Simplify Path *String, Two Pointer*
    - edge cases: null, "/", "/.",
    - three different cases: ".", "..", "a"
    - string equals uisng .equals() not ==
    - when offset == 0, don't do offset-- when steps[i].equals("..");
    - return "/" when offset == 0
72. Edit Distance *Two Sequence DP*
    
        state: distance[i][j]: the min edit distance of a.substring(0, i) and b.substring(0, j);
        initialize: distance[i][0] = i and distance[0][j] = j
        function: distance[i][j] = distance[i-1][j-1] if a.charAt(i - 1) == b.charAt(j - 1)
                  distance[i][j] = min(distance[i-1][j-1], distance[i-1][j], distance[i][j-1]) + 1, 
                                                      if a.charAt(i - 1) != b.charAt(j - 1)
        result: distance[a.length][b.length];
73. Set Matrix Zeros *Scan and Clean*
    - use the row and col of first zero to store the mark.
    - check if row == -1 after a full scan, directly return
    - check i != row and j != col when do reset in second stage.
74. Search in 2D Matrix *BinarySearch*
    - do binary searching in range [0, rows * cols - 1];
    - while(low <= high) do search
    - convert mid into (row, col) and check the value match. row = mid / cols, and col = min % cols.
75. Sort Color *Three Way Quick Partition*
    - keep two pointer: small(before element are smaller than key), equal(between small and equal are equals to key)
    - scan the array
        - if A[j] == key, swap(A, ++equals, j)
        - if A[j] < key, swap(A, ++small, j) and equal++, then check if(A[equal] > A[j]) swap(A, equal, j);
76. Minimum Window Substring *String Mark*
    - use two int[256] as expected and found to scan T and S
    - once found all the chars in T, shrink begin to get minimum window
    - while(begin < S.length()) when shrink begin
    - update window: if(window == "" || i - begin + 1 < window.length()) window = S.substring(begin, i + 1);
77. Combination *Backtracing*
    - a solution is cur.size() == K
78. Subset *Backtracing*
    - de dup by sort(S) and while(offset < S.length - 1 && S[offset + 1] == S[offset]) offset++;
79. Word Search
    - in dfs, if(word.length() == 1) return true;
    - in dfs, visited[row][col] = true and String suffix = word.substring(1);
    - remember to mark visited[row][col] = false when return false;
80. Remove Duplicated from Sorted Array II *Two Pointer*
    - tracking occurrence, if A[i] == A[i-1] && occurrence == 2, just continue
    - if A[i] != A[i-1] then occurrence = 1; else occurrence++, and copy A[i] to A[offset++];
81. Search in Rotated Sorted Array II *Binary Search*
    - de-dup while(low < high && A[low] == A[high]) high--;
82. Remove Duplicates from Sorted List II *Three Pointer*
    - use three pointer: prev, front and back.
    - while(back != null && back.val == front.val) back = back.next;
    - if(front.next == back) prev.next = front; prev = prev.next;
    - set prev.next = null at the end.
83. Remove Duplicates from Sorted List I *Two Pointer*
    - prev = prev.next;
84. **Largest Rectangle In Histogram** *Stack*
    - while(!stack.isEmpty() && (i == height.length || height[i] < height[stack.peek()])) pop and calculate
    - offset = stack.pop(); and int width = stack.isEmpty()? i : i - stack.peek() - 1; area = width * height[offset]
    - remember to push i in stack
    
        the area of [i,j] is the min(A[i]...A[j]) * (j - i + 1); Optimize get min(A[i]...A[j]) use Stack
        put index in Stack to calculate (j - i + 1), and put element in Stack in increasing sequence
        the increasing sequence make sure: height = height[offset], width = i - stack.peek() - 1
        when found a element not in increasing sequence, pop all the element in stack to keep increasing sequence.
85. **Largest Rectangle** *DP, Stack*
    - use largestRectangleArea() method, loop every row to calculate histogram
    - matrix is char[][], so need check matrix[i][j] == '0'
86. Partition List
    - keep smallHead, largeHead, and small, large
    - large.next = null and small.next = largeHead.next;
87. **Scramble String** *DP*
    - String DP: Three dimensional DP matrix, scramble[len][i][j], and loop len, i, j
    
        state: scramble[len][i][j], whether substring of length len start from i in s1 and j in s2 are scramble.
        initialize: scramble[1][i][j] = true, if s1.charAt(i) == s2.charAt(j)
        function: scramble[len][i][j] = true for any cutting point k from 1 to len - 1 meeting one of the following conditions:
                  1) scramble[k][i][j] and scramble[len-k][i+k][j+k]
                  2) scramble[k][i][j+len-k] and scramble[len-k][i+k][j]
        result: scramble[n][0][0]   
88. Merge Sorted List *Two Pointer, Scan Backward*
    - scan backward
89. Grey Code
    - grey code is i ^ (i >> 1)
90. Subset II *Backtracing, Dedup by sort*
    - de dup by sort(S) and while(offset < S.length - 1 && S[offset + 1] == S[offset]) offset++;
91. Decode Ways *DP*
    - edge case: s.charAt(0) == '0' return 0;
    - invalid case: "0", "01", "30"
    - valid case: 
        - "10/20":  ways[i] = ways[i-2]
        - "27/201": ways[i] = ways[i-1]
        - others:   ways[i] = ways[i-1] + ways[i-2]
        
        state: ways[i]: is the decode ways of s.substring(0, i);
        initialize: ways[0] = 1, ways[1] = 1;
        function: cur = s.charAt(i - 1), pre = s.charAt(i - 2)
                  if(cur == '0') 
                      if(pre == '0' || pre > '2') return 0;
                      else ways[i] = ways[i-2];
                  else num = (pre - '0') * 10 + (cur - '0');
                      if(num < 10 || num > 26) ways[i] = ways[i - 1];
                      else ways[i] = ways[i-1] + ways[i-2];
        result: ways[s.length]
92. Reverse Linked List II *DummyNode*
    - find the prev, and tail based on m and n
    - reverse nodes between prev.next and tail
93. **Restore IP Address** *Backtracing, Permutation*
    - based on permutation
    - offset == chars.length && count == 0, prefix is a valid solution
    - calculate available char, if available < count || available > count * 3, it's not a valid solution
    - permutate on different solution: of 1 ~ 3 chars, and offset + i <= chars.length on loop condition
    - invalid option: option.length() > 1 && option.charAt(0) == '0' and Integer.parseInt(option) > 255
94. **Binary Tree In-order Traversal** *Stack*
    - use Stack to push node.left;
    - the while loop condition: (root != null || !stack.isEmpty())
    - root = stack.pop(), nodes.add(root.val), root = root.right;
95. **Unique Binary Search Trees II** *Permutation*
     - BST: the left subtree is smaller than root, and the right subtree is larger than root
     - use low and high to do permutation
96. Unique Binary Search Trees *Backtracing, 
    - catalan sequence
    - for every left = 0..left - 1; nums[total] += num[left] * num[total - 1 - left];
97. Interleaving String *DP*
    - edge case: if(s1.length() + s2.length() != s3.length()) return false;

        state: interleaving[i][j]: if s3.substring(0, i+j) is interleaving string of s1.substring(0, i) and s2.substring(0, j).
        initialize:   interleaving[i][0] == true when s3.charAt(i - 1) == s1.charAt(i - 1)
                      interleaving[0][j] == true when s3.charAt(j - 1) == s2.charAt(j - 1)
        function:     interleaving[i][j] == true when 
                          s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaving[i-1][j]
                          s3.charAt(i + j - 1) == s2.charAt(j - 1) && interleaving[i][j-1]
        result:       interleaving[s1.length()][s2.length()]
98. Recover Binary Search Tree *In-order Traverse*
    - find the breakpoint during in-order traverse by checking last visited node
    - swap the values of breakpoint node
99. Same Tree *Pre-order Traverse*
     - check root, then check left-subtree and right-subtree
100. Symmetric Tree *Pre-order Traverse*
     - check left child and right child, than check left.left = right.right and left.right = right.left
101. Binary Tree Level Order Traverse *Queue*
     - use Queue and loop on queue.size() for every level
102. Binary Tree ZigZag Level Order Traverse *Queue*
     - use Queue and tracking isEven level.
103. Maximum Depth of Binary Tree *Post-order Traverse*
104. Construct Binary Tree from Preorder and Inorder Traversal *Divide and Conquer*
     - use preorder[offset] to divide inorder into left and right part as left/right subtree.
     - offset should be class attribute to enable offset++.
     - build left subtree before right subtree
105. Construct Binary Tree from Postorder and Inorder Traversal *Divide and Conquer*
     - offset initialize as inorder.length - 1, and offset--
     - during buildTree, build right(position + 1, high) before build left(low, position - 1)
106. Convert Sorted Array to Binary Search Tree *Divide and Conquer*
     - find the mid to create node, node.left = (low, mid - 1) and node.right = (mid + 1, high)
107. **Convert Sorted List to Binary Search Tree** *In-order Traversal, Length*
     - base in-order traversal to build a tree.
     - use current to tracking visited node in list, and length to tracking when to return.
     - left part is length/2, the right part is length - 1 - length/2;
108. Balanced Binary Tree *Post-order Traverse*
     - if balanced return height, if not return -1.
     - check left subtree and right subtree, then check node itself.
109. 

    
    
    

        



        
    
        
    
        
    
    
    
    

