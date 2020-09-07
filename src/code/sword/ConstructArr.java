package code.sword;

/**
 * @Desc 66.ConstructArr
 * @date 2020/9/6
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int[] ans = new int[a.length];
        if(a.length<1){
            return a;
        }
        ans[0]=1;
        int tmp=1;
        for (int i = 1; i <a.length ; i++) {
            ans[i] = ans[i-1] * a[i-1];
        }
        for (int i = a.length-2; i >=0 ; i--) {
            tmp = tmp * a[i+1];
            ans[i] = ans[i] * tmp;
        }

        return ans;
    }
}
