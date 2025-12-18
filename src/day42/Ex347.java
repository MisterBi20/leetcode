package day42;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ex347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        Ex347 ex347 = new Ex347();
        int[] ans = ex347.topKFrequent(nums,k);
        for (int i : ans) {
            System.out.println(i);
        }
    }
//    大根堆，先将元素出现次数放入map中，然后将map中的元素放入大根堆中，根据元素出现次数排序，最后取出前k个元素即可
    public int[] topKFrequent(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair2[1]-pair1[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}
