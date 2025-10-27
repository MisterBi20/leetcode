package day28;

/*给定一个二叉树，找出其最小深度。
        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
        说明：叶子节点是指没有子节点的节点。*/

public class Ex111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Ex111 ex111 = new Ex111();
        int minDepth = ex111.minDepth(root);
        System.out.println(minDepth);
    }

    //    递归，分别递归左子树和右子树，返回左右子树的最小深度，返回值为左右子树的最小深度+1
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }
}
