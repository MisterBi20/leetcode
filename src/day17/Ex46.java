package day17;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex46 ex46 = new Ex46();
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(ex46.permute(nums));
    }
    //回溯，每次从first开始，将first与i交换，然后递归调用，最后将first与i交换回来，保持原数组不变
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n,output,res,0);
        return res;
    }
    public void backtrack(int n,List<Integer> output,List<List<Integer>> res,int first){
        if (first == n){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output,first,i);
            backtrack(n,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }
}
