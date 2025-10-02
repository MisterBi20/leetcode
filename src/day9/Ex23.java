package day9;

//给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。

import java.util.Scanner;

public class Ex23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ListNode[] lists = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            ListNode head = null;
            ListNode rear = null;
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    head = new ListNode(scanner.nextInt());
                    rear = head;
                } else {
                    ListNode Node = new ListNode(scanner.nextInt());
                    rear.next = Node;
                    rear = Node;
                }
            }
            lists[i] = head;
        }
        Ex23 ex23 = new Ex23();
        ListNode merged = ex23.mergeLists(lists);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }

    //    内部采用分治法（类似归并排序）：不断把链表数组一分为二；递归合并两个有序链表
    public ListNode mergeLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
