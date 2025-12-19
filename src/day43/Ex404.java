package day43;

//给定二叉树的根节点 root ，返回所有左叶子之和。

public class Ex404 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Ex404 ex404 = new Ex404();
        System.out.println(ex404.sumOfLeftLeaves(root));
    }

    //    递归，左叶子的定义是左子树的左子树为空，右子树的右子树为空，所以判断是否为左叶子的条件是左子树的左子树为空，右子树的右子树为空，且当前节点的左子树不为空
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            midValue = root.left.val;
        int sum = leftValue + rightValue + midValue;
        return sum;
    }
}
