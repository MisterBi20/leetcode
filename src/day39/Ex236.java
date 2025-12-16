package day39;

/*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”*/

public class Ex236 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(5);
        TreeNode root = new TreeNode(6);
        root.left = p;
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = q;
        Ex236 ex236 = new Ex236();
        System.out.println(ex236.lowestCommonAncestor(root, p, q).val);
    }

    //    递归,先判断根节点是否为空,或者是否为p或q,如果是,则返回根节点
//    否则,递归判断左子树和右子树是否包含p或q,如果左子树包含p或q,则右子树一定不包含,
//    反之,右子树包含p或q,则左子树一定不包含,如果左子树和右子树都不包含p或q,则返回空
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        else if (left != null && right == null) return left;
        else if (left == null && right != null) return right;
        else return root;
    }
}
