package classic.sort;

public class Quick {

    public void execute(int[] ints) {
        int head = 0;
        int tail = ints.length - 1;
        quick(ints, head, tail);
        System.out.println(ints);
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
}
