package code.sword;

/**
 * @Desc 16. MyPow
 * @date 2020/8/14
 */
public class MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        if (x == 1) {
            return res;
        }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            b =b  >> 1;
        }

        return res;
    }
}
