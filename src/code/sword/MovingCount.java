package code.sword;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 13. moving count
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int sum = 0;
            int[] first = queue.poll();
            int x = first[0];
            int y = first[1];
            sum += getDigitSum(x);
            sum += getDigitSum(y);
            if (x >= m || y >= n || sum > k) {
                continue;
            }
            visited[x][y] = true;
            res++;

            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y + 1});

        }

        return res;
    }

    private int getDigitSum(int x) {
        int sum = x % 10;
        int temp = x / 10;
        while (temp != 0) {
            sum += temp % 10;
            temp = x / 10;
        }
        return sum;
    }

    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return moving(0, 0, m, n, k, visited);
    }

    private int moving(int i, int j, int m, int n, int k, boolean[][] visited) {
        int count = 0;
        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || visited[i][j]) {
            return count;
        }
        visited[i][j] = true;
        count = 1 +
                moving(i + 1, j, m, n, k, visited) +
                moving(i - 1, j, m, n, k, visited) +
                moving(i, j + 1, m, n, k, visited) +
                moving(i, j - 1, m, n, k, visited);
        return count;
    }


}
