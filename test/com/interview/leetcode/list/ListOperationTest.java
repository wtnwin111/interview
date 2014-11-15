package com.interview.leetcode.list;

import com.interview.leetcode.utils.ListNode;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-15
 * Time: 下午7:10
 */
public class ListOperationTest extends TestCase {
    public void testReorderList() throws Exception {
        ListNode head = ListNode.createList(new int[]{1,2,3,4});
        ListOperation.reorderList(head);
        ListNode.print(head);
    }

    public void testReverse() throws Exception {

    }

    public void testInterleaving() throws Exception {

    }
}
