package day35;

//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。


public class Ex203 {
    public static void main(String[] args) {
        Ex203 ex203 = new Ex203();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode res = ex203.removeElements(head, 6);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    //    双指针，一个指向新链表的最后一个节点，一个指向当前节点。
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead;
        ListNode pre = newHead.next;
        while (pre != null) {
            if (pre.val == val) {
                cur.next = pre.next;
                pre = cur.next;
            } else {
                cur = pre;
                pre = pre.next;
            }
        }
        return newHead.next;
    }

}
