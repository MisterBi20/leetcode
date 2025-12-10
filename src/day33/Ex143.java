package day33;

/*给定一个单链表 L 的头节点 head ，单链表 L 表示为：
L0 → L1 → … → Ln - 1 → Ln
请将其重新排列后变为：
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/

public class Ex143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Ex143 ex143 = new Ex143();
        ex143.reorderList(head);
        ListNode data = head;
        while (data != null) {
            System.out.println(data.val);
            data = data.next;
        }
    }

    //    双指针找中点，逆置，各项插入
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        right = reverseList(right);
        ListNode left = head;
        while (right != null) {
            ListNode curLeft = left.next;
            left.next = right;
            left = curLeft;
            ListNode curRight = right.next;
            right.next = left;
            right = curRight;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode headNode = new ListNode(0);
        ListNode cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = headNode.next;
            headNode.next = cur;
            cur = next;
        }
        return headNode.next;
    }
}
