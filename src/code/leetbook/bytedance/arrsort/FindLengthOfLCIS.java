package code.leetbook.bytedance.arrsort;

/**
 * @Desc FindLengthOfLCIS
 * @date 2020/9/14
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        Integer streak = Integer.MIN_VALUE;
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num > streak) {
                streak = num;
                count++;
            }else {
                streak =num ;
                count=1;
            }
            max =Math.max(max,count);
        }
        return max;
    }
}
