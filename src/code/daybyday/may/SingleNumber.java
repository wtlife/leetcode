package code.daybyday.may;

/**
 *  136. 只出现一次的数字
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i:nums) {
            ans^=i;
        }

        return ans;
    }
}
