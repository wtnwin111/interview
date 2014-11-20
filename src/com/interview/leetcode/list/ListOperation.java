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
 * 5. sort list: better using merge sort, constant space and O(nlgn)  move to {@link com.interview.leetcode.list.ListSort}
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

    public static ListNode getMiddlePre(ListNode node){
        ListNode fast = node.next;
        ListNode slow = node;
        while(fast != null & fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static class Reverser{

        public static ListNode reverse(ListNode node){
            ListNode newHead = null;
            while(node != null){
                ListNode temp = node.next;
                node.next = newHead;
                newHead = node;
                node = temp;
            }
            return newHead;
        }

        public static void reverse(ListNode node, ListNode tail, ListNode prev){
            ListNode newHead = tail.next;
            while(newHead != tail){
                ListNode temp = node.next;
                node.next = newHead;
                newHead = node;
                node = temp;
            }
            prev.next = newHead;
        }

        public ListNode reverseKGroup(ListNode head, int k) {  //0->1->2->3->4->5  -> 0->2->1->4->3->5
            if(head == null || k == 1) return head;
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode prev = dummyNode;
            while(head != null){
                int i = k;
                while(head != null && i > 1){
                    head = head.next;
                    i--;
                }
                if(head == null) break;
                ListNode next = prev.next;
                reverse(prev.next, head, prev);  //prev: 0, head: 2, prev.next = 2, next = 1
                prev = next;
                head = prev.next;
            }
            return dummyNode.next;
        }



        public static ListNode reverseBetweenL(ListNode head, int m, int n){
            ListNode dummyNode = new ListNode(0);
            dummyNode.next = head;
            ListNode prev = dummyNode;
            n = n - m + 1;
            while(m > 1){
                head = head.next;
                prev = prev.next;
                m--;
            }
            ListNode tail = head;
            while(n > 1)  {
                tail = tail.next;
                n--;
            }

            ListNode newNode = tail.next;
            while(newNode != tail){
                ListNode next = head.next;
                head.next = newNode;
                newNode = head;
                head = next;
            }
            prev.next = newNode;
            return dummyNode.next;
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
    }

    /**
     * create temp node for both next
     */
    public static void interleaving(ListNode first, ListNode second){
        while(first != null && second != null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            if(firstNext == null) return;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    public static ListNode interleavingMerge(ListNode l1, ListNode l2){
        int index = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if ((index & 1) == 0) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
            index++;
        }
        if (l1 != null) prev.next = l1;
        else prev.next = l2;
        return dummyHead.next;
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

    /**
     * 1. find the mid and tail using fast and slow pointer moving
     * 2. reverse the node from mid.next ~ tail
     * 3. do interleaving head and mid.next
     *      remember to set mid.next = null to end the first list before run interleaving
     */
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){ //1->2->3->4  slow is pre of mid
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = Reverser.reverse(slow.next);
        slow.next = null;
        interleaving(head, mid);
    }

    /**
     * Remove duplicated node
     */
    public ListNode deleteDuplicatesOnce(ListNode head) {
        ListNode prev = head;
        while(prev != null && prev.next != null){
            if(prev.next.val != prev.val){
                prev = prev.next;
            } else {  //1->1->2
                prev.next = prev.next.next;    //1->2
            }
        }
        return head;
    }

    /**
     * Delete node appear more than once
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode front = head;
        while(front != null){
            ListNode back = front.next;
            while(back != null && back.val == front.val) back = back.next;
            if(front.next == back){  //front is only appear once
                prev.next = front;
                prev = prev.next;
            }
            front = back;
        }
        prev.next = null;
        return dummyHead.next;
    }
}
