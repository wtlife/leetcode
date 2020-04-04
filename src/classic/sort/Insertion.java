package classic.sort;

class Insertion {
    void execute(int[] ints) {
        if (ints == null || ints.length == 0) {
            return;
        }
        for (int i = 1, j, current; i < ints.length; i++) {
            current = ints[i];
            for (j = i - 1; j >= 0 && current < ints[j]; j--) {
                ints[j + 1] = ints[j];
            }
            ints[j+1] = current;
        }
    }

    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;

    }
}
