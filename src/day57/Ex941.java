package day57;

/*给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组：
arr.length >= 3
在 0 < i < arr.length - 1 条件下，存在 i 使得：
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]*/

public class Ex941 {
    public static void main(String[] args) {
        int[] arr = {0,3,2,1};
        Ex941 ex941 = new Ex941();
        boolean res = ex941.validMountainArray(arr);
        System.out.println(res);
    }
//    双指针法，分别从数组的两端向中间遍历，判断是否能够找到一个点，使得左右两侧的元素都严格递增或严格递减。
    public boolean validMountainArray(int[] arr){
        if (arr.length<3) return false;
        int left = 0,right = arr.length-1;
        while (left+1<arr.length&&arr[left]<arr[left+1]) left++;
        while (right>0&&arr[right-1]>arr[right]) right--;
        if (left==right&&left!=0&&right!=arr.length-1) return true;
        return false;
    }
}
