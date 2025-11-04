package day29;

/*给定一个二叉树：

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。

        初始状态下，所有 next 指针都被设置为 NULL 。*/

public class Ex117 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Ex117 ex117 = new Ex117();
        ex117.connect(root);
    }
    /*递归，从左到右，每次连接当前层的节点，然后移动到下一层，
    直到当前层没有节点为止。*/
    public Node connect(Node root) {
        if (root==null) return null;
        Node parent = root;
        Node childHead = new Node();
        while (parent != null){
            childHead.next = null;
            Node child = childHead;
            while (parent != null){
                if (parent.left !=null){
                    child.next = parent.left;
                    child = child.next;
                }
                if (parent.right !=null){
                    child.next = parent.right;
                    child = child.next;
                }
                parent = parent.next;
            }
            parent = childHead.next;
        }
        return root;
    }
}
