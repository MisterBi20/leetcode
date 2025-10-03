package day10;

/*给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
        k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。*/


import java.util.Scanner;

public class Ex25 {
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
        Ex25 ex25 = new Ex25();
        int k = scanner.nextInt();
        head = ex25.reverseKGroup(head, k);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //    递归每k个分为一组
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            if (p == null) return head;
            p = p.next;
        }
        ListNode pre = p, cur = head;
        while (cur != p) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(p, k);
        return pre;
    }
}
