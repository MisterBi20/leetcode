package day38;

/*给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]*/

public class Ex235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        Ex235 ex235 = new Ex235();
        System.out.println(ex235.lowestCommonAncestor(root, p, q).val);
    }

    //    递归遍历，根据二叉搜索树的性质，若根节点的值大于p和q的值，则最近公共祖先在左子树，
    //    若根节点的值小于p和q的值，则最近公共祖先在右子树，
    //    否则，最近公共祖先就是根节点。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
