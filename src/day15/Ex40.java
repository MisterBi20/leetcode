package day15;

/*给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
        candidates 中的每个数字在每个组合中只能使用 一次 。
        注意：解集不能包含重复的组合。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex40 {
    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex40 ex40 = new Ex40();
        System.out.println("输入数组元素个数：");
        int n = scanner.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }
        System.out.println("输入目标值：");
        int target = scanner.nextInt();
        System.out.println(ex40.combinationSum2(candidates, target));
    }

    //    递归 + 回溯
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];//数组引用
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }
        // 情况1：不选择当前数字
        dfs(pos + 1, rest);
        // 情况2：选择当前数字 1~most 次
        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        // 回溯，移除添加的数字
        for (int i = 1; i <= most; i++) {
            sequence.remove(sequence.size() - 1);
        }
    }
}
