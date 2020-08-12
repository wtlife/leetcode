package code.sword;

/**
 * @Desc 10.2 NumWays
 * @date 2020/8/12
 */
public class NumWays {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int first = 1;
        int two = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = (first + two) % 1000000007;
            first = two;
            two = res;
        }
        return res;
    }
}
