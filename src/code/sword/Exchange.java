package code.sword;

/**
 * @Desc 21.Exchange 调整数组的顺序
 * @date 2020/8/16
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int head = 0;
        int tail = nums.length - 1;

        //奇数在前偶数在后
        while (head < tail) {
            while (head < tail && (nums[head] & 1) == 1) {
                head++;
            }

            while (head < tail && (nums[tail] & 1) == 0) {
                tail--;
            }

            int tmp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = tmp;

        }

        return nums;
    }
}
