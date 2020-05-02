package code.daybyday.marchapril;

import entity.MountainArray;

/**
 * 1095. 山脉数组中查找目标值
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int size = mountainArr.length();
        //先找出peak
        int lo = 0;
        int hi = size - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                hi = mid + 1;
            } else {
                lo = mid;
            }
        }
        int peak = lo;
        int res = binSearch(mountainArr, 0, peak, target, true);
        if (res != -1) {
            return res;
        }
        //二分查找
        return binSearch(mountainArr, peak + 1, size - 1, target, false);
    }

    private int binSearch(MountainArray mountainArr, int lo, int hi, int target, boolean asc) {
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int temp = mountainArr.get(mid);
            if (target == temp) {
                return mid;
            }
            //判断升序降序
            if (target > temp) {
                lo = asc ? mid + 1 : lo;
                hi = asc ? hi : mid - 1;
            } else {
                hi = asc ? mid - 1 : hi;
                lo = asc ? lo : mid + 1;
            }
        }
        return -1;
    }
}
