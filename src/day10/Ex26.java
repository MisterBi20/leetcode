package day10;

/*给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
        考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
        更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
        返回 k 。
        判题标准:
        系统会用下面的代码来测试你的题解:
        int[] nums = [...]; // 输入数组
        int[] expectedNums = [...]; // 长度正确的期望答案
        int k = removeDuplicates(nums); // 调用
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
        }
        如果所有断言都通过，那么您的题解将被 通过。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex26 ex26 = new Ex26();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(ex26.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    //    双指针替换
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int curr = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[curr] == nums[i]) continue;
            else nums[++curr] = nums[i];
        }
        return curr + 1;
    }
}
