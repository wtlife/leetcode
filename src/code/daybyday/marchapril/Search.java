package code.daybyday.marchapril;

/**
 * 33. 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
}
