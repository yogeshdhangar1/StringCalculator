import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    // Step-by-step method following TDD principles
    public int add(String numbers) throws Exception {
        if (numbers.isEmpty()) {
            return 0; // Return 0 for an empty input
        }

        String delimiter = ",|\n"; // Default delimiters: comma and newline

        // Check for custom delimiter in the input
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex); // Extract custom delimiter
            numbers = numbers.substring(delimiterIndex + 1);  // Remove delimiter line from input
        }

        String[] numberArray = numbers.split(delimiter); // Split the string by delimiter

        // Check for negative numbers
        List<Integer> negativeNumbers = Arrays.stream(numberArray)
                .map(Integer::parseInt)
                .filter(n -> n < 0)
                .collect(Collectors.toList());

        // If any negative numbers found, throw an exception with the list of negatives
        if (!negativeNumbers.isEmpty()) {
            throw new Exception("Negative numbers not allowed: " + negativeNumbers);
        }

        // Sum the parsed numbers and return the result
        return Arrays.stream(numberArray)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
