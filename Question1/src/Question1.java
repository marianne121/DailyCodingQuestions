import java.util.StringTokenizer;

public class Question1 {

// assumption for question is that there is only 1 solution to each problem
    public static void main(String[] args) {
        String numberList = args[0];
        int target = Integer.parseInt(args[1]);
        StringTokenizer numbers = new StringTokenizer(numberList, ",");
        int[] intNumbers = convertToIntArray(numbers);
        try  {
            int[] answer = naiveSolution(intNumbers, target);
            System.out.println("Found two sum solution, " + answer[0] + " + " + answer[1] + " = " + target);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

    private static int[] naiveSolution(int[] numbers, int target) throws Exception {
        int[] answer = new int[2];
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return answer;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
