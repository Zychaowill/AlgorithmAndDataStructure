package zychaowill.datastructure.list;

import zychaowill.datastructure.list.node.DoubleNode;
import zychaowill.datastructure.list.node.Node;

public class RevertList {

	public Node revertList(Node head) {
		Node pre = null;
		Node next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}

		return pre;
	}

	public DoubleNode revertList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;

		while (head != null) {
			next = head.next;
			head.next = pre;
			head.pre = next;
			pre = head;
			head = next;

		}
		return pre;
	}

	public void printNode(Node head) {
		while (head != null) {
			System.out.print(head.value + "\t");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;

		RevertList rl = new RevertList();
		Node result = rl.revertList(n1);
		rl.printNode(result);
	}

}
