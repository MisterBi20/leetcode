package day13;

/*给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回 [-1, -1]。
        你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        Ex34 ex34 = new Ex34();
        System.out.println(Arrays.toString(ex34.searchRange(nums, target)));
    }

    //找到中间值向两边延伸
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                int[] res = new int[]{mid, mid};
                int t = mid - 1;
                while (t >= 0) {
                    if (nums[t] != target) break;
                    res[0] = t;
                    t--;
                }
                t = mid + 1;
                while (t < nums.length) {
                    if (nums[t] != target) break;
                    res[1] = t;
                    t++;
                }
                return res;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
