package code.daybyday;

/**
 * 202. 快乐数
 */
public class IsHappy {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum(n);
        int res;
        while (slow != fast) {
            slow = getSum(n);
            fast = getSum(getSum(fast));
        }
        return slow == 1;
    }


    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
