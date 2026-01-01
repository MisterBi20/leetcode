package day56;

/*给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
返回执行此操作后，grid 中最大的岛屿面积是多少？
岛屿 由一组上、下、左、右四个方向相连的 1 形成。*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex827 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {0, 1}};
        Ex827 ex827 = new Ex827();
        System.out.println(ex827.largestIsland(grid));
    }
//    深度优先搜索,遍历grid,如果当前位置为0,则将其标记为mark,并将其面积加入ans,
//    否则,将其加入hashSet,并将其面积加入curSize,最后返回curSize。

    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 0;
        grid[row][col] = mark;
        for (int[] current : position) {
            int curRow = row + current[0], curCol = col + current[1];
            if (curCol < 0 || curCol >= grid.length || curRow < 0 || curRow >= grid.length) continue;
            if (grid[curRow][curCol] == 1)
                ans += dfs(grid, curRow, curCol, mark) + 1;
        }
        return ans;
    }

    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE, size = grid.length, mark = 2;
        Map<Integer, Integer> getSize = new HashMap<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 1) {
                    int areaSize = dfs(grid, row, col, mark) + 1;
                    getSize.put(mark++, areaSize);
                }
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] != 0) continue;
                Set<Integer> hashSet = new HashSet<>();
                int curSize = 1;
                for (int[] current : position) {
                    int curRow = row + current[0], curCol = col + current[1];
                    if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) continue;
                    int curMark = grid[curRow][curCol];
                    if (hashSet.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    hashSet.add(curMark);
                    curSize += getSize.get(curMark);
                }
                ans = Math.max(ans, curSize);
            }
        }
        return ans == Integer.MIN_VALUE ? size * size : ans;
    }
}
