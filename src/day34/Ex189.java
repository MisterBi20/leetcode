package day34;

//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

import java.util.Arrays;

public class Ex189 {
    public static void main(String[] args) {
        int[] nums =new  int[]{1,2,3,4,5,6,7};
        Ex189 ex189 = new Ex189();
        ex189.rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
//    反转三次
    public void rotate(int[] nums,int k){
        int n= nums.length;
        k%=n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
    private void reverse(int[] nums,int start,int end){
        for (int i = start,j=end; i < j; i++,j--) {
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
