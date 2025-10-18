package day23;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ex77 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Ex77 ex77 = new Ex77();
        List<List<Integer>> combine = ex77.combine(n, k);
        System.out.println(combine);
    }

    /*回溯法，从1开始遍历，每次遍历到i时，将i加入path，然后递归调用combineHelper，
      递归调用结束后，将i从path中移除，继续遍历下一个数。*/
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return res;
    }

    private void combineHelper(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
    }
}
