package code.contest;

import java.util.LinkedList;
import java.util.List;

public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        String pop = "Pop";
        String push = "Push";
        List<Integer> origianls = new LinkedList<>();
        List<String> res = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            origianls.add(i + 1);
        }

        int i = 0;
        int j = 0;
        while (j < target.length && i < origianls.size()) {
            int tar = target[j];
            int ori = origianls.get(i);

            if (tar == ori) {
                res.add(push);
                i++;
                j++;
            } else {
                res.add(push);
                res.add(pop);
                i++;
            }
        }

        return res;
    }
}
