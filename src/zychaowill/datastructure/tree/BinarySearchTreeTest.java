package zychaowill.datastructure.tree;

import org.junit.Test;

import zychaowill.datastructure.tree.BinarySearchTree.Node;

public class BinarySearchTreeTest {

	@Test
	public void binarySearchTreeTest() {
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node4 = new Node<Integer>(4, node3, null);
		Node<Integer> node2 = new Node<Integer>(2, node1, node4);
		Node<Integer> node8 = new Node<Integer>(8);
		Node<Integer> root = new Node<Integer>(6, node2, node8);

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
	}

}
