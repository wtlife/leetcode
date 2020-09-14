package contest;

import java.util.Arrays;

/**
 * @Desc Calculate
 * @date 2020/9/12
 */
public class Contest{

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        long ans = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);

        for (int i = 0; i < staple.length; i++) {
            int a = staple[i];
            if (a >= x) {
                break;
            }
            int j = binarySearch(drinks, x - a);
            ans += (j + 1);
        }

        return (int) (ans % (1000000007));
    }

    private int binarySearch(int[] drinks, int target) {
        int left = 0;
        int right = drinks.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (drinks[mid] == target) {
                left = mid + 1;
            }
            if (drinks[mid] > target) {
                right = mid - 1;
            }
            if (drinks[mid] < target) {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Contest calculate = new Contest();
        int res = calculate.breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15);
        System.out.println(res);

        int res2 = calculate.breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9);
        System.out.println(res2);

    }
}
