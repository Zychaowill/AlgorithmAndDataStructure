package com.buildupchao.datastructure.basic.list;

import java.util.Objects;

import com.buildupchao.datastructure.basic.list.node.Node;

/**
 * SingleLinkedList
 * @author Jang Zhang
 *
 * @param <T>
 */
public class SingleLinkedList<T> {
	
	private Node<T> head;

	public void add(T data) {
		if (head == null) {
			head = new Node<>(data, null);
		} else {
			Node<T> newNode = new Node<>(data, null);
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void remove(T data) {
		if (head == null) {
			return;
		} else {
			Node<T> pre = head;
			while (pre != null) {
				if (Objects.equals(pre.next.data, data)) {
					pre.next = pre.next.next;
					break;
				}
				pre = pre.next;
			}
		}
	}
	
	public void println() {
		StringBuffer resultInfo = new StringBuffer("");
		Node<T> pre = head;
		while (pre != null) {
			resultInfo.append(pre.data).append(" ");
			pre = pre.next;
		}
		System.out.println("【" + this.getClass().getSimpleName() + "】:" + resultInfo.toString());
	}
}
