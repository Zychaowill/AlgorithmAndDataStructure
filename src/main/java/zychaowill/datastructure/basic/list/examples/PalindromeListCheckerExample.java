package zychaowill.datastructure.basic.list.examples;

import zychaowill.datastructure.basic.list.PalindromeListChecker;
import zychaowill.datastructure.basic.list.node.Node;

public class PalindromeListCheckerExample {

	public static void main(String[] args) {
		Node<String> n1 = new Node<>("a");
		Node<String> n2 = new Node<>("b");
		Node<String> n3 = new Node<>("c");
		Node<String> n4 = new Node<>("b");
		Node<String> n5 = new Node<>("a");
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		System.out.println("Is palindrome? :" + new PalindromeListChecker().isPalindrome(n1));
	}
}
