import java.util.Arrays;
import java.util.StringTokenizer;

public class Question2 {

    public static void main(String[] args) {
        String numberList = args[0];
        StringTokenizer numbers = new StringTokenizer(numberList, ",");
        int[] intNumbers = convertToIntArray(numbers);

        System.out.println("Commencing simple solution using division");
        System.out.println("new array: " + Arrays.toString(simpleSolution(intNumbers)));

        System.out.println("Commencing solution without division");
        System.out.println("new array: " + Arrays.toString(noDivision(intNumbers)));

        System.out.println("Commencing solution without division without storing");
        System.out.println("new array: " + Arrays.toString(noDivisionUpgrade(intNumbers)));
    }

    private static int[] convertToIntArray(StringTokenizer input) {
        int[] intNumbers = new int[input.countTokens()];
        int length = input.countTokens();
        for(int i=0; i<length; i++) {
            if(input.hasMoreTokens()) {
                intNumbers[i] = Integer.parseInt(input.nextToken());
            }
        }
        return intNumbers;
    }

    private static int[] simpleSolution(int[] numbers) {
        int totalSum = 1;
        int[] newArray = new int[numbers.length];
        for(int currNumber : numbers) {
            totalSum = currNumber * totalSum;
        }
        for(int i=0; i<numbers.length; i++){
            newArray[i] = totalSum/numbers[i];
        }
        return newArray;
    }

    //Time complexity: O(n), space complexity: O(n)
    // Solution without division function, by using calculation of product of all elements on left and right
    // of current element.
    private static int[] noDivision(int[] numbers) {
        int size = numbers.length;
        // at left[i], holds product of all numbers on left of arr[i] except the one at arr[i];
        int[] left = new int[size];
        // at right [i], holds product of all numbers on right of arr[i] except the one at arr[i];
        int[] right = new int[size];
        int[] product = new int[size];

        left[0] = 1;
        right[size-1] = 1;
        for (int i=1; i<size; i++) {
            left[i] = left[i-1] * numbers[i-1];
        }
        for (int j=size-2; j>=0; j--) {
            right[j] = right[j+1] * numbers[j+1];
        }

        for (int t=0; t<size; t++) {
            product[t] = left[t] * right[t];
        }

        return product;
    }

    // trying to make an algorithm without division and with space complexity O(1)
    private static int[] noDivisionUpgrade(int[] numbers) {
        int size = numbers.length;
        int[] product = new int[size];
        product[0] = 1;
        for(int i=1; i<size; i++) {
            product[i] = product[i-1] * numbers[i-1];
        }
        int temp = 1;
        for(int j=size-2; j>=0; j--){
            temp = temp * numbers[j+1] ;
            product[j] = product[j] * temp;
        }
        return product;
    }
}
