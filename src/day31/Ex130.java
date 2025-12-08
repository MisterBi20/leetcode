package day31;

/*给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域：
        连接：一个单元格与水平或垂直方向上相邻的单元格连接。
        区域：连接所有 'O' 的单元格来形成一个区域。
        围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。
        通过 原地 将输入矩阵中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。你不需要返回任何值。*/

import java.util.ArrayDeque;
import java.util.Queue;

public class Ex130 {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Ex130 ex130 = new Ex130();
        ex130.solve(board);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
    }

    //    从边界开始搜索，将所有与边界相连的O标记为visited，
//    然后遍历整个矩阵，将所有未被标记为visited的O替换为X，
//    最后将所有被标记为visited的O替换为O。
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int row = 0; row < rowSize; row++) {
            if (board[row][0] == 'O') {
                visited[row][0] = true;
                queue.add(new int[]{row, 0});
            }
            if (board[row][colSize - 1] == 'O') {
                visited[row][colSize - 1] = true;
                queue.add(new int[]{row, colSize - 1});
            }
        }
        for (int col = 1; col < colSize - 1; col++) {
            if (board[0][col] == 'O') {
                visited[0][col] = true;
                queue.add(new int[]{0, col});
            }
            if (board[rowSize - 1][col] == 'O') {
                visited[rowSize - 1][col] = true;
                queue.add(new int[]{rowSize - 1, col});
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] pos : position) {
                int row = current[0] + pos[0], col = current[1] + pos[1];
                if (row < 0 || row >= rowSize || col < 0 || col >= colSize) continue;
                if (visited[row][col] || board[row][col] != 'O') continue;
                visited[row][col] = true;
                queue.add(new int[]{row, col});
            }
        }
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) board[row][col] = 'X';
            }
        }
    }
}
