package day39;

/*给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。*/

import java.util.Deque;
import java.util.LinkedList;

public class Ex239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Ex239 ex239 = new Ex239();
        int[] res = ex239.maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.println(i);
        }
    }

    //自定义队列，队头为最大值，队尾为最小值，队头出队时，判断是否为最大值，是则出队，不是则不出队，队尾出队时，判断是否为最小值，是则出队，不是则不出队，
// 队头出队时，判断是否为最大值，是则出队，不是则不出队，队尾出队时，判断是否为最小值，是则出队，不是则不出队
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
        }
        return res;
    }
}

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();

    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek())
            deque.poll();
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast())
            deque.removeLast();
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }
}