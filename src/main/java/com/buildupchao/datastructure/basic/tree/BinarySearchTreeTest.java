package com.buildupchao.datastructure.basic.tree;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void binarySearchTreeTest() {
		BinarySearchTree.Node<Integer> node3 = new BinarySearchTree.Node<Integer>(3);
		BinarySearchTree.Node<Integer> node1 = new BinarySearchTree.Node<Integer>(1);
		BinarySearchTree.Node<Integer> node4 = new BinarySearchTree.Node<Integer>(4, node3, null);
		BinarySearchTree.Node<Integer> node2 = new BinarySearchTree.Node<Integer>(2, node1, node4);
		BinarySearchTree.Node<Integer> node8 = new BinarySearchTree.Node<Integer>(8);
		BinarySearchTree.Node<Integer> root = new BinarySearchTree.Node<Integer>(6, node2, node8);

		BinarySearchTree<Integer> searchTree = new BinarySearchTree<Integer>();
		searchTree.setRoot(root);

		searchTree.preOrder(searchTree.getRoot());
		System.out.println();

		searchTree.remove(4);
		searchTree.preOrder(searchTree.getRoot());
		System.out.println();
		
		int max = searchTree.findMax();
		System.out.println("max: " + max);
		searchTree.preOrder(searchTree.getRoot());
		System.out.println();
		
		// 中序遍历
		searchTree.suffixOrder(searchTree.getRoot());
	}

}
