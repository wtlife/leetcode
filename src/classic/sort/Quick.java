package classic.sort;

import java.util.Arrays;

public class Quick {

    public void execute(int[] ints) {
        int head = 0;
        int tail = ints.length - 1;
        quick(ints, head, tail);
        System.out.println(Arrays.toString(ints));
    }

    private void quick(int[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int j = partition(arr, head, tail);
        quick(arr, head, j - 1);
        quick(arr, j + 1, tail);
    }

    private int partition(int[] arr, int head, int tail) {
        int i = head;
        int j = tail + 1;
        int pivot = arr[head];
        while (true) {
            while (++i <= tail && arr[i] < pivot) ;
            while (--j >= head && arr[j] > pivot) ;
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[head] = arr[j];
        arr[j] = pivot;
        return j;
    }


    public int partition2(int[] a, int left, int right) {
        int base = a[left];
        int i = left;
        int j = right;
        //移动元素使得基线值
        while (i < j) {
            //左移放前面
            while (i < j && base <= a[j]) {
                j--;
            }
            //右移
            while (i < j && base >= a[i]) {
                i++;
            }

            if (i < j) {
                swap(a, i, j);
            }
        }
        //交换base和比base小的最后一个元素的值
        swap(a, left, i);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
