package day35;

/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
        此外，你可以假设该网格的四条边均被水包围。*/

public class Ex200 {
    boolean[][] visited;
    int dir[][] = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Ex200 ex200 = new Ex200();
        System.out.println(ex200.numIslands(grid));
    }
//    岛屿数量,使用深度优先搜索,遍历整个网格,如果当前位置是陆地,则岛屿数量加1,并使用深度优先搜索将当前岛屿的所有陆地标记为已访问
    public int numIslands(char[][] grid) {
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (visited[x][y] == true || grid[x][y] == '0') return;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) continue;
            dfs(grid, nextX, nextY);
        }
    }
}
