package com.interview.books.ninechapter;

/**
 * Created_By: stefanie
 * Date: 14-12-12
 * Time: 下午2:14
 */
//public class NC9_SubarrayGCD {
//    class IntervalTreeNode{
//        int s;
//        int t;
//        int value;
//        IntervalTreeNode left;
//        IntervalTreeNode right;
//
//        IntervalTreeNode(int s, int t, int value) {
//            this.s = s;
//            this.t = t;
//            this.value = value;
//        }
//    }
//
//    IntervalTreeNode root;
//
//    public NC9_SubarrayGCD(int[] array){
//        root = createTree(array, 0, array.length - 1);
//    }
//
//    private IntervalTreeNode createTree(int[] array, int low, int high){
//        if(low > high) return null;
//        if(low == high) return new IntervalTreeNode(low, high, array[low]);
//        int mid = low + (high - low)/2;
//        IntervalTreeNode node = new IntervalTreeNode(low, high, 0);
//        node.left = createTree(array, low, mid);
//        node.right = createTree(array, mid + 1, high);
//        node.value = gcd(node.left.value, node.right.value);
//        return node;
//    }
//
//    public int getGCD(int from, int to){
//        return searchIterval(root, from, to);
//    }
//
//    private int searchIterval(IntervalTreeNode node, int from, int to){
//        if(node.t < to || node.s > from) return -1;
//        if(from == node.s && to == node.t) return node.value;
//        else {
//            if(to <= node.left.t){ //only in left
//                return searchIterval(node.left, from, to);
//            } else if(from >= node.right.s) { //only in right
//                return searchIterval(node.right, from, to);
//            } else {
//                int left = searchIterval(node.left, from, node.left.t);
//                int right = searchIterval(node.right, node.right.s, to);
//                return gcd(left, right);
//            }
//        }
//    }
//
//    private int gcd(int i, int j){
//        if(j > i) return gcd(j, i);
//        while(i % j != 0){
//            int mod = i % j;
//            i = j;
//            j = mod;
//        }
//        return j;
//    }
//
//
//
//}



public class NC9_SubarrayGCD {

    class IntervalNode {
        int from, to;
        IntervalNode left, right;
        int gcd;

        IntervalNode(int start, int end) {
            this.from = start;
            this.to = end;
        }
    }

    private IntervalNode root;

    public NC9_SubarrayGCD(int[] A) {
        root = preprocess(A, 0, A.length - 1);
    }

    public int gcd(int start, int end) {
        return gcd(root, start, end);
    }

    private int gcd(IntervalNode root, int start, int end) {
        if (root.from == start && root.to == end) return root.gcd;

        if (end <= root.left.to) return gcd(root.left, start, end);
        else if (start >= root.right.from) return gcd(root.right, start, end);
        else {
            int gcdLeft = gcd(root.left, start, root.left.to);
            int gcdRight = gcd(root.right, root.right.from, end);
            return this.getGCD(gcdLeft, gcdRight);
        }
    }

    private IntervalNode preprocess(int[] A, int from, int to) {
        if (from == to) {
            IntervalNode node = new IntervalNode(from, to);
            node.gcd = A[from];
            return node;
        } else {
            IntervalNode root = new IntervalNode(from, to);
            int mid = from + (to - from) / 2;
            root.left = preprocess(A, from, mid);
            root.right = preprocess(A, mid + 1, to);
            root.gcd = this.getGCD(root.left.gcd, root.right.gcd);
            return root;
        }
    }

    private int getGCD(int i, int j) {
        if (j > i) return getGCD(j, i);
        while (i % j != 0) {
            int mod = i % j;
            i = j;
            j = mod;
        }
        return j;
    }

    public static void main(String[] args){
        int[] array = new int[]{2,6,12,24,18,78};
        NC9_SubarrayGCD gcder = new NC9_SubarrayGCD(array);
        System.out.println(gcder.gcd(0, 5));
        System.out.println(gcder.gcd(2, 3));
        System.out.println(gcder.gcd(1, 4));
    }
}
