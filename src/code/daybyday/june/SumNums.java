package code.daybyday.june;

/**
 * 面试题64. 求1+2+…+n
 */
public class SumNums {
    public int sumNums(int n) {
        return ((int)Math.pow(n,2)+n)>>1;
    }
}
