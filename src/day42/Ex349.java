package day42;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex349 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,2,1,3};
        int[] num2 = new int[]{1,2,2};
        Ex349 ex349 = new Ex349();
        System.out.println(Arrays.toString(ex349.intersection(num1,num2)));
    }
//    定义两个set,一个set用来存储nums1中的元素,另一个set用来存储nums2中的元素
//    遍历nums1,将nums1中的元素添加到set1中
//    遍历nums2,如果set1中包含nums2中的元素,则将该元素添加到resSet中
//    将resSet转换为数组并返回
    public int[] intersection(int[] nums1,int[] nums2){
        if (nums1==null||nums1.length==0||nums2==null||nums2.length==0) return new int[0];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i))
                resSet.add(i);
        }
        int[] ans = new int[resSet.size()];
        int j = 0;
        for (Integer i : resSet) {
            ans[j++] = i;
        }
        return ans;
    }
}
