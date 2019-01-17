package com.buildupchao.datastructure.basic.tree.rb;

public class RBTreeNode {
	RBTreeNode parent = nullNode;
	RBTreeNode left = nullNode;
	RBTreeNode right = nullNode;
	int value;
	RBColor color;

	public RBTreeNode() {}
	public RBTreeNode(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + value + " " + color + ")";
	}
	
	public static RBTreeNode nullNode = new RBTreeNode() {
		{
			color = RBColor.BLACK;
		}
		@Override
		public String toString() {
			return "(null " + color + ")";
		}
	};
	
	public static RBTreeNode leftRotate(RBTreeNode root, RBTreeNode node) {
		if (node.right == RBTreeNode.nullNode)
			return root;

		RBTreeNode right = node.right;
		node.right = right.left;
		if (node.right != RBTreeNode.nullNode)
			node.right.parent = node;
		if (node.parent != RBTreeNode.nullNode) {
			right.parent = node.parent;
			if (node.parent.left == node)
				node.parent.left = right;
			else
				node.parent.right = right;
		} else {
			root = right;
			root.parent = RBTreeNode.nullNode;
		}
		right.left = node;
		node.parent = right;
		return root;
	}

	public static RBTreeNode rightRotate(RBTreeNode root, RBTreeNode node) {
		if (node.left == RBTreeNode.nullNode)
			return root;

		RBTreeNode left = node.left;
		node.left = left.right;
		if (node.left != RBTreeNode.nullNode)
			node.left.parent = node;
		if (node.parent != RBTreeNode.nullNode) {
			left.parent = node.parent;
			if (node.parent.left == node)
				node.parent.left = left;
			else
				node.parent.right = left;
		} else {
			root = left;
			root.parent = RBTreeNode.nullNode;
		}
		left.right = node;
		node.parent = left;
		return root;
	}

	public static RBTreeNode rbInsert(RBTreeNode root, RBTreeNode insertNode) {
		RBTreeNode position = root;
		RBTreeNode parent = RBTreeNode.nullNode;

		while (position != RBTreeNode.nullNode) {
			parent = position;
			if (insertNode.value < position.value)
				position = position.left;
			else if (insertNode.value > position.value)
				position = position.right;
		}

		insertNode.parent = parent;
		if (parent == RBTreeNode.nullNode)
			root = insertNode;
		else if (insertNode.value < parent.value)
			parent.left = insertNode;
		else if (insertNode.value > parent.value)
			parent.right = insertNode;
		insertNode.color = RBColor.RED;
		return rbInsertFixUp(root, insertNode);
	}

	private static RBTreeNode rbInsertFixUp(RBTreeNode root, RBTreeNode node) {
		RBTreeNode parent = node.parent;
		RBTreeNode grandParent;
		RBTreeNode parentBrother;

		while (parent != RBTreeNode.nullNode && parent.color == RBColor.RED) {
			grandParent = parent.parent;
			if (grandParent.left == parent) {
				parentBrother = grandParent.right;
				if (parentBrother != RBTreeNode.nullNode && parentBrother.color == RBColor.RED) {
					grandParent.color = RBColor.RED;
					parent.color = RBColor.BLACK;
					parentBrother.color = RBColor.BLACK;
					node = grandParent;
				} else {
					if (parent.right == node) {
						root = leftRotate(root, parent);
						RBTreeNode temp = node;
						node = parent;
						parent = temp;
					}
					grandParent.color = RBColor.RED;
					parent.color = RBColor.BLACK;
					root = rightRotate(root, grandParent);
					node = root;
				}
			} else {
				parentBrother = grandParent.left;
				if (parentBrother != RBTreeNode.nullNode && parentBrother.color == RBColor.RED) {
					grandParent.color = RBColor.RED;
					parent.color = RBColor.BLACK;
					parentBrother.color = RBColor.BLACK;
					node = grandParent;
				} else {
					if (parent.left == node) {
						root = rightRotate(root, parent);
						RBTreeNode temp = node;
						node = parent;
						parent = temp;
					}
					grandParent.color = RBColor.RED;
					parent.color = RBColor.BLACK;
					root = leftRotate(root, grandParent);
					node = root;
				}
			}
			parent = node.parent;
		}
		root.color = RBColor.BLACK;
		return root;
	}

	public static RBTreeNode rbDelete(RBTreeNode root, RBTreeNode deleteNode) {

		return null;
	}
}
