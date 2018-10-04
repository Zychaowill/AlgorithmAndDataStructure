package zychaowill.datastructure.basic.list;

import java.util.Objects;

import zychaowill.datastructure.basic.list.node.Node;

/**
 * Check if list is palindrome
 * @author Jang Zhang
 *
 */
public class PalindromeListChecker {
	
	public <T> boolean isPalindrome(Node<T> root) {
		if (root == null || root.next == null) {
			return true;
		}
		Node<T> middleNode = shootingMiddleNode(root);
		middleNode.next = reverseList(middleNode.next);
		
		Node<T> first = root;
		Node<T> second = middleNode.next;
		while (first != null && second != null && Objects.equals(first.data, second.data)) {
			first = first.next;
			second = second.next;
		}
		return second == null;
	}
	
	private <T> Node<T> reverseList(Node<T> root) {
		Node<T> pre = null;
		Node<T> next = null;
		while (root != null) {
			next = root.next;
			root.next = pre;
			pre = root;
			root = next;
		}
		return pre;
	}
	
	private <T> Node<T> shootingMiddleNode(Node<T> node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node<T> slow = node;
		Node<T> fast = node;
		while (slow != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}