package code.daybyday;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[] x = new int[]{0, 0, 1, -1};
        int[] y = new int[]{1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] first = queue.poll();
                int oldX = first[0];
                int oldY = first[1];

                for (int j = 0; j < 4; j++) {
                    int newX = oldX + x[j];
                    int newY = oldY + y[j];

                    if (newX >= 0 && newX < row &&
                            newY >= 0 && newY < col &&
                            matrix[newX][newY] == -1) {
                        matrix[newX][newY] = matrix[oldX][oldY] + 1;
                        queue.offer(new int[]{newX, newY});
                    }

                }
            }
        }
        return matrix;
    }
}
