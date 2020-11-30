package com.buildupchao.algorithm.leetcode.deleterepeatdatalist;

import com.buildupchao.algorithm.leetcode.bean.ListNode;

/**
 * @author buildupchao
 * @date 2020/11/30 19:38
 * @since JDK 1.8
 */
public class DeleteDuplicateDataInSortList {

    public static void main(String[] args) {
        DeleteDuplicateDataInSortList listUtil = new DeleteDuplicateDataInSortList();

//        int[] numberList = {1, 2, 3, 3, 4, 4, 5};
//        int[] numberList = {1, 1, 1, 2, 3};
//        int[] numberList = {1, 1, 1, 3};
        int[] numberList = {};
        ListNode head = listUtil.constructNodeList(numberList);
        ListNode root = listUtil.deleteDuplicates(head);

        listUtil.printList(root);
    }

    private void printList(ListNode root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            printList(root.next);
        } else {
            return;
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode next = pre == null ? null : head.next;

        ListNode root = null;
        ListNode pointer = null;
        int tempVal = Integer.MAX_VALUE;
        while (pre != null && next != null) {
            if (pre.val != next.val) {
                if (tempVal != pre.val) {
                    if (root == null) {
                        root = pointer = new ListNode(pre.val);
                    } else {
                        pointer.next = new ListNode(pre.val);
                        pointer = pointer.next;
                    }
                }
                pre = next;
                next = pre.next;
            } else {
                tempVal = pre.val;
                // 进两步
                pre = next.next;
                next = pre == null ? null : pre.next;
            }
        }
        if (pre != null && pre.val != tempVal) {
            if (pointer != null) {
                pointer.next = new ListNode(pre.val);
            } else {
                root = new ListNode(pre.val);
            }
        }
        return root;
    }
}
