package classic.sort;

public class Merge {

    void execute(int[] ints) {
        int left = 0;
        int right = ints.length - 1;
        sort(ints, left, right);
    }

    private void sort(int[] ints, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) >> 1;
        sort(ints, left, mid);
        sort(ints, mid + 1, right);
        merge(ints, left, mid, right);
    }

    private void merge(int[] ints, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;

        while (p1 <= mid && p2 <= right) {
            temp[i++] = Math.min(ints[p1++], ints[p2++]);
        }
        while (p1 <= mid) {
            temp[i++] = ints[p1++];
        }
        while (p2 <= right) {
            temp[i++] = ints[p2++];
        }
        for (int j = 0; j < temp.length; j++) {
            ints[left + j] = temp[j];
        }
    }
}
