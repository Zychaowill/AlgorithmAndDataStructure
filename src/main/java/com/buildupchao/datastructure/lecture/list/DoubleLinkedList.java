package com.buildupchao.datastructure.lecture.list;

/**
 * Created by yachao on 17/11/19.
 */
public class DoubleLinkedList {

    private IntNode sentinal;
    private int size;

    private IntNode getBackNode() {
        IntNode p = sentinal;

        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    private IntNode getFront() {
        IntNode p = sentinal;

        return p;
    }

    public void insertFront() {

    }

    /**
     * Fast insertBack
     * @param x
     */
    public void insertBack(int x) {
        IntNode back = getBackNode();
        back.next = new IntNode(x, null);
        size += 1;
    }

    public int size() {
        return size;
    }

    class IntNode {
        int x;
        IntNode next;

        public IntNode(int x, IntNode next) {
            this.x = x;
            this.next = next;
        }
    }
}
