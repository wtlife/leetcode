package code.daybyday.june;

/**
 * 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    //暴力
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = 0;
            int temp = 1;
            while (cur < len) {
                if (cur != i) {
                    temp *= nums[cur];
                }
                cur++;
            }
            res[i] = temp;
        }

        return res;
    }

    //优化
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < len; i++) {
            res[i] = k;
            k *= nums[i];
        }
        k = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }

        return nums;
    }
}
