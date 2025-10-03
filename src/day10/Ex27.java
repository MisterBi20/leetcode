package day10;

/*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
        假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
        更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
        返回 k。
        用户评测:
        评测机将使用以下代码测试您的解决方案：
        int[] nums = [...]; // 输入数组
        int val = ...; // 要移除的值
        int[] expectedNums = [...]; // 长度正确的预期答案。
        // 它以不等于 val 的值排序。
        int k = removeElement(nums, val); // 调用你的实现
        assert k == expectedNums.length;
        sort(nums, 0, k); // 排序 nums 的前 k 个元素
        for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
        }
        如果所有的断言都通过，你的解决方案将会 通过。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex27 ex27 = new Ex27();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int val = scanner.nextInt();
        System.out.println(ex27.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

    //    双指针替换
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            else nums[curr++] = nums[i];
        }
        return curr;
    }
}
