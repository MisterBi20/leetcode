package day58;

/*给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。*/

public class Ex1020 {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        Ex1020 ex1020 = new Ex1020();
        int res = ex1020.numEnclaves(grid);
        System.out.println(res);
    }

    //    先遍历边界上的陆地单元格，将其以及其相邻的陆地单元格都标记为已访问。
//    然后遍历整个网格，统计未被访问的陆地单元格数量。
    int count = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) return;
        grid[x][y] = 0;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            dfs(grid, nextX, nextY);
        }
    }

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 1) dfs(grid, i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length - 1; i++) {
            if (grid[0][i] == 1) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 1) dfs(grid, grid.length - 1, i);
        }
        count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) dfs(grid, i, j);
            }
        }
        return count;
    }
}
