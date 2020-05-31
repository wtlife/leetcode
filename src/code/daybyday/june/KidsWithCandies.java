package code.daybyday.june;

import java.util.LinkedList;
import java.util.List;

/**
 * 1431. 拥有最多糖果的孩子
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> res = new LinkedList<>();
        for (int child : candies) {
            boolean temp = false;
            if (child + extraCandies>= max) {
                temp = true;
            }
            res.add(temp);
        }

        return res;
    }
}
