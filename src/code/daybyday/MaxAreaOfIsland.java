package code.daybyday;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        int res = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                res = Math.max(res, dfs(i, j, grid));
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }

}
