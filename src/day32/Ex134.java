package day32;

/*
在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
        给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
*/

public class Ex134 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Ex134 ex134 = new Ex134();
        System.out.println(ex134.canCompleteCircuit(gas, cost));
    }

    //    三种情况：
//    1.如果gas的总和小于cost的总和，那么无论从哪里出发，一定是跑不了一圈的
//    2.如果gas的总和大于等于cost的总和，那么一定有解
//    3.如果从i出发，跑了j个站，发现油不够了，那么从i到j之间的任何一个站出发，都跑不了j个站
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = Math.min(min, sum);
        }
        if (sum < 0) return -1;
        if (min >= 0) return 0;
        for (int i = gas.length - 1; i > 0; i--) {
            min += gas[i] - cost[i];
            if (min >= 0) return i;
        }
        return -1;
    }

}
