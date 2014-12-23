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
21. Generate Parentheses. *Permutation, tracing retain left and right, right > left when add right.*
22. Merge K Sorted List. *Merge every two list*
    
        Time Complexity: O(NM * lgN)
        assume N list, each have M number, 
        1st round, merge every 2 list: 2 * M,  N/2 operation = N * M
        2nd round, merge every 2 list: 2 * 2M, N/4 operation = N * M
        total lgN round, so time complexity is O(NM * lgN), same as using Min Heap, 
        Space complexity: O(1)
23. Swap Nodes in Pair. *DummyHead*
    - be careful on the pointer assignment
24. Reverse Nodes in K Group. *DummyHead, Reverse List with three pointer.*
    - remember to set dummy.next = head, when create a dummyHead
    - count start from 1 and count < k
    - when tail != null do the reverse, and pre = cur, tail = pre.next, count = 1;
25. Divide Two Integer. *Minus*
    - use minus to do division, check how many divisor, given dividend can minus.
    - optimized solution is: try to minus most 2^i divisor (can be calculated by left shift).
    - clarify the edge case handling
    - carefully about negative dividend and divisor
    - use long to do the shift calculation to avoid overflow.
    - while condition a >= b
    - shift start from 0
    - update: a -= b << (shift - 1); and answer += (1 << (shift - 1)); 
26. **Substring Matcher**
    - Naive solution: for every position of str, try to check if it can match pattern. O(N^2).
    - KMP: optimize by minimize the backtracing in str, str only go forward, and pattern backtracing to least.
    - if not matched, if(j == 0) i++; else j = next[j];
    - if(j == pattern.length()) return i - j;
    - callNext() as the same process of strStr(); and next[0] = -1;
27. Substring with Concatenation of All Words
    - expected and found using HashMap.
28. Next Permutation. *find the first element not in decreasing order, then find the min element in left larger than current.*
    - check decreasing order: while(offset >= 0 && num[offset] >= num[offset + 1]) offset--;
    - find min element as the replaced num: while(replaceIdx >= 0 && num[replaceIdx] <= num[offset]) replaceIdx--;
29. Longest Valid Parentheses *DP*
    - len[i] is the longest valid parentheses end with (i-1)-th char, so s.charAt(i-1)
    
        State: len[i] the longest valid parentheses end with (i-1)-th char
        Init: len[0] = 0
        Transfer: if s.charAt(i-1) == '('   len[i] = 0
                  if s.charAt(i-1) == ')' && i - len[i-1] - 2 >= 0 && S.charAt(i-len[i-1] - 2) == ‘('
                         len[i] = len[i-1] + 2 + len[i-len[i-1] - 2]
        Answer: max of len[*]
30. Search for A Range. *Binary Search*
    - search first and last, high = mid and low = mid + 1;
    - first: return A[low] == target? low : -1; 
    - last:  return A[high] == target? high : high - 1;
31. Search in Rotated Array. *Binary Search*
    - low, mid, high is offset, not elements
    - if(A[low] <= A[mid] && target < A[low])
    - if(A[high] >= A[mid] && target > A[high])
32. Valid Sudoku. 
    - check each row, col, and cube
    - be careful about the index, row/col/i/j
33. Search Insertion Position. *Binary Search*
    - low < high
    - if(A[mid] >= target) high = mid; else low = mid + 1;
    - return (A[low] >= target)? low : low + 1;
34. Solve Soduku *Backtracing*
    - backtracing: find a placable char ['0' - '9'], if find, call solve() for next position, if can find, return false.
    - char k is between '1' to '9'
    - do loop on each position (i,j) to find a position is '.'
35. Count And Say
    - try to generate the sequence one step by one step
    - n--;
    - char curr = base.charAt(0), not int
36. Combination Sum *Backtracing Combination*
    - find all combination, and tracking the sum of combination.
    - sort num to de-dup
    - when sum + num[offset] == K, also need remove new-added element in cur.
    - when could reuse, do(offset, cur, sum + num[offset]) and remove new-added element then (offset + 1, cur, sum).
    - when not reuse, do (offset + 1, cur, sum + num[offset]) and remove new-added element then (offset + 1, cur, sum)
    - de dup by while(offset + 1 < num.length && num[offset + 1] == num[offset]) offset++;
37. First Missing Positive
    - put element in position it should be, 1 to A[0], 2 to A[1], then find the first element doesn't exist.
    - during scan, if swap, need i--;
    - position != i && A[position] != A[i], then swap
38. Trapping Rain Water *Forward/Backward, Max Index*
    - find the max index, and scan from left and right to center, tracking blocks and increasing total
    - when A[i] < A[left] or A[i] < A[right], blocks += A[i];
    - when find another boundry, total += A[left] * (i - left - 1) - blocks; remember to set blocks = 0;
39. **MultiplyString**
    - loop for the lowest digit in num1 and num2, and tracking carry
    - int[] num3 = new int[num1.length() + num2.length()];
    - init carry = 0 in every loop of i
    - after loop of j put carry to num3[i]; // num3[i + j + 1] where j is -1;
    - num3 is stored from lowest to highest digit, so need visit reversely when put in StringBuffer.
    - offset from 0 and offset < num1.length() + num2.length() - 1, omit highest 0
40. **Wildcard Matching** *Backtracing with last position of star*
    - keeping the last position of star and matched position in str for backtracing
    - remember to check p < pattern.length()
    - when pattern.charAt(p) == '*', starIdx = p, matched = s, p++;
    - when not match and not '*', and starIdx != -1, p = starIdx + 1, s = ++matched;
    - remember to go through the end '*' and return p == pattern.length();
41. Permutation
    - try to put every element in List and use a boolean[] to avoid duplication
    - to de dup: check if previous element with same value all used, if not have duplication
42. **Jump Game II** *DP*
    - scan from begin to last, find the min step from the first element to i-th element
    - only scan the point is reachable from the first element
    - if(A[0] >= i) steps[i] = 1;
    - find a jump point from 1 ~ i - 1; steps[j] != Integer.MAX_VALUE && j + A[j] >= i(could reach)
    - return steps[A.length - 1]
43. Rotate Image 
    - use layer to visit matrix layer by layer
    - for(int i = 0; i < last - layer; i++), rotate copy 
        matrix[layer][layer + i] <- matrix[last - i][layer] <- matrix[last][last - i] <- matrix[layer + i][last];
        
        matrix is 
            (layer, layer) .....    (layer, last)
                   ...                  ...
            (last, layer)  .....    (last, last)
44. Anagrams *HashMap*
45. N-Queens *Backtracing / Permutation*
    - check if current position can place: two queens can't put in diagonal line：(Math.abs(queens[i] - position) == offset - i)
    - fill queens with -1 for initialize
46. Pow(X, N) *double everytime*
    - basic method to do n times multiply x, a better way to do in 2's exponent, every time double the result.
    - consider n to be positive or negative, the base case will be n == 0/1/-1
    - consider n to be even or odd, do p1 = pow(x, n/2) and p2 = pow(x, n - 2*(n/2));
    - if n is even, p2 == 1, n is odd, p2 = -1/1 based on n's flag.
    - return p1 * p1 * p2
47. **N-Queens II** *Backtracing using loop*
    - scan from offset 0, and queens[offset] = -1;
    - while(offset >= 0 && offset < n) do searching by queens[offset]++;
    - try next position when can't fit: while(queens[offset] < n && !canPlace(offset, queens)) queens[offset]++;
    - if(queens[offset] == n) can't find a solution, offset--; backtrace
    - else if already in last queens, mark the solution, if not find the next queens by offset++, queens[offset] = -1;
48. Maximum Subarray *DP*
    - scan and tracking sum and max, if sum < 0, reset to 0.
    - if max == 0, return the largest elements in A.
49. **Spiral Matrix**
    - visit by layer: top, right, bottom and left.
    - int board = Math.min(rows, cols) + 1;
    - if rows != cols, layer should loop from [0 to board/2 - 1]
    - when layer == board/2 - 1 and Math.min(rows, cols) % 2 == 1, do loop the last two round on bottom and left.
50. Jump Game
    - scan i from 0 to A.length - 1, 
    - find a break point j from [0-i-1] where canJump[j] == true and A[j] + j >= i
51. Merge Interval *Sort by start*
52. Length of Last Word. *String parsing*
    - string.length()
    - be careful of index begin and end.
53. Spiral Matrix II. 
    - use layer, loop from [0 ~ (n + 1)/2];
    - when n is odd, omit the bottom and left loop on last round
54. **Permutation Sequence** *Math/Factor*
    - permutation with n digits will have n! elements, based on this rule find K-th element
    - calculate factors from [0, n], factors[0] = 1;
    - for initialize: k-- and k = k % factors[n];
    - for every offset: k -= cur * factors[n - 1] and n--;
55. Rotate List *Fast/Slow Pointer*
    - get length and normalize n = n % length;
    - when(n > 0) n-- and fast = fast.next;
    - then fast and slow go together when fast.next != null;
56. Insert Interval *Iterator*
    - mark overlapped interval to newInterval, and remove overlapped one in intervals.
    - use Iterator to enable remove during scan
    - check index == intervals.size(), in this case intervals.add(newInterval), other case intervals.add(index, newInterval);
57. Unique Path I, II *Matrix DP*
58. Minimum Path Sum *Matrix DP*
59. Merge Two Sorted Lists *DummyNode*
60. Add Binary *Bit Manipulation*
61. **Valid Number** *String Parsing*
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
62. 
        
    
        
    
        
    
    
    
    

