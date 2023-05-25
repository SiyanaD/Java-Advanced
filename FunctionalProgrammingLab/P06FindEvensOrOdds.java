package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).
                                 map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        Predicate<Integer> isEven = n->n%2==0;

        extracted(numbers, command, isEven);


    }

    private static void extracted(List<Integer> numbers, String command, Predicate<Integer> isEven) {
        int lowerBound = numbers.get(0);
        int upperBound = numbers.get(1);
        if (command.equals("odd")){
            for (int i = lowerBound; i <=upperBound ; i++) {
                if (!isEven.test(i)){
                    System.out.print(i + " ");
                }
            }
        }
        else {
            for (int i = lowerBound; i <=upperBound ; i++) {
                if (isEven.test(i)){
                    System.out.print(i + " ");
                }

            }
        }
    }
}
