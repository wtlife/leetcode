package code.tree;

/**
 * 96. 不同的二叉搜索树
 */
public class NumTrees {
    public int numTrees(int n) {
        //Gn表示以1...n为节点构成的二叉树有多少种
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += G[j] * G[i - j - 1];
            }
        }
        return G[n+1];
    }
}
