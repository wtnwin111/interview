package com.interview.leetcode.list;

import com.interview.leetcode.utils.ListNode;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 下午7:08
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 *
 * 1. reverse the linked list as Ln→Ln-1→...L1→L0
 *      reverse the whole list  {@link #reverse}
 *      reverse one part of the list, start at prev.next and end with tail   {@link #reverseUtilTail}
 *      reverse one part of the list, from m ~ n  {@link #reverseBetween}
 * 2. interleaving two linked list  {@link #interleaving}
 *      first   A0→A1→...An-1→An   second B0→B1→...Bn-1→Bn
 *      result  A0→B0→A1→B1→...An-1→Bn-1→An→Bn
 * 3. if a linked list have cycle and the begin node of the cycle {@link #hasCycle} {@link #detectCycle}
 * 4. partition list by a given target, node smaller go before, and larger or equals go after. {@link #partition}
 * 5. sort list: better using merge sort, constant space and O(nlgn)  {@link #mergeSort}
 *       use length to partition list into two half, remember to set the tail to null when return list (length == 1)
 * 6. reverse nodes in k-group.
 *
 * Tricks:
 *  1. two pointer: fast and slow
 *  2. recursive: use return value or prev node in the parameter, the length of the list
 *  3. be careful when do pointer change, create temp node if needed.
 *
 */
public class ListOperation {
    public static ListNode getMiddle(ListNode node){
        ListNode fast = node;
        ListNode slow = node;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode node){
        ListNode fakeHead = new ListNode(0);    //create a fake head as the prev
        fakeHead.next = node;
        reverse(node, fakeHead);
        return fakeHead.next;
    }

    /**
     * if haven't reach the end, keep recursive call
     *   when reach the end, set prev.next = tail, return itself.
     * in the return of recursive call, set the returned node.next = current node
     */
    private static ListNode reverse(ListNode node, ListNode prev){
        if(node.next == null){  //node is tail
            prev.next.next = node.next;
            prev.next = node;
        } else {
            prev = reverse(node.next, prev);
            prev.next = node;
        }
        return node;
    }

    public static ListNode reverseUtilTail(ListNode node, ListNode tail, ListNode prev){
        if(node == tail){
            prev.next.next = tail.next;
            prev.next = tail;
        } else  {
            prev = reverseUtilTail(node.next, tail, prev);
            prev.next = node;
        }
        return node;
    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        reverseBetween(head, m, n, 1, fakeHead);
        return fakeHead.next;
    }

    private static ListNode reverseBetween(ListNode node, int m, int n, int count, ListNode prev){
        if(count < m){
            reverseBetween(node.next, m, n, count + 1, node);
        } else if(count >= m && count < n){
            prev = reverseBetween(node.next, m, n, count + 1, prev);
            prev.next = node;
        } else if(count == n){
            prev.next.next = node.next;
            prev.next = node;
        }
        return node;
    }

    /**
     * create temp node for both next
     */
    public static void interleaving(ListNode first, ListNode second){
        while(first != null && second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null &&fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow;
    }

    /**
     * when init fast as head.next, when fast and slow meet,
     * slow should go one step ahead, in order to meet fast at the begin point
     */
    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null &&fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != slow) return null;
        slow = slow.next;  //due to line 15, fast is one step ahead.
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * like quicksort code, p as i and q as j
     */
    public static ListNode partition(ListNode head, int x) {
        //if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        while(q.next != null){
            if(q.next.val >= x) q = q.next;    //larger or equals, leave it alone
            else {
                if(p == q)  q = q.next;
                else { //insert q.next after p
                    ListNode tmp = q.next;
                    q.next = tmp.next;
                    tmp.next = p.next;
                    p.next = tmp;
                }
                p = p.next;
            }
        }
        return newHead.next;
    }

    public static int length(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }

    public static ListNode mergeSort(ListNode head){
        int length = length(head);
        return mergeSort(head, length);
    }

    private static ListNode mergeSort(ListNode head, int length){
        if (length == 1) {
            head.next = null;
            return head;
        }
        ListNode mid = head;
        for (int i = 0; i < length / 2; i++)   mid = mid.next;
        head = mergeSort(head, length / 2);
        mid = mergeSort(mid, length - length / 2);
        return merge(head, mid);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 == null) prev.next = l2;
        else prev.next = l1;
        return fakeHead.next;
    }

    /**
     * 1. find the mid and tail using fast and slow pointer moving
     * 2. reverse the node from mid.next ~ tail
     * 3. do interleaving head and mid.next
     *      remember to set mid.next = null to end the first list before run interleaving
     */
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;  //show stop at one before mid
        }
        if(fast.next != null) fast = fast.next; //fast as the tail
        reverseUtilTail(slow.next, fast, slow);
        ListNode second = slow.next;
        slow.next = null;
        interleaving(head, second);
    }
}
