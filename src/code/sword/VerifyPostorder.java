package code.sword;

import com.sun.media.jfxmediaimpl.HostUtils;

/**
 * @Desc 33.VerifyPostorder
 * @date 2020/8/20
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 2) {
            return true;
        }
        return helper(0, postorder.length-1, postorder);
    }

    private boolean helper(int start, int end, int[] postorder) {
        if (start>=end){
            return true;
        }
        int root = postorder[end];
        int p =start;
        while (postorder[p]<root){
            p++;
        }


        int q = p;
        while (postorder[q]>root){
            q++;
        }

        return q==end && helper(start,p-1,postorder) && helper(p,end-1,postorder);
    }
}
