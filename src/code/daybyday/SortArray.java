package code.daybyday;


public class SortArray {
    public int[] sortArray(int[] nums) {

        int head = 0;
        int tail = nums.length - 1;
        quick(nums, head, tail);
        return nums;
    }

    private void quick(int[] nums, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int pivot = partition(nums, head, tail);
        quick(nums, head, pivot - 1);
        quick(nums, pivot + 1, tail);
    }

    private int partition(int[] nums, int head, int tail) {

        int pivot = nums[head];
        int i = head;
        int j = tail+1;
        while (true) {
            while (++i<= tail && nums[i] < pivot) ;
            while (--j>= head && nums[j] > pivot) ;
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
