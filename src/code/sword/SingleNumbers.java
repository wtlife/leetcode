package code.sword;

/**
 * @Desc 56-1.SingleNumbers
 * @date 2020/9/3
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        int zeroCnt = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (num == 0) {
                zeroCnt++;
            }
            sum = sum ^ num;
        }

        if (zeroCnt == 1) {
            return new int[]{sum, 0};
        }


        int i = min, j = max;
        while (i <= j) {
            int mid = (i + j) / 2;
            int loSum = 0, hiSum = 0;
            for (int num : nums) {
                if (num <= i) {
                    loSum = loSum ^ num;
                } else {
                    hiSum = hiSum ^ num;
                }
            }

            if (hiSum != 0 && loSum != 0) {
                return new int[]{hiSum, loSum};
            }

            if (loSum == 0 && hiSum != 0) {
                i = mid + 1;
            }

            if (loSum != 0 && hiSum == 0) {
                j = mid - 1;
            }

        }
        return null;
    }
}
