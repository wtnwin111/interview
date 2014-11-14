package com.interview.leetcode.arrays.searching;

/**
 * Created_By: stefanie
 * Date: 14-11-14
 * Time: 下午4:27
 *
 * Searching in array is a very typical algorithm, return its index if exist, return -1 if not found.
 * The condition of searching can be divided as following cases:
 *  each case will have implementations **L as Loop version and **R as Recursion version.
 *
 * Sorted or Partial Sorted
 * 1. searching given number in sorted array,   {@link com.interview.leetcode.arrays.searching.SearchingSortedArray}
 * 2. searching first/last/range appearance of a given number in a sorted array with duplication. {@link com.interview.leetcode.arrays.searching.SearchingSortedArrayWithDuplication}
 * 3. searching min/max/target in a given sorted rotated array. {@link com.interview.leetcode.arrays.searching.SearchingRotatedArray}
 *      min: array[mid] < array[mid - 1] indicate mid is min
 *           else array[mid] >= array[high]  min is in the right part, otherwise in left part
 *      max: array[mid] > array[mid + 1] indicate mid is max
 *           else array[mid] >= array[low]   max is in the right part, otherwise in left part
 *      find: get mid, if array[mid] == target return mid;
 *           if(target < array[mid]) should search in left, but if array[mid] >= array[low] && target < array[low] (low ~ mid is increasing and target is smaller than low) searching in right
 *           if(target > array[mid]) should search in right, but if array[mid] <= array[high] && target > array[high] (mid ~ high is increasing and target is larger than low), searching in left.
 *
 * 4. searching min/max/target in a given sorted rotated array with duplication.  {@link com.interview.leetcode.arrays.searching.SearchingRotatedArrayWithDuplication}
 *    basically have the same methodology as 3, but when have duplication, need check mid/low/high
 *      if array[mid] == array[low] == array[high], can decide left or right, just move as usual:
 *          min/max, low++
 *          find: if(target < array[mid]) low++, if(target > array[mid]) high--;
 * 5. searching min/target in an array first decrease than increase {@link com.interview.leetcode.arrays.searching.SearchingVArray}
 *      min: array[mid-1] > array[mid] && array[mid+1] > array[mid]
 *          if array[mid-1] < array[mid] -> mid in increasing part, and search min in low ~ mid-1.
 *          if array[mid+1] < array[mid] -> mid in decreasing part, and search min in high ~ mid + 1;
 *          if array[mid+1] == array[mid] == array[mid-1], can decide which part to search, low++;
 *      find: get mid, if array[mid] == target return mid;
 *          if target < array[mid]
 *            if array[mid-1] > array[mid] && array[mid+1] > array[mid], mid is min, so return -1;
 *            if array[mid-1] < array[mid] -> mid in increasing part, and search min in low ~ mid-1.
 *            if array[mid+1] < array[mid] -> mid in decreasing part, and search min in high ~ mid + 1;
 *            if array[mid+1] == array[mid] == array[mid-1], can decide which part to search, low++;
 *          if target > array[mid], need search left part if array[low] > target and right part if array[high] > target
 */
public class Searching {
}
