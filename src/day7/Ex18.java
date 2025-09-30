package day7;

/*给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
        请你找出并返回满足下述全部条件且不重复的四元组
        [nums[a], nums[b], nums[c], nums[d]]
        （若两个四元组元素一一对应，则认为两个四元组重复）：
        0 <= a, b, c, d < n  a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex18 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=scanner.nextInt();
        }
        int target=scanner.nextInt();
        Ex18 ex18=new Ex18();
        System.out.println(ex18.fourSum(nums,target));
    }
    public List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length; i++) {
            if (i>0&&nums[i-1]==nums[i]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1&&nums[j-1]==nums[j]) continue;
                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum>target) right--;
                    else if (sum<target) left++;
                    else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right&&nums[left]==nums[left+1]) left++;
                        while (left<right&&nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
