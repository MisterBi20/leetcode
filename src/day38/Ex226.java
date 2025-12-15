package day38;

//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。

public class Ex226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        Ex226 ex226 = new Ex226();
        TreeNode treeNode = ex226.invertTree(root);
    }

    //    递归，先交换左右子树，再递归交换左右子树的子树，直到叶子节点，交换完成后返回根节点
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
