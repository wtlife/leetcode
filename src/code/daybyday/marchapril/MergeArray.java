package code.daybyday.marchapril;

public class MergeArray {

    //顺序双指针
    void merge1(int[] A, int m, int[] B, int n) {
        if (n <= 0) {
            return;
        }
        int a= 0;
        int b= 0;
        int r= 0;
        int[] res = new int[m + n];
        while (a< m && b< n) {
            if (A[a] < B[b]) {
                res[r++] = A[a++];
            } else {
                res[r++] = B[b++];
            }
        }
        while (a< m) {
            res[r++] = A[a++];
        }
        while (b< n) {
            res[r++] = B[b++];
        }
        System.arraycopy(res, 0, A, 0, m + n);
    }

    //逆序双指针
    void merge2(int[] A, int m, int[] B, int n) {
        if (n <= 0) {
            return;
        }
        int a = m - 1;
        int b = n - 1;
        int i = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[i--] = A[a--];
            } else {
                A[i--] = B[b--];
            }
        }
        while (b >= 0) {
            A[i--] = B[b--];
        }
    }

}
