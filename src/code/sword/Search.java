package code.sword;

/**
 * @Desc 53-1.Search
 * @date 2020/9/3
 */
public class Search {
    public int search(int[] nums, int target) {
        int l = getFirstK(nums, target);
        if (l == -1) {
            return 0;
        }
        int r = getLastK(nums, target);
        return r - l + 1;
    }

    private int getFirstK(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                }
                j = mid - 1;
            } else {
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }

    private int getLastK(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || (nums[mid + 1] != target)) {
                    return mid;
                }
                i = mid + 1;
            } else {
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
        }
        return -1;
    }

}
