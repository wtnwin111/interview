package com.interview.flag.g;

import com.interview.utils.ConsoleWriter;

/**
 * Created_By: stefanie
 * Date: 14-12-29
 * Time: 下午4:46
 */
public class G1_RecoverFromCountingArray {
    static class BSTNode{
        int value;
        int size;
        BSTNode left, right;

        public BSTNode(int value){
            this.value = value;
            this.size = 1;
        }

        public static BSTNode create(int N){
            return create(1, N);
        }

        private static BSTNode create(int low, int high){
            if(low > high) return null;
            int mid = low + (high - low)/2;
            BSTNode node = new BSTNode(mid);
            node.size = high - low + 1;
            node.left = create(low, mid - 1);
            node.right = create(mid + 1, high);
            return node;
        }

        public static BSTNode topK(BSTNode node, int K){
            if(node == null) return null;
            int leftSize = node.left == null? 0 : node.left.size;
            if(K == leftSize + 1) return node;
            else if(K <= leftSize) return topK(node.left, K);
            else return topK(node.right, K - leftSize - 1);
        }

        public static BSTNode delete(BSTNode node, BSTNode target){
            if(node == null) return null;
            if(target.value < node.value) node.left = delete(node.left, target);
            else if(target.value > node.value) node.right = delete(node.right, target);
            else {
                if(node.left == null) return node.right;
                if(node.right == null) return node.left;
                BSTNode successor = node.right;
                BSTNode parent = node;
                while(successor.left != null){
                    parent = successor;
                    successor = successor.left;
                }
                node.value = successor.value;
                if(parent.left == successor) parent.left = successor.right;
                else parent.right = successor.right;
            }
            node.size--;
            return node;
        }
    }


    public int[] recover(int[] B){
        BSTNode root = BSTNode.create(B.length);
        int[] A = new int[B.length];
        for(int i = 0; i < B.length; i++){
            BSTNode node = BSTNode.topK(root, B[i] + 1);
            A[i] = node.value;
            root = BSTNode.delete(root, node);
        }
        return A;
    }

    public static void main(String[] args){

        G1_RecoverFromCountingArray recover = new G1_RecoverFromCountingArray();
        int[] B = new int[]{4, 0, 1, 1, 0};
        //5, 1, 3, 4, 2
        ConsoleWriter.printIntArray(recover.recover(B));
        B = new int[]{0,1,0,0,0};
        //1, 3, 2, 4, 5
        ConsoleWriter.printIntArray(recover.recover(B));
        B = new int[]{5,0,1,1,0,0};
        //6, 1, 3, 4, 2, 5
        ConsoleWriter.printIntArray(recover.recover(B));
    }
}
