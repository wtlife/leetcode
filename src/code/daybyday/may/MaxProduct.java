package code.daybyday.may;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tempMin = 1, tempMax = 1;

        for (int num : nums) {
            if (num < 0) {
                int temp = tempMin;
                tempMin = tempMax;
                tempMax = temp;
            }
            tempMax = Math.max(tempMax * num, num);
            tempMin = Math.min(tempMin * num, num);

            max = Math.max(max, tempMax);
        }
        return max;
    }
}
