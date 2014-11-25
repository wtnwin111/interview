package com.interview.leetcode.tree;

import com.interview.leetcode.utils.TreeNode;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-11-25
 * Time: 上午10:58
 */
public class UniqueBinaryTreeTest extends TestCase {
    public void testGenerateTrees() throws Exception {
        UniqueBinaryTree tree = new UniqueBinaryTree();
        List<TreeNode> trees = tree.generateTrees(5);
        System.out.println(trees.size());
    }
}
