public class QuickSort {
    // main function to implement quick sort
    int[] sort(int[] original, int low, int high) {
        while(low < high) {
            int partIdx = partition(original, low, high);

            sort(original, low, partIdx-1);
            sort(original, partIdx+1, high);
        }
        return original;
    }

    int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1;

        for(int j=low; j<high; j++) {
            // current element smaller or equal to, belongs on the left
            if(array[j] <= pivot) {
                i++;
                if(i != j) {
                    swap(array, i, j);
                }
            }
        }

        // swap position of partition
        // i is the last index of elements smaller than pivot
        swap(array, i+1, high);
        return i+1;
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
