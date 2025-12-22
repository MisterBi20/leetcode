package day45;

//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：

import java.util.HashMap;
import java.util.Map;

public class Ex454 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        Ex454 ex454 = new Ex454();
        int i = ex454.fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(i);
    }
//    创建一个哈希表，key存放a+b的和，value存放和为key的组合数，
//    遍历nums1和nums2，将a+b的和作为key，和为key的组合数作为value，存入哈希表中。
//    遍历nums3和nums4，将0-(c+d)的和作为key，哈希表中是否存在该key，
//    如果存在，将哈希表中该key对应的值加到结果中。
    public int fourSumCount(int[] nums1,int[] nums2,int[] nums3,int[] nums4){
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i+j;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                res+=map.getOrDefault(0-i-j,0);
            }
        }
        return res;
    }
}
