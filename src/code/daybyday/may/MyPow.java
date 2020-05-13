package code.daybyday.may;

/**
 * 50. Pow(x, n)
 */
public class MyPow {
    public double myPow(double x, int n) {
        double tempX = x;
        long tempN = Math.abs(n);
        double ans = 1;
        while (tempN > 0) {
            if ((tempN & 1) == 1) {
                ans *= tempX;
            }
            tempX *= tempX;
            tempN >>= 1;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
