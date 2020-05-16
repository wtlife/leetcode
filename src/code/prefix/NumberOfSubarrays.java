package code.prefix;

/**
 * 1248. 优美子数组
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int[] count = new int[nums.length+1];

        //下表为奇数个数, 值为出现次数
        count[0] = 1;

        int prefix = 0, ans = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                prefix += 1;
            }

            if (prefix >= k) {
                ans += count[prefix - k];
            }

            count[prefix] += 1;
        }
        return ans;

    }
}
