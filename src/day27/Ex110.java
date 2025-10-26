package day27;

//给定一个二叉树，判断它是否是 平衡二叉树

public class Ex110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        Ex110 ex110 = new Ex110();
        System.out.println(ex110.isBalanced(root));
    }

    //    递归判断每个节点左右节点高度差的绝对值是否大于1
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
