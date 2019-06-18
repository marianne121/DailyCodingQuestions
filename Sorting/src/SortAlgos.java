import java.util.Arrays;

public class SortAlgos {

    public static void main(String[] args) {
        int[] original = {9,90,40,23,13,15,1,1000,12,80};
        insertionSort(original);
        System.out.println("Insertion sort : ");
        for(int x: original) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] original2 = {9,90,40,23,13,15,1,1000,12,80};
        System.out.println("Bubble sort : ");
        bubbleSort(original2);
        for(int x: original2) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] original3 = {9,90,40,23,13,15,1,1000,12,80};
        System.out.println("Selection sort : ");
        selectionSort(original3);
        for(int x: original3) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] original4 = {9,90,40,23,13,15,1,1000,12,80};
        System.out.println("Merge sort : ");
        MergeSort merge = new MergeSort();
        int[] sortedArray = merge.sort(original4, 0, original4.length-1);
        for(int x: sortedArray) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] original5 = {9,90,40,23,13,15,1,1000,12,80};
        System.out.println("Quick sort : ");
        QuickSort quick = new QuickSort();
        int[] sortedQuick = quick.sort(original5, 0, original5.length-1);
        for(int x: sortedQuick) {
            System.out.print(x + " ");
        }
        System.out.println();

    }

    public static void insertionSort(int[] original) {
       for(int i=1; i<original.length; i++) {
           int current = i;
           for(int j=1; j<=i; j++) {
               if(original[current] < original[i-j]) {
                   int temp = original[i-j];
                   original[i-j] = original[current];
                   original[current] = temp;
                   current = i-j;
               } else {
                   break; // in the correct position
               }
           }
       }
    }

    public static void bubbleSort(int[] original) {
        boolean changed;
        do {
            changed = false;
            for(int i=0; i<original.length-1; i++) {
                if(original[i] > original[i+1]) {
                    int temp = original[i];
                    original[i] = original[i+1];
                    original[i+1] = temp;
                    changed = true;
                }
            }
        } while (changed) ;

    }

    public static void selectionSort(int[] original) {
        int min, minIdx;
        int currentIdx = 0;
        while(currentIdx < original.length) {
            min = original[currentIdx];
            minIdx = currentIdx;
            for(int j=currentIdx; j<original.length; j++) {
                if (original[j] < min) {
                    min = original[j];
                    minIdx = j;
                }
            }
            int temp = original[minIdx];
            original[minIdx] = original[currentIdx];
            original[currentIdx] = temp;
            currentIdx++;
        }
    }
}
