package code.daybyday.marchapril;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int good = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    good++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        while (!queue.isEmpty() && good > 0) {
            minutes++;
            int times = queue.size();
            for (int k = 0; k < times; k++) {

                int[] orange = queue.poll();
                int i = orange[0];
                int j = orange[1];
                //上
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.add(new int[]{i - 1, j});
                    good--;
                }
                //下
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    queue.add(new int[]{i + 1, j});
                    good--;
                }
                //左
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.add(new int[]{i, j - 1});
                    good--;
                }
                //右
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    queue.add(new int[]{i, j + 1});
                    good--;
                }
            }
        }
        return good > 0 ? -1 : minutes;
    }
}

