package code.sword;

/**
 * @Desc 10. Fib
 * @date 2020/8/12
 */
public class Fib {
    public int fib(int n) {
        if (n<=1){
            return n;
        }
        int first = 0;
        int second =1;
        int res= 0;
        for (int i = 2; i < n; i++) {
            res = (first+second) % 1000000007;
            first = second;
            second = res;
        }
        return res;
    }
}
