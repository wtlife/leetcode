package code.leetbook.bytedance.arrsort;

import java.util.Arrays;

/**
 * @Desc FindCircleNum
 * @date 2020/9/15
 */
public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                res++;
            }
        }

        return res;

    }

    private void union(int[] parent, int x, int y) {
        int xparent = find(parent, x);
        int yparent = find(parent, y);
        if (xparent != yparent) {
            parent[xparent] = yparent;
        }
    }

    private int find(int[] parent, int x) {

        while (parent[x] != -1) {
            x = parent[x];
        }
        return x;
    }



    public int findCircleNum2(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union2(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    int find2(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find2(parent, parent[i]);
    }

    void union2(int parent[], int x, int y) {
        int xset = find2(parent, x);
        int yset = find2(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }



}
