package code.daybyday;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 200. 岛屿数量
 */
public class NumIslands {
    /**
     * 深度优先搜索
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        if (m == 0) {
            return res;
        }
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        grid[i][j] = '0';
        //上下左右
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }


    /**
     * 广度优先搜索
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int res = 0;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!queue.isEmpty()) {
                        int[] first = queue.poll();
                        int x = first[0];
                        int y = first[1];
                        //上下左右
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.offer(new int[]{x - 1, y});
                            grid[x-1][y] = '0';
                        }
                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            queue.offer(new int[]{x + 1, y});
                            grid[x+1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.offer(new int[]{x, y - 1});
                            grid[x][y-1] = '0';
                        }
                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            queue.offer(new int[]{x, y + 1});
                            grid[x][y+1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}
