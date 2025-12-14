package day36;

import java.util.HashSet;

public class Ex206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Ex206 ex206 = new Ex206();
        head = ex206.reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //    引入假头结点，原地逆置
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode curHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            head = head.next;
            cur.next = curHead.next;
            curHead.next = cur;
            cur = head;
        }
        return curHead.next;
    }
}
