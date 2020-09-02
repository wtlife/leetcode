package code.sword;

import code.listnode.ReverseList;

/**
 * @Desc 51.ReversePairs
 * @date 2020/9/2
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    res++;
                }
            }
        }

        return res;
    }


    int res = 0;

    public int reversePairs2(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return res;
    }

    private void sort(int[] ints, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sort(ints, left, mid);
        sort(ints, mid + 1, right);
        merge(ints, left, mid, right);
    }

    private void merge(int[] ints, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= right) {

            if (ints[p2] <= ints[p1]) {
                temp[i++] = ints[p2++];
                res += (mid - p1 + 1);
            } else {
                temp[i++] = ints[p1++];
            }
        }

        while (p1 <= mid) {
            temp[i++] = ints[p1++];
        }

        while (p2 <= right) {
            temp[i++] = ints[p2++];
            res += (mid - p1 + 1);
        }

        for (int j = 0; j < temp.length; j++) {
            ints[left + j] = temp[j];
        }
    }

}
