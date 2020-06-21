package code.array;


/**
 * 4. 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        int k = totalLen / 2;
        if (totalLen % 2 == 1) {
            return getK(nums1, nums2, k + 1);
        } else {
            return (getK(nums1, nums2, k) + getK(nums1, nums2, k + 1)) / 2.0;
        }
    }

    private double getK(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int a = 0;
        int b = 0;

        while (true) {
            if (len1 == 0) {
                return nums2[k - 1];
            }
            if (len2 == 0) {
                return nums1[k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[a], nums2[b]);
            }


            int tempK = k / 2;
            int tempA = Math.min(a + tempK, len1) - 1;
            int tempB = Math.min(b + tempK, len2) - 1;

            int pivotA = nums1[tempA];
            int pivotB = nums2[tempB];
            if (pivotA <= pivotB) {
                k -= (tempA - a) + 1;
                a = tempA + 1;
            } else {
                k -= (tempB - b) + 1;
                b = tempB + 1;
            }

        }
    }


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2
        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;
        while (left < right) {
            //i,j表示分割线右边第一个元素的下表/因此也可以表示分割线左边的元素数量
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left=i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }

}
