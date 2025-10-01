package day8;

import java.util.Scanner;

public class Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        ListNode head1 = null;
        ListNode rear1 = null;
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                head1 = new ListNode(scanner.nextInt());
                rear1 = head1;
            } else {
                ListNode Node = new ListNode(scanner.nextInt());
                rear1.next = Node;
                rear1 = Node;
            }
        }
        int n = scanner.nextInt();
        ListNode head2 = null;
        ListNode rear2 = null;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                head2 = new ListNode(scanner.nextInt());
                rear2 = head2;
            } else {
                ListNode Node = new ListNode(scanner.nextInt());
                rear2.next = Node;
                rear2 = Node;
            }
        }
        Ex21 ex21 = new Ex21();
        head1 = ex21.mergeTwoLists(head1, head2);
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }

    //    递归排序返回排序片段
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
