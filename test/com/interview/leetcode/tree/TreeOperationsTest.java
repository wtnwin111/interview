package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-11-17
 * Time: 下午3:04
 */
public class TreeOperationsTest extends TestCase {
    public void testUpsideDownBinaryTree() throws Exception {
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        t1.left = t2;
        t1.right = new TreeNode(3);

        TreeNode root = TreeOperations.upsideDown(t1);
        assertEquals(4, root.val);
        assertEquals(5, root.left.val);
        assertEquals(2, root.right.val);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(1, root.right.right.val);
        assertEquals(3, root.right.left.val);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }
}
