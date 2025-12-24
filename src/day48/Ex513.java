package day48;

/*给定一个二叉树的 根节点 root，
请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。*/

public class Ex513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        Ex513 ex513 = new Ex513();
        int bottomLeftValue = ex513.findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }

    //    递归遍历，遍历到叶子节点时，判断是否是深度最大的叶子节点，
//    如果是，将该节点的值赋值给value，将深度赋值给Deep。
    private int Deep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left, deep + 1);
        if (root.right != null) findLeftValue(root.right, deep + 1);
    }
}
