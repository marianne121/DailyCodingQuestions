import java.util.Arrays;

public class MergeSort {
        int[] sort(int[] array, int low, int high) {
            // base case: 0 elements or 1 element
            if (low == high) {
                return array;
            }
            int mid = low + (high - low) / 2;

            sort(array, low, mid);
            sort(array, mid + 1, high);

            merge(array, low, mid, high);
            return array;
        }

        void merge(int[] array, int low, int mid, int high) {
            int[] left = Arrays.copyOfRange(array, low, mid + 1);
            int sizeLeft = mid - low + 1;
            int[] right = Arrays.copyOfRange(array, mid + 1, high + 1);
            int sizeRight = high - mid;

            int i = 0;
            int j = 0; // starting indices
            int k = low;
            while (i < sizeLeft && j < sizeRight) {
                if (left[i] <= right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }

            if (i < sizeLeft) {
                copyLeftOver(left, array, k, i);
            } else if (j < sizeRight) {
                copyLeftOver(right, array, k, j);
            }
        }
        void copyLeftOver(int[] array, int[] result, int currIndex, int startIndex) {
            while (startIndex < array.length) {
                result[currIndex] = array[startIndex];
                startIndex++;
                currIndex++;
            }
        }
}
