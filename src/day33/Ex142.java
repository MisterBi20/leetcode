package day33;

/*给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
        如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
        为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
        如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
        不允许修改 链表。*/

public class Ex142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        Ex142 ex142 = new Ex142();
        System.out.println(ex142.detectCycle(head));
    }

    //    快慢指针
    //    1.判断是否有环
    //    2.如果有环，找到环的入口，先让fast和slow相遇，然后让fast指向head，slow和fast每次都走一步，相遇的点就是环的入口
    //    3.如果没有环，返回null
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
