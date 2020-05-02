package code.daybyday.marchapril;

/**
 * 1248. 最优子数组
 */
public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int right = 0;
        int left = 0;
        int oddCnt = 0;
        while (right < nums.length) {

            if ((nums[right++] & 1) == 1) {
                oddCnt++;
            }

            if (oddCnt == k) {
                int rightTemp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int rightEven = right - rightTemp;

                int leftEven = 0;
                while ((nums[left] & 1) == 0) {
                    left++;
                    leftEven++;
                }

                res += (rightEven + 1) * (leftEven + 1);
                left++;
                oddCnt--;
            }
        }
        return res;
    }
}
