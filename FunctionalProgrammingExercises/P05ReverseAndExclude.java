package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
        //с нов лист взимаме числата който се делят на n

        numbers.removeIf(a->a%n==0);

//        List<Integer> removeNumbers =numbers.stream().filter(a->a%n==0).collect(Collectors.toList());
//       numbers.removeAll(removeNumbers);

        numbers.forEach(h-> System.out.print(h+ " "));
    }
}
