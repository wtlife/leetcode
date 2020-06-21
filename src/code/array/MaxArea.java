package code.array;

/**
 * 11. 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (l < r) {
            int tempArea = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, tempArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
