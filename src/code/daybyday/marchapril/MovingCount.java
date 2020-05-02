package code.daybyday.marchapril;

import java.util.LinkedList;
import java.util.Queue;

public class MovingCount {
    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] first = queue.poll();
            int x = first[0];
            int y = first[1];
            int sum = getSum(x) + getSum(y);
            if (x >= m || y >= n || visited[x][y] || sum > k) {
                continue;
            }
            visited[x][y] = true;
            res++;
            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y + 1});
        }

        return res;
    }

    private int getSum(int index) {
        int sum = index % 10;
        int temp = index / 10;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }
}
