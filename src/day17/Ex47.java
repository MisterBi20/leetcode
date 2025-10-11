package day17;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex47 {
    boolean[] vis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex47 ex47 = new Ex47();
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("输入数组元素：");
        for(int i = 0;i<n;i++){
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> res = ex47.permuteUnique(nums);
        for(List<Integer> list : res){
            System.out.println(list);
        }
    }
/*    回溯+剪枝,时间复杂度O(n*n!),空间复杂度O(n),n为数组长度,
    排序后,相同元素会相邻,如果当前元素和前一个元素相同,且前一个元素未被访问,则当前元素不能被访问,
    因为前一个元素还在当前层,如果当前元素被访问,则会重复访问前一个元素,导致重复全排列,
    所以如果当前元素和前一个元素相同,且前一个元素未被访问,则当前元素不能被访问.*/
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, res, 0, perm);
        return res;
    }
    public void backtrack(int[] nums,List<List<Integer>> ans,int index,List<Integer> perm){
        if(index == nums.length){
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(vis[i] || (i>0 && nums[i] == nums[i-1] && !vis[i-1])){
                continue;
            }
            vis[i] = true;
            perm.add(nums[i]);
            backtrack(nums, ans, index+1, perm);
            vis[i] = false;
            perm.remove(index);
        }
    }
}
