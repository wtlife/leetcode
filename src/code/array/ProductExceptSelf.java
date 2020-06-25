package code.array;

/**
 * 238. 除自身以外的最大乘积
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }

        temp=1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp*= nums[i];
        }

        return res;
    }
}
