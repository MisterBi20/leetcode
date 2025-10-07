package day14;

/*编写一个程序，通过填充空格来解决数独问题。
        数独的解法需 遵循如下规则：
        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
        数独部分空格内已填入了数字，空白格用 '.' 表示。*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex37 {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] colum = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("请输入数独棋盘的9行（每行9个字符，用.表示空格）：");

        for (int i = 0; i < 9; i++) {
            String line;
            while (true) {
                System.out.print("第 " + (i + 1) + " 行：");
                line = scanner.nextLine().trim();
                if (line.length() == 9) break;  // 确保输入9个字符
                System.out.println("输入长度必须为9，请重新输入！");
            }
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        Ex37 ex37 = new Ex37();
        ex37.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    //    回溯算法来填充数独的空格，确保所有的数独规则得到遵守
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = colum[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++) {
            if (!line[i][digit] && !colum[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = colum[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = colum[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }
}
