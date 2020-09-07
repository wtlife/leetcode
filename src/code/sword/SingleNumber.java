package code.sword;

/**
 * @Desc 56-2.SingleNumber
 * @date 2020/9/4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        //由低到高各位统计
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += counts[31 - i] % m;
        }
        return res;
    }
}
