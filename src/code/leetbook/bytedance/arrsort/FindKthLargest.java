package code.leetbook.bytedance.arrsort;

/**
 * @Desc FindKthLargest
 * @date 2020/9/14
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int j = quickSearch(nums, 0, nums.length - 1, nums.length-k);
        return j;
    }

    private int quickSearch(int[] nums, int lo, int hi, int k) {
        int j  = partition(nums,lo,hi);
        if (j==k){
            return nums[j];
        }
        if (j>k){
            return quickSearch(nums,lo,j-1,k);
        }else {
            return quickSearch(nums,j+1,hi,k);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int idx = lo + (hi - lo) / 2;
        swap(nums, lo, idx);

        int pivot = nums[lo];
        int i = lo,j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < pivot) ;
            while (--j >= lo && nums[j] > pivot) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }

        nums[lo] = nums[j];
        nums[j] = pivot;
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
