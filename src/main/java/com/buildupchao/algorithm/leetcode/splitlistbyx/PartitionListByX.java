package com.buildupchao.algorithm.leetcode.splitlistbyx;

import com.buildupchao.algorithm.leetcode.bean.ListNode;
/**
 * @author buildupchao
 * @date 2020/11/30 20:34
 * @since JDK 1.8
 */
public class PartitionListByX {

    public static void main(String[] args) {
        PartitionListByX listUtil = new PartitionListByX();

        int[] numberList = {1, 4, 3, 2, 5, 2};
//        int[] numberList = {};
        ListNode head = listUtil.constructNodeList(numberList);
        ListNode root = listUtil.partition(head, 3);

        listUtil.printList(root);
    }

    private void printList(ListNode root) {
        if (root == null) {
            return;
        }
        if (root.next != null) {
            System.out.print(root.val + "->");
            printList(root.next);
        } else {
            System.out.print(root.val);
        }
    }

    private ListNode constructNodeList(int[] numberList) {
        if (numberList.length == 0) {
            return null;
        }
        ListNode head = new ListNode(numberList[0]);
        ListNode pointer = head;
        for (int i = 1; i < numberList.length; i++) {
            pointer.next = new ListNode(numberList[i]);
            pointer = pointer.next;
        }
        return head;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode lessRoot = null;
        ListNode greatRoot = null;
        ListNode leastPointer = null;
        ListNode greaterPointer = null;

        while (head != null) {
            if (head.val < x) {
                if (leastPointer == null) {
                    lessRoot = leastPointer = new ListNode(head.val);
                } else {
                    leastPointer.next = new ListNode(head.val);
                    leastPointer = leastPointer.next;
                }
            } else {
                if (greaterPointer == null) {
                    greatRoot = greaterPointer = new ListNode(head.val);
                } else {
                    greaterPointer.next = new ListNode(head.val);
                    greaterPointer = greaterPointer.next;
                }
            }
            head = head.next;
        }
        if (lessRoot != null) {
            leastPointer.next = greatRoot;
        } else {
            lessRoot = greatRoot;
        }
        return lessRoot;
    }
}
