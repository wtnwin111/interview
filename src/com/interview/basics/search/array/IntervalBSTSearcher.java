package com.interview.basics.search.array;

import com.interview.utils.models.Range;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/24/14
 * Time: 4:19 PM
 *
 * Give a set of intervals, and find a interval intersects in the given search interval.
 *
 * Solution:
 *      Build a interval search tree based on BST, using min as the key, and keep the max endpoint in subtree rooted at the end
 *      For Insert:
 *          1. insert interval in BST
 *          2. update the max in each node on search path
 *
 *      For Search:
 *          a. if the interval in node intersects query interval, return interval
 *          b. else if left subtree is null or the max endpoint in left subtree is less than lo, go right.
 *          c. else go left
 */
public class IntervalBSTSearcher {

    private RangeBSTNode root;

    class RangeBSTNode {
        public int index;
        public Range value;
        public RangeBSTNode left;
        public RangeBSTNode right;
        public int max;

        public RangeBSTNode(int index, Range value){
            this.index = index;
            this.value = value;
            this.max = value.end;
        }
    }

    public IntervalBSTSearcher(Range[] input) {
        for(int i = 0; i < input.length; i++){
            root = addNode(root, input, i);
        }
    }

    protected RangeBSTNode addNode(RangeBSTNode node, Range[] input, int index){
        if(node == null){
            return new RangeBSTNode(index, input[index]);
        } else {
            if(node.value.start < input[index].start){
                node.right = addNode(node.right, input, index);
            } else {
                node.left = addNode(node.left, input, index);
            }
            if(node.right != null && node.left != null)
                node.max = node.right.max > node.left.max? node.right.max : node.right.max;
            else if(node.right != null) node.max = node.right.max;
            else if(node.left != null)  node.max = node.left.max;
            return node;
        }
    }

    public int search(Range item) {
        RangeBSTNode node = root;
        while(node != null){
            if(Range.cover(item, node.value)) return node.index;
            else if(node.left != null && node.left.max >= item.end) node = node.left;
            else node = node.right;
        }
        return -1;
    }
}
