import java.util.Hashtable;
import java.util.StringTokenizer;

public class Question1 {

// assumption for question is that there is only 1 solution to each problem
    public static void main(String[] args) {
        String numberList = args[0];
        int target = Integer.parseInt(args[1]);
        StringTokenizer numbers = new StringTokenizer(numberList, ",");
        int[] intNumbers = convertToIntArray(numbers);

        // First naive solution, time complexity O(n^2)
        System.out.println("Commencing naive solution");
        try  {
            int[] answer = naiveSolution(intNumbers, target);
            System.out.println("Found two sum solution, " + answer[0] + " + " + answer[1] + " = " + target);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Second two pass solution, time complexity O(n)
        System.out.println("Commencing two pass hash solution");
        try  {
            int[] answer = twoPassHashSolution(intNumbers, target);
            System.out.println("Found two sum solution, " + answer[0] + " + " + answer[1] + " = " + target);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Third one pass solution, time complexity O(n)
        System.out.println("Commencing one pass hash solution");
        try  {
            int[] answer = onePassHashSolution(intNumbers, target);
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
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++) {
                if(numbers[i] + numbers[j] == target) {
                    return new int[] {numbers[i], numbers[j]};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] twoPassHashSolution(int[] numbers, int target) throws Exception {
        // note to self: hashtable cannot use primitive data structures
        Hashtable<Integer, Integer> hashNumbers = new Hashtable<>();
        // first pass to hash values
        for(int i=0; i<numbers.length; i++) {
            hashNumbers.put(numbers[i], i);
        }
        for(int j=0; j<numbers.length; j++) {
            // check if hash table contains the complement & it is not referring to the same entry
            int complement = target-numbers[j];
            if(hashNumbers.containsKey(complement) && hashNumbers.get(complement)!=j) {
                return new int[] {numbers[j],complement};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int[] onePassHashSolution(int[] numbers, int target) throws Exception {
        int[] answer = new int[2];
        Hashtable<Integer, Integer> hashNumbers = new Hashtable<>();

        //while populating table, check complement
        for(int i=0; i<numbers.length; i++) {
            int complement = target-numbers[i];
            if(hashNumbers.containsKey(complement)) {
                return new int[] {numbers[i],complement};
            }
            // since i add after, don't have to use additional check in if statement
            hashNumbers.put(numbers[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
