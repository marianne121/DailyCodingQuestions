import java.util.StringTokenizer;

public class Question1 {

    public static void main(String[] args) {
        String numberList = args[0];
        int target = Integer.parseInt(args[1]);
        StringTokenizer numbers = new StringTokenizer(numberList, ",");
        int[] intNumbers = convertToIntArray(numbers);
        if(naiveSolution(intNumbers, target)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
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

    private static boolean naiveSolution(int[] numbers, int target) {
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
