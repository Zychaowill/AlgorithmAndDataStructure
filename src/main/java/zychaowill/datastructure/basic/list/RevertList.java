package zychaowill.datastructure.basic.list;

import zychaowill.datastructure.basic.list.node.DoubleNode;
import zychaowill.datastructure.basic.list.node.Node;

public class RevertList {

	public <T> Node<T> revertList(Node<T> head) {
		Node<T> pre = null;
		Node<T> next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}

		return pre;
	}

	public <T> DoubleNode<T> revertList(DoubleNode<T> head) {
		DoubleNode<T> pre = null;
		DoubleNode<T> next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;

		}
		return pre;
	}

	public <T> void printNode(Node<T> head) {
		while (head != null) {
			System.out.print(head.data + "\t");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node<Integer> n1 = new Node<>(1);
		Node<Integer> n2 = new Node<>(2);
		Node<Integer> n3 = new Node<>(3);
		Node<Integer> n4 = new Node<>(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		RevertList rl = new RevertList();
		Node<Integer> result = rl.revertList(n1);
		rl.printNode(result);
	}

}
