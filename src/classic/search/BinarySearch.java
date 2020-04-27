package classic.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (target >= nums[lo] && target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
