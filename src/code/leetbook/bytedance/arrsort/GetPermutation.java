package code.leetbook.bytedance.arrsort;

/**
 * @Desc GetPermutation
 * @date 2020/9/15
 */
public class GetPermutation {
    String ans = "";
    int cnt = 0;

    public String getPermutation(int n, int k) {

        helper("",  n, k);
        return ans;
    }

    public void helper(String curStr, int n, int k) {
        if (cnt==k){
            return;
        }
        if (curStr.length() == n) {
            cnt++;
            if (cnt == k) {
                ans = curStr;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (curStr.contains(String.valueOf(i))) {
                continue;
            }
            helper(curStr + i,  n, k);
        }
    }

}
