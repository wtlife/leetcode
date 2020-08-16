package code.sword;

/**
 * 二进制中1的个数
 *
 * @Desc 15. HammingWeight
 * @date 2020/8/16
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res = res + n & 1;
            n = n >> 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
       int res =0;
       while (n!=0){
           res++;
           n = n&(n-1);
       }
       return res;
    }
}
