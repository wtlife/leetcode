package code.offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 面试题13.机器人的运动范围
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

}
