package code.sword;

/**
 * @Desc 39.MajorityElement
 * @date 2020/8/24
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int mid = quickSearch(nums, 0, nums.length - 1, nums.length / 2);
        return nums[mid];
    }

    private int quickSearch(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return left;
        }

        int j = partition(nums, left, right);
        if (j == k) {
            return j;
        }
        if (j > k) {
            return quickSearch(nums, left, j - 1, k);
        } else {
            return quickSearch(nums, j + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left, j = right + 1;
        while (true) {
            while (++i < right && nums[i] < pivot) ;
            while (--j > left && nums[j] > pivot) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public int majorityElement2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int vote = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                vote = num;
            }
            if (vote == num) {
                count++;
            } else {
                count--;
            }
        }
        return vote;
    }
}
