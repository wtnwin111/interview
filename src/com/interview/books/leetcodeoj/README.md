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
8.  String to Integer. *try to parse the str and build an integer*
    - remember to handle negative case: parse sign
    - use method in Character to make clean code: Character.isWhitespace(), Character.isDigit(),Character.getNumericValue();
    - remember to check overflow, num == max && digit >= 8. (INT_MAX (2147483647) or INT_MIN (-2147483648))
    - return MAX_VALUE or MIN_VALUE based on sign: sign == 1? Integer.MAX_VALUE : Integer.MIN_VALUE; 
9.  Palindrome Number. *reverse and check equals.*
    - check overflow when reverse
    - clarify return what for negative: just false;
10. RegularExpressionMatching. *Two Sequence DP*
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
11. 

