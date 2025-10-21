package day26;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。


public class Ex101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Ex101 ex101 = new Ex101();
        System.out.println(ex101.isSymmetric(root));
    }

    /*    递归，判断左子树和右子树是否镜像对称,
        递归的终止条件是左子树和右子树都为空，返回true，
        如果左子树和右子树有一个为空，返回false，
        如果左子树和右子树的根节点值不相等，返回false，
        否则递归判断左子树的左子树和右子树的右子树是否镜像对称，
        递归判断左子树的右子树和右子树的左子树是否镜像对称，
        如果两个递归都返回true，返回true，否则返回false。*/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left != null && right == null) return false;
        else if (left == null && right != null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
    }
}
