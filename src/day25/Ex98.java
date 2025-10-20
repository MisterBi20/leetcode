package day25;

/*给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
        有效 二叉搜索树定义如下：
        节点的左子树只包含 严格小于 当前节点的数。
        节点的右子树只包含 严格大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。*/


public class Ex98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Ex98 ex98 = new Ex98();
        boolean res = ex98.isValidBST(root);
        System.out.println(res);
    }

    //    递归，判断当前节点是否在lower和upper之间，然后递归判断左子树和右子树是否符合要求
    public boolean isValidBST(TreeNode root) {
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }
}
