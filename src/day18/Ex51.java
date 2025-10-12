package day18;

/*      按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
        n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
        给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
        每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex51 {
    private List<List<String>> res = new ArrayList<>();
    private char[][] board;
    private int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex51 ex51 = new Ex51();
        int n = scanner.nextInt();
        System.out.println(ex51.solveNQueens(n));
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0);
        return res;
    }

    //回溯算法
    private void backtrack(int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] s : board)
                temp.add(new String(s));
            res.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (legal(row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }

    //向上判断是否重复
    private boolean legal(int r, int c) {
        for (int i = r; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
