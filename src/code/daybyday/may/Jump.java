package code.daybyday.may;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {

    public int jump1(int[] nums) {

        int step = 0;
        int end = 0;
        int length = nums.length;
        int maxPosition = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }

        return step;

    }
}
