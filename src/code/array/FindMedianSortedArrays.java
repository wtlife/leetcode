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
}
