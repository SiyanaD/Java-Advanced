package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String,Integer> parse = s->Integer.parseInt(s);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+")).map(elem->parse.apply(elem)).collect(Collectors.toList());

        int countNumbers = numbers.size();
        int sum = numbers.stream().mapToInt(a->a).sum();//a->a - identity functions- каквото подадем на входа това се появява на изхода

        System.out.printf("Count = %d%n",countNumbers);
        System.out.printf("Sum = %d%n",sum);

    }
}
