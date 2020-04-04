package code.daybyday;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            int r = map.get(temp);
            if (r > len / 2) {
                return temp;
            }
        }

        return -1;
    }

    public int majorityElement1(int[] nums) {
        int count = 0;
        int num = -1;
        for (int temp : nums) {
            if (count == 0) {
                num = temp;
            }
            if (temp == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

}
