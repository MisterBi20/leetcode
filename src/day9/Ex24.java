package day9;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

import java.util.Scanner;

public class Ex24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ListNode head = null;
        ListNode rear = null;
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                head = new ListNode(scanner.nextInt());
                rear = head;
            } else {
                ListNode Node = new ListNode(scanner.nextInt());
                rear.next = Node;
                rear = Node;
            }
        }
        Ex24 ex24 = new Ex24();
        head = ex24.swapPairs(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    //    递归完成排序
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = swapPairs(tmp.next);
        tmp.next = head;
        return tmp;
    }
}
