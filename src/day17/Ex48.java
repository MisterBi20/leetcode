package day17;

/*给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。*/

import java.util.Arrays;
import java.util.Scanner;

public class Ex48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ex48 ex48 = new Ex48();
        System.out.println("输入数组维数：");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        ex48.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /*  矩阵转置:matrix[i][j] ↔ matrix[j][i]
        矩阵水平镜像:matrix[i][j] ↔ matrix[i][n-1-j]
        矩阵垂直镜像:matrix[i][j] ↔ matrix[m-1-i][j]
        矩阵顺时针旋转90度， new_matrix[j][n-1-i] = matrix[i][j],就相当于垂直镜像+转置
        矩阵顺时针旋转180度，new_matrix[n-1-i][n-1-j] = matrix[i][j],就相当于水平镜像+垂直镜像
        矩阵逆时针旋转90度，new_matrix[n-1-j][i] = matrix[i][j],就相当于水平镜像+转置*/
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
