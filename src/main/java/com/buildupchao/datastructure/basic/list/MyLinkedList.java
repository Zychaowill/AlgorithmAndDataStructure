package com.buildupchao.datastructure.basic.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author buildupchao
 * @date 2019/10/13 00:38
 * @since JDK 1.8
 */
public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Node {
        private int data;
        private Node next;
    }

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围");
        }

        Node insertedNode = new Node(data, null);
        if (size == 0) {
            head = insertedNode;
            tail = insertedNode;
        } else if (index == 0) {
            insertedNode.next = head;
            head = insertedNode;
        } else if (size == index) {
            tail.next = insertedNode;
            tail = insertedNode;
        } else {
            // 中间插入
            Node preNode = getNode(index - 1);
            insertedNode.next = preNode.next;
            preNode.next = insertedNode;
        }
        size++;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围");
        }

        Node removedNode = null;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            Node preNode = getNode(index - 1);
            removedNode = preNode.next;
            preNode.next = null;
            tail = preNode;
        } else {
            Node preNode = getNode(index - 1);
            removedNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return removedNode;
    }

    public Node getNode(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围");
        }

        Node tempNode = head;
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    public void output() {
        Node tempNode = head;

        System.out.print("[");
        while (tempNode != null) {
            System.out.printf("%d,", tempNode.data);
            tempNode = tempNode.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList list = new MyLinkedList();
        list.insert(3, 0);
        list.insert(7, 1);
        list.insert(9, 2);
        list.insert(5, 3);
        list.insert(6, 1);
        list.output();

        list.remove(0);
        list.output();
    }
}
