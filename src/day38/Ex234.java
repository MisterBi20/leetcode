package day38;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。

public class Ex234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        Ex234 ex234 = new Ex234();
        System.out.println(ex234.isPalindrome(head));
    }

    //    快慢指针，快指针到尾时，慢指针到中间，将慢指针后面的链表反转，比较两个链表是否相等
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode cur1 = head;
        ListNode cur2 = reverse(slow);
        while (cur1 != null) {
            if (cur1.val != cur2.val) return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode tmp = null;
        ListNode pre = null;
        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
