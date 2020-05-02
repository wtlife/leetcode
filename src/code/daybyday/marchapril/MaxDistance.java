package code.daybyday.marchapril;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDistance {
    public int maxDistance(int[][] grid) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int col = grid.length;
        int row = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[] point = null;
        boolean hasSea = false;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX > col || newY > row || newY < 0 || grid[newX][newY] > 0) {
                    continue;
                }
                hasSea = true;
                grid[newX][newY] = grid[x][y] + 1;
                queue.add(new int[]{newX, newY});
            }
        }
        if (point == null || !hasSea) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;

    }
}
