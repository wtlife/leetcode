package code.daybyday.may;

/**
 * 287. 寻找重复数
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if (nums[i]==nums[j]){
                    return nums[j];
                }
            }
        }
        return -1;
    }
}
