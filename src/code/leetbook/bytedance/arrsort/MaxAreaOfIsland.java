package code.leetbook.bytedance.arrsort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc MaxAreaOfIsland
 * @date 2020/9/12
 */
public class MaxAreaOfIsland {

    //BFS
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                deque.addLast(new int[]{i, j});

                int area = 0;
                while (!deque.isEmpty()) {

                    int[] first = deque.pollFirst();
                    int x = first[0];
                    int y = first[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                        continue;
                    }
                    area++;
                    grid[x][y] = 0;
                    deque.addLast(new int[]{x - 1, y});
                    deque.addLast(new int[]{x + 1, y});
                    deque.addLast(new int[]{x, y - 1});
                    deque.addLast(new int[]{x, y + 1});

                    res = Math.max(res, area);
                }
            }
        }

        return res;
    }


    //DFS
    public int maxAreaOfIsland2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(dfs(i, j, grid), res);
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(i + 1, j, grid);
        area += dfs(i - 1, j, grid);
        area += dfs(i, j + 1, grid);
        area += dfs(i, j - 1, grid);
        return area;
    }
}
