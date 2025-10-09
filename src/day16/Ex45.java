package day16;

/*给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。
        每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：
        0 <= j <= nums[i] 且
        i + j < n
返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。*/

import java.util.Scanner;

public class Ex45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex45 ex45 = new Ex45();
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("输入数组元素：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(ex45.jump(nums));
    }
    public int jump(int[] nums){
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length-1; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
