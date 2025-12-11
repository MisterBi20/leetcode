package day34;

/*给你两个单链表的头节点 headA 和 headB ，
请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
图示两个链表在节点 c1 开始相交：*/

public class Ex160 {
    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(2);
        ListNode A = new ListNode(2);
        ListNode C = new ListNode(3);
        headA.next = A;
        A.next = C;
        headB.next = C;
        Ex160 ex160 = new Ex160();
        System.out.println(ex160.getIntersectionNode(headA, headB));
    }

    //走两圈如果相遇一定有相交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p != null)
                p = p.next;
            else p = headB;
            if (q != null)
                q = q.next;
            else q = headA;
        }
        return p;
    }

}

