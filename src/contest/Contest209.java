package contest;

/**
 * @version V1.0
 * @Desc Contest209
 */
public class Contest209 {

    public int specialArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    tmp++;
                }
            }
            if (tmp == i+1) {
                return i+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Contest209 contest209 = new Contest209();
        contest209.specialArray(new int[]{3,5});
    }
}
