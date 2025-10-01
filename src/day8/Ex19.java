package day8;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

import java.util.Scanner;

public class Ex19 {
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
        Ex19 ex19 = new Ex19();
        int n = scanner.nextInt();
        head = ex19.removeNthFromEnd(head, n);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //双链表先走n步，再一起走
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode l = dummy;
        ListNode r = dummy;
        for (int i = 0; i < n; i++) {
            r = r.next;
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }
}
