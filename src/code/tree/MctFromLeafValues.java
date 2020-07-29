package code.tree;

/**
 * @Desc 1130. MctFromLeafValues
 * @date 2020/7/28
 */
public class MctFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] maxVal = new int[n][n];

        //先取得i-j的最大值
        for (int i = 0; i <n ; i++) {
            int tmp = arr[i];
            for (int j = i; j <n ; j++) {
                maxVal[i][j] = Math.max(tmp,arr[j]);
            }
        }

        int[][] dp = new int[n][n];
        for (int i=n-1; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                //k是i到j之间的中间某个值,i<=k<j
                int min = Integer.MAX_VALUE;
                for (int k=i; k<j; k++) {
                    min = Math.min(min,dp[i][k] + dp[k+1][j] + maxVal[i][k]*maxVal[k+1][j]);
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];

    }
}
