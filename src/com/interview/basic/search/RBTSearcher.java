package com.interview.basic.search;


public class RBTSearcher extends BSTSearcher{
	class RBTNode extends BSTNode{
		public static final boolean BLACK = false;
		public static final boolean RED = true;
		public boolean color = BLACK;

		public RBTNode(int index, int value) {
			super(index, value);
			this.color = RED;
		}
		
		public boolean isRed(BSTNode node){
			if(node == null) return false;
			else return ((RBTNode)node).color == RED;
		}
		
		public RBTNode rotateRight(){
			RBTNode tmp = (RBTNode) this.left;
			this.left = tmp.right;
			tmp.right = this;
			tmp.color = this.color;
			this.color = RED;
			return tmp;
		}
		
		public RBTNode rotateLeft(){
			RBTNode tmp = (RBTNode) this.right;
			this.right = tmp.left;
			tmp.left = this;
			tmp.color = this.color;
			this.color = RED;
			return tmp;
		}
		
		public void flipColors(){
			this.color = RED;
			((RBTNode)this.left).color = BLACK;
			((RBTNode)this.right).color = BLACK;
		}
	}

	public RBTSearcher(int[] input) {
		super(input);
	}
	
	@Override
	protected BSTNode addNode(BSTNode node, int index) {
		if(node == null){
			return new RBTNode(index, input[index]);
		} else {
			RBTNode bnode = (RBTNode) node;
			if(node.value < input[index]){
				node.right = addNode(node.right, index);
			} else {
				node.left = addNode(node.left, index);
			}
			if(bnode.isRed(bnode.right) && !bnode.isRed(bnode.left))	node = bnode.rotateLeft();
			if(bnode.isRed(bnode.left) && bnode.isRed(bnode.left.left)) node = bnode.rotateRight();
			if(bnode.isRed(bnode.left) && bnode.isRed(bnode.right))		bnode.flipColors();
			
			return node;
		}
	}
}
