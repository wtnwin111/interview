package com.interview.algorithms.tree;

import com.interview.basics.model.tree.BinaryTreeNode;

/**
 * Created_By: stefanie
 * Date: 14-9-26
 * Time: 上午11:41
 */
public class C5_8A_RebuildTree<T> {
    public static int PRE_IN = 1;
    public static int POST_IN = 2;

    public int offset = 0;

    public BinaryTreeNode<T> buildTree(T[] preOrder, T[] inOrder, int type){
        if(type == PRE_IN) {
            this.offset = 0;
            return innerBuildTreePRE(preOrder, inOrder);
        } else {
            this.offset = preOrder.length - 1;
            return innerBuildTreePOST(preOrder, inOrder);
        }
    }

    private BinaryTreeNode<T> innerBuildTreePRE(T[] preOrder, T[] inOrder){
        T root = preOrder[offset];
        int index = findFirstIndexOf(inOrder, root, 0, true);

        BinaryTreeNode<T> node = new BinaryTreeNode<>(root);
        if(index > 0) {
            offset++;
            node.setLeftChild(innerBuildTreePRE(preOrder, copy(inOrder, 0, index)));
        }
        if(index < inOrder.length - 1) {
            offset++;
            node.setRightChild(innerBuildTreePRE(preOrder, copy(inOrder, index + 1)));
        }
        return node;
    }

    private BinaryTreeNode<T> innerBuildTreePOST(T[] preOrder, T[] inOrder){
        T root = preOrder[offset];
        int index = findFirstIndexOf(inOrder, root, inOrder.length - 1, false);

        BinaryTreeNode<T> node = new BinaryTreeNode<>(root);
        if(index < inOrder.length - 1) {
            offset--;
            node.setRightChild(innerBuildTreePOST(preOrder, copy(inOrder, index + 1)));
        }
        if(index > 0) {
            offset--;
            node.setLeftChild(innerBuildTreePOST(preOrder, copy(inOrder, 0, index)));
        }
        return node;
    }

    private int findFirstIndexOf(T[] array, T element, int start, boolean forward){
        while(!element.equals(array[start])){
            if(forward) {
                start++;
                if(start >= array.length) return -1;
            }
            else {
                start--;
                if(start < 0) return -1;
            }
        }
        return start;
    }

    private T[] copy(T[] source, int... offset){
        int start = offset[0];
        int end = offset.length > 1? offset[1] : source.length;
        T[] copy = (T[]) new Object[end - start];
        int i = 0;
        while(start != end){
            copy[i++] = source[start++];
        }
        return copy;
    }

}
