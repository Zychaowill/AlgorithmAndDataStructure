package zychaowill.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinNode {
	private BinNode lchild, rchild;
	private int value;

	public BinNode() {}

	public BinNode(BinNode lchild, BinNode rchild, int value) {
//		super();
		this.lchild = lchild;
		this.rchild = rchild;
		this.value = value;
	}

	public void addChild(int value) {
		if (value < this.value) {
			if (lchild != null) {
				lchild.addChild(value);
			} else {
				lchild = new BinNode(null, null, value);
			}
		} else {
			if (rchild != null) {
				rchild.addChild(value);
			} else {
				rchild = new BinNode(null, null, value);
			}
		}
	}
	
	public static void printTree(BinNode root) {
		if (root != null) {
			printTree(root.lchild);
			System.out.print(root.value);
			printTree(root.rchild);
		}
	}
	
	public static void preOrder(BinNode root) {
		if (root != null) {
			System.out.print(root.value);
			preOrder(root.lchild);
			preOrder(root.rchild);
		}
	}
	
	public static void preOrderStack(BinNode root) {
		if (root != null) {
			Stack<BinNode> stack = new Stack<>();
			stack.push(root);
			
			BinNode node;
			while (!stack.isEmpty()) {
				node = stack.pop();
				System.out.print(node.value);
				
				if (node.rchild != null) {
					stack.push(node.rchild);
				}
				if (node.lchild != null) {
					stack.push(node.lchild);
				}
			}
		}
	}
	
	public static void readLevel(BinNode root) {
		if (root != null) {
			Queue<BinNode> queue = new LinkedList<>();
			queue.add(root);
			
			BinNode node;
			while (!queue.isEmpty()) {
				node = queue.poll();
				System.out.print(node.value);
				
				if (node.lchild != null) {
					queue.add(node.lchild);
				}
				if (node.rchild != null) {
					queue.add(node.rchild);
				}
			}
		}
	}
	
	/**
	 * Start iterator level reading.
	 * @param root
	 * @param level
	 */
	private static void levelIterator(BinNode root, int level) {
		if (root == null || level < 1) {
			return;
		}
		
		if (root != null) {
			if (level == 1) {
				System.out.print(root.value);
			}
			
			levelIterator(root.lchild, level - 1);
			levelIterator(root.rchild, level - 1);
		}
	}
	
	public static int depth(BinNode root) {
		if (root != null) {
			int ldepth = depth(root.lchild);
			int rdepth = depth(root.rchild);
			
			return (ldepth > rdepth ? ldepth + 1 : rdepth + 1);
		}
		return 0;
	}
	
	public static void iteratorLevel(BinNode root) {
		int depth = depth(root);
		
		for (int i = 1; i <= depth; i++) {
			levelIterator(root, i);
		}
	}
	/**
	 * End iterator level reading.
	 */
	
	public static void main(String[] args) {
		int[] values = {4, 1, 3, 2, 5, 6, 7};
		BinNode root = new BinNode(null, null, values[0]);
		
		for (int i = 1; i < values.length; i++) {
			root.addChild(values[i]);
		}
		
		printTree(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		preOrderStack(root);
		System.out.println();
		
		readLevel(root);
		System.out.println();
		iteratorLevel(root);
		System.out.println();
	}
}
