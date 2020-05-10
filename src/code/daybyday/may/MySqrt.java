package code.daybyday.may;

/**
 * 69. x 的平方根
 */
public class MySqrt {

    public int mySqrt(int x) {
        int lo = 0, h = x;
        int ans = 0;
        while (lo <= h) {
            int mid = lo + ((h - lo) >> 1);
            long temp =(long) mid * mid;
            if (temp == x) {
                return mid;
            }

            if (temp < x) {
                lo = mid + 1;
                ans = mid;
            } else if (temp > x) {
                h = mid - 1;
            }
        }
        return ans;

//        int l = 0, r = x, ans = -1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if ((long) mid * mid <= x) {
//                ans = mid;
//                l = mid + 1;
//            } else {
//                r = mid - 1;
//            }
//        }
//        return ans;

    }
}
