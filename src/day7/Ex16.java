package day7;

/*        给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
        请你从 nums 中选出三个整数，使它们的和与 target 最接近。
        返回这三个数的和。
        假定每组输入只存在恰好一个解。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=scanner.nextInt();
        }
        int target=scanner.nextInt();
        Ex16 ex16=new Ex16();
        System.out.println(ex16.threeSumClosest(nums,target));
    }
    /*排序+双指针,与三数之和类似,对比更新，时间复杂度O(n^2)*/
    public int threeSumClosest(int[] nums,int target){
        Arrays.sort(nums);
        int closestSum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int l=i+1,r=nums.length-1;
            while (l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum=sum;
                }
                if (sum<target){
                    l++;
                }else if (sum>target){
                    r--;
                }else {
                    return sum;
                }
            }
        }
        return closestSum;
    }
}
