package classic.sort;

class Selection {
    void execute(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = ints[i];
                ints[i] = ints[minIndex];
                ints[minIndex] = temp;
            }
        }
    }
}
