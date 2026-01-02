package day57;

/*给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
你可以返回 任何满足上述条件的数组作为答案 。*/

public class Ex922 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        Ex922 ex922 = new Ex922();
        int[] res = ex922.sortArrayByParityII(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    //    定义一个辅助数组res，用于存储排序后的数组。
//    定义两个指针even和odd，分别指向res数组的偶数下标和奇数下标。
//    遍历数组nums，根据 nums[i] 的奇偶性，将其放到 res 数组的 even 或 odd 下标处。
//    最后返回 res 数组。
    public int[] sortArrayByParityII(int[] nums) {
        int[] res = new int[nums.length];
        int even = 0, odd = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[even] = nums[i];
                even += 2;
            } else {
                res[odd] = nums[i];
                odd += 2;
            }
        }
        return res;
    }
}
