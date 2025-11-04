package day29;

/*给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

        初始状态下，所有 next 指针都被设置为 NULL。*/

public class EX116 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        EX116 ex116 = new EX116();
        ex116.connect(root);
    }

    public Node connect(Node root) {
        traversal(root);
        return root;
    }
    public void traversal(Node cur){
        if (cur == null) return;
        if (cur.left != null) cur.left.next=cur.right;
        if (cur.right!=null){
            if (cur.next!=null) cur.right.next=cur.next.left;
            else cur.right.next=null;
        }
        traversal(cur.left);
        traversal(cur.right);
    }
}
