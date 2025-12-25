package day49;

/*给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
差值是一个正数，其数值等于两值之差的绝对值。*/

public class Ex530 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        Ex530 ex530 = new Ex530();
        int minimumDifference = ex530.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

    //    中序遍历，遍历过程中，记录前一个节点，当前节点与前一个节点的差值，取最小值
    TreeNode pre;
    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return res;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        if (pre != null) res = Math.min(res, root.val - pre.val);
        pre = root;
        traversal(root.right);
    }
}
