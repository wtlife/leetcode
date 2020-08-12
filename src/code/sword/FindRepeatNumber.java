package code.sword;

/**
 * 面试题03. 数组中重复的数字
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //swap
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return res;
    }

    /**
     * 二分法
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        int len = nums.length;
        while (start < end) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, len, start, middle);

            if (end == start) {
                if (count > 1) {
                    return end;
                } else {
                    break;
                }
            }

            if (count > middle - start + 1) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] nums, int len, int start, int middle) {
        if (nums == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= start && nums[i] <= middle) {
                ++count;
            }
        }
        return count;
    }
}
