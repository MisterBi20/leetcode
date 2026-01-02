package day57;

/*给定一个二叉树，我们在树的节点上安装摄像头。
节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
计算监控树的所有节点所需的最小摄像头数量。*/

public class Ex968 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(0);
        Ex968 ex968 = new Ex968();
        int res = ex968.minCameraCover(root);
        System.out.println(res);
    }

    //    定义一个全局变量res，用于记录摄像头数量，初始值为0。
    //    定义一个递归函数minCame，用于计算每个节点的状态。
    //    如果节点为空，返回2，表示该节点没有被覆盖。
    //    如果节点的左右子节点都被覆盖，返回0，表示该节点没有安装摄像头。
    //    如果节点的左右子节点中至少有一个没有被覆盖，返回1，表示该节点安装了摄像头。
    //    如果节点的左右子节点中至少有一个安装了摄像头，返回2，表示该节点没有被覆盖。
    int res = 0;

    public int minCameraCover(TreeNode root) {
        if (minCame(root) == 0) res++;
        return res;
    }

    public int minCame(TreeNode root) {
        if (root == null) return 2;
        int left = minCame(root.left);
        int right = minCame(root.right);
        if (left == 2 && right == 2) return 0;
        else if (left == 0 || right == 0) {
            res++;
            return 1;
        } else return 2;
    }
}
