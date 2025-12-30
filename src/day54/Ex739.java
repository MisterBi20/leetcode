package day54;

/*给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
如果气温在这之后都不会升高，请在该位置用 0 来代替。*/

import java.util.Deque;
import java.util.LinkedList;

public class Ex739 {
    public static void main(String[] args) {
        Ex739 ex739 = new Ex739();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = ex739.dailyTemperatures(temperatures);
        for (int i : res) {
            System.out.println(i);
        }
    }

    //    定义栈，栈中存储的是数组的下标，栈中元素对应的温度是单调递减的，
//    当遍历到一个元素时，如果该元素大于栈顶元素对应的温度，
//    则弹出栈顶元素，直到栈为空或者栈顶元素对应的温度大于当前元素对应的温度。
//    弹出栈顶元素时，当前元素就是栈顶元素对应的下一个更高温度的位置。
//    最后栈中剩余的元素对应的下一个更高温度的位置就是0。
    public int[] dailyTemperatures(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < lens; i++) {
            if (temperatures[i] <= temperatures[stack.peek()])
                stack.push(i);
            else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
