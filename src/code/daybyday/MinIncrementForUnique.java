package code.daybyday;

import java.util.Arrays;

public class MinIncrementForUnique {
    //计数排序O(N)
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[4001];
        int max = 0;
        for (int a : A) {
            count[a]++;
            max = Math.max(a, max);
        }
        int move = 0;
        for (int i = 0; i <= max; i++) {
            if (count[i] > 1) {
                int d = count[i] - 1;
                move += d;
                count[i + 1] += d;
            }
        }
        int d = count[max + 1] - 1;
        move += (d + 1) * d / 2;
        return move;
    }

    //线性探测法O(N) （含路径压缩）
    int[] pos = new int[80000];

    public int minIncrementForUnique2(int[] A) {
        Arrays.fill(pos, -1);
        int move = 0;
        for (int a : A) {
            int pos = findPos(a);
            move += pos - a;
        }
        return move;
    }

    private int findPos(int a) {
        int b = pos[a];
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        b = findPos(b + 1);
        pos[a] = b;
        return b;
    }
}
