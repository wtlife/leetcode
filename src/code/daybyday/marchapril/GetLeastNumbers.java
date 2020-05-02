package code.daybyday.marchapril;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {
    //使用大根堆/O(NlogK)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (q.size() < k) {
                q.add(num);
            } else if (num < q.peek()) {
                q.poll();
                q.add(num);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (Integer i : q) {
            res[index++] = i;
        }
        return res;
    }

    //快排思想
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k-1);
    }

    private int[] quickSearch(int[] arr, int head, int tail, int k) {
        int j = partition(arr, head, tail);
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        if (j > k) {
            return quickSearch(arr, head, j - 1, k);
        } else {
            return quickSearch(arr, j + 1, tail, k);
        }
    }

    private int partition(int[] arr, int head, int tail) {
        int i = head;
        int j = tail + 1;
        int pivot = arr[head];
        while (true) {
            while (++i <= tail&& arr[i] < pivot) ;
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
