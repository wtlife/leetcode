package code.daybyday.marchapril;

public class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        if (len <= 0) {
            return false;
        }
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;

        int i_sum = 0;
        int i = 0;
        for (; i < len; i++) {
            i_sum += A[i];
            if (i_sum == target) {
                break;
            }
        }

        int j_sum = 0;
        int j = i + 1;
        for (; j < len; j++) {
            j_sum += A[j];
            if (j_sum == target) {
                return true;
            }
        }
        return false;
    }
}
