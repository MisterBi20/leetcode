package day13;

/*请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
        数字 1-9 在每一行只能出现一次。
        数字 1-9 在每一列只能出现一次。
        数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）*/

import java.util.Scanner;

public class Ex36 {
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
        Ex36 ex36 = new Ex36();
        if (ex36.isValidSudoku(board)) {
            System.out.println("这个数独是有效的！");
        } else {
            System.out.println("这个数独是无效的！");
        }
    }

    //    创建三个在数组遍历每个字符的位置标记个数输出结果
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
