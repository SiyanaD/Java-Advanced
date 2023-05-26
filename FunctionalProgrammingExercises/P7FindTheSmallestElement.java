package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P7FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt).collect(Collectors.toList());
        Integer findSmallestNumber = Collections.min(numbers);
        int lastIndex = numbers.lastIndexOf(findSmallestNumber);
        System.out.println(lastIndex);

    }
}
