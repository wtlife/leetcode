package code.leetbook.bytedance.dp;

/**
 * @Desc MaxSubArray
 * @date 2020/9/24
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length<1){
            return 0;
        }
        int temp = nums[0];
        int res = nums[0];
        for(int i=1;i < nums.length;i++){
            if(temp <0){
                temp = nums[i];
            }else{
                temp = temp +nums[i];
            }

            res = Math.max(temp,res);
        }

        return res;
    }
}
