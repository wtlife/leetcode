package code.daybyday.marchapril;

/**
 * 面试题56 - I. 数组中数字出现的次数
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int zeroCount = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }
        if (zeroCount == 1) {
            return new int[]{0, sum};
        }

        int lo = min;
        int hi = max;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int loSum = 0;
            int hiSum = 0;
            for (int num : nums) {
                if (num < mid) {
                    loSum ^= num;
                } else {
                    hiSum ^= num;
                }
            }
            if (loSum != 0 && hiSum != 0) {
                return new int[]{loSum, hiSum};
            }
            //说明mid太小
            if (loSum == 0) {
                lo = mid;
            } else {
                hi = mid;
            }

        }
        return null;
    }
}
