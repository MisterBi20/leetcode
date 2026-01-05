package day60;

//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。请返回 封闭岛屿 的数目。

public class Ex1254 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        Ex1254 ex1254 = new Ex1254();
        int res = ex1254.closedIsland(grid);
        System.out.println(res);
    }

    int count = 0;
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    //深度优先搜索，从边界的0开始搜索，将所有与边界相连的0都标记为1，最后统计grid中剩余的0的数目即可，即可得到封闭岛屿的数目
    private void dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 1) return;
        grid[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) continue;
            dfs(grid, nextX, nextY);
        }
    }

    public int closedIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][grid[0].length - 1] == 0) dfs(grid, i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length - 1; i++) {
            if (grid[0][i] == 0) dfs(grid, 0, i);
            if (grid[grid.length - 1][i] == 0) dfs(grid, grid.length - 1, i);
        }
        count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
