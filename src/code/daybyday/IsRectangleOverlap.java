package code.daybyday;

public class IsRectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean left = rec1[0] >= rec2[2] || rec1[1] >= rec2[3];
        boolean right = rec1[2] <= rec2[0] || rec1[3] <= rec2[1];
        if (left || right) {
            return false;
        }
        return true;
    }
}
