package day37;

/*找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
        只使用数字1到9
        每个数字 最多使用一次
        返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex216 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        Ex216 ex216 = new Ex216();
        System.out.println(ex216.combinationSum3(k, n));
    }

    //    回溯，从1-9中取k个数，使它们的和为n，每个数只能取一次，返回所有可能的有效组合的列表。
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        if (sum > targetSum) return;
        if (path.size() == k) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
