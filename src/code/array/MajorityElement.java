package code.array;

/**
 * 169. 多数元素
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = -1;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            if (ans == num) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }

    public int majorityElement2(int[] nums) {
        return quickSearch(nums, 0, nums.length - 1, nums.length / 2);
    }

    private int quickSearch(int[] nums, int head, int tail, int k) {
        int j = partition(nums, head, tail);
        if (j == k) {
            return j;
        }
        if (j > k) {
            return quickSearch(nums, head, j - 1, k);
        } else {
            return quickSearch(nums, j + 1, tail, k);
        }
    }

    private int partition(int[] nums, int head, int tail) {
        int pivot = nums[head];
        int i = head, j = tail + 1;
        while (true) {
            while (++i <= tail && nums[i] < pivot) ;
            while (--j >= head && nums[j] > pivot) ;
            if (i >= j) {
                break;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[head] = nums[j];
        nums[j] = pivot;
        return j;
    }
}
