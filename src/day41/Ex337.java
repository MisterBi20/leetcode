package day41;

/*小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
        除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
        聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
        如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
        给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。*/

public class Ex337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));
        Ex337 ex337 = new Ex337();
        System.out.println(ex337.rob(root));
    }

//    动态规划，dp[i]表示i节点不偷的最高金额，dp[i][1]表示i节点偷的最高金额
//    如果偷i节点，那么i节点的左右子节点就不能偷，dp[i][1]=root.val+dp[i.left][0]+dp[i.right][0]
//    如果不偷i节点，那么i节点的左右子节点可以偷，也可以不偷，dp[i][0]=max(dp[i.left][0],dp[i.left][1])+max(dp[i.right][0],dp[i.right][1])

    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = robAction(root.left);
        int[] right = robAction(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
