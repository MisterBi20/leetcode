package day50;

/*给定一个不重复的整数数组nums。最大二叉树可以用下面的算法从nums递归地构建:
创建一个根节点，其值为nums中的最大值。
递归地在最大值左边的子数组前缀上 构建左子树。
递归地在最大值右边的子数组后缀上 构建右子树。
返回nums构建的最大二叉树.*/

public class Ex654 {
    public static void main(String[] args) {
        Ex654 ex654 = new Ex654();
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = ex654.constructMaximumBinaryTree(nums);
    }

    //    查找数组中最大值的索引，最大值左边的子数组前缀为[left,maxIndex)，
    //    最大值右边的子数组后缀为[maxIndex+1,right)，
    //    递归地在最大值左边的子数组前缀上 构建左子树，
    //    递归地在最大值右边的子数组后缀上 构建右子树。
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (right - left < 1) return null;
        if (right - left == 1) return new TreeNode(nums[left]);
        int maxIndex = left;
        int maxVal = nums[maxIndex];
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = buildTree(nums, left, maxIndex);
        root.right = buildTree(nums, maxIndex + 1, right);
        return root;
    }
}
