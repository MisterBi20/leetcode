package day44;

/*    有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
    这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
    岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
    返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。*/

import java.util.ArrayList;
import java.util.List;

public class Ex417 {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        Ex417 ex417 = new Ex417();
        List<List<Integer>> pacificAtlantic = ex417.pacificAtlantic(heights);
        for (List<Integer> p : pacificAtlantic) {
            System.out.println(p);
        }
    }

    //    深度优先搜索，从太平洋和大西洋的边界开始搜索，标记可以到达的单元格，最后遍历所有单元格，找到可以同时到达太平洋和大西洋的单元格。
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void dfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
        for (int[] current : position) {
            int curRow = row + current[0], curCol = col + current[1];
            if (curRow < 0 || curRow >= heights.length || curCol < 0 || curCol >= heights[0].length) continue;
            if (heights[curRow][curCol] < heights[row][col] || visited[curRow][curCol][sign]) continue;
            visited[curRow][curCol][sign] = true;
            dfs(heights, curRow, curCol, sign, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rowSize = heights.length;
        int colSize = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][][] visited = new boolean[rowSize][colSize][2];
        for (int row = 0; row < rowSize; row++) {
            visited[row][colSize - 1][0] = true;
            visited[row][0][1] = true;
            dfs(heights, row, colSize - 1, 0, visited);
            dfs(heights, row, 0, 1, visited);
        }
        for (int col = 0; col < colSize; col++) {
            visited[rowSize - 1][col][0] = true;
            visited[0][col][1] = true;
            dfs(heights, rowSize - 1, col, 0, visited);
            dfs(heights, 0, col, 1, visited);
        }
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (visited[row][col][0] && visited[row][col][1]) {
                    ans.add(List.of(row, col));
                }
            }
        }
        return ans;
    }
}
